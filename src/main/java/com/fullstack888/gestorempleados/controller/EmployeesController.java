package com.fullstack888.gestorempleados.controller;

import com.fullstack888.gestorempleados.services.HResourcesService;
import com.fullstack888.gestorempleados.domain.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class EmployeesController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HResourcesService hr = new HResourcesService();
        List<Employee> employees = hr.selectEmployees();
        
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("employees", employees);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employees.jsp");
        rd.forward(request, response);
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
