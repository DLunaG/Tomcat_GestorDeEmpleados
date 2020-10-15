<%@page import="com.fullstack888.gestorempleados.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/layout/headboard.jsp" %>
        <h1>Employees</h1>
        <% HttpSession mySession = request.getSession(false);
        List<Employee> employees = (List<Employee>)mySession.getAttribute("employees");
        %>
        <table border="1">
        <tbody>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Ubicación</th>
            </tr>
            <% for(Employee e: employees){ %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getName() %></td>
                <td><%= e.getUbication().getName() %></td>
            </tr>
            <% } %>
        </tbody>
        </table>
            
            
    </body>
</html>
