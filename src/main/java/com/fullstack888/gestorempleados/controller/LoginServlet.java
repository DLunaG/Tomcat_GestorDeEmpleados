package com.fullstack888.gestorempleados.controller;

import com.fullstack888.gestorempleados.domain.User;
import com.fullstack888.gestorempleados.services.HResourcesService;
import com.fullstack888.gestorempleados.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DLG
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
       
        String userName = request.getParameter("uname");
        System.out.println(userName);
        String password = request.getParameter("pass");
        System.out.println(password);
        
        List<User> usersVerified = us.selectUsers().stream()
                .filter(user -> userName.equals(user.getName()) && password.equals(user.getPassword()))
                .collect(Collectors.toList());
        
        User userVerified = null;
        boolean userIsAdmin = false;
        if(!usersVerified.isEmpty()){
            userVerified = usersVerified.get(0);
            userIsAdmin = userVerified.isAdmin();
        }
        
        HttpSession mySession = request.getSession(true);
        if(userVerified == null){
            mySession.setAttribute("invalidMsg", "Username or password are incorrect.");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
            rd.forward(request, response);
        }
        
        if(userVerified != null && userIsAdmin){
            mySession.setAttribute("user", userVerified);
            HResourcesService hr = new HResourcesService();
            mySession.setAttribute("employees", hr.selectEmployees());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employees.jsp");
            rd.forward(request, response);
        }
        
        if(userVerified != null && !userIsAdmin){
            mySession.setAttribute("user", userVerified);
            HResourcesService hr = new HResourcesService();
            mySession.setAttribute("employees", hr.selectEmployees());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employees.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
