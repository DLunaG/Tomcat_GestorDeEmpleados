/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados.controller;

import com.fullstack888.gestorempleados.domain.Employee;
import com.fullstack888.gestorempleados.domain.Ubication;
import com.fullstack888.gestorempleados.services.HResourcesService;
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
public class AddEmployeeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HResourcesService hr = new HResourcesService();
        List<Ubication> ubications = hr.selectUbications();
        HttpSession mySession = request.getSession(true);
        mySession.setAttribute("ubications", ubications);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addEmployee.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HResourcesService hr = new HResourcesService();
        System.out.println("Hola");
        
        String name = (String)request.getParameter("name");
        String ubication = (String)request.getParameter("ubication");
        double salary = Double.parseDouble(request.getParameter("salary"));
        
        System.out.println("Cara de cola");
        
        Employee e = new Employee(name, new Ubication(hr.findIdUbication(ubication), ubication), salary);
        int insertResult = hr.insertAnEmployee(e);
        System.out.println("insertResult: " + insertResult);
        
        if(insertResult <= 0){
            HttpSession mySession = request.getSession(true);
            mySession.setAttribute("failInsert", "There was an error inserting the Employee.");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addEmployee.jsp");
            rd.forward(request, response);
        }
        
        if(insertResult >= 1){
            HttpSession mySession = request.getSession(true);
            List<Employee> employees = hr.selectEmployees();
            mySession.setAttribute("employees", employees);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employees.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
