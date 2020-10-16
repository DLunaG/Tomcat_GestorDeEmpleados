<%-- 
    Document   : addEmployee
    Created on : 16 oct. 2020, 11:25:50
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Add an employee</h4>
        
        <form action = "/GestorEmpleados/AddEmployee" method = "post">
            Name: <input type = "text" name = "name">
            <br />
            Ubication:  <select name="ubication">
                <c:forEach items="${ubications}" var="u">
                            <option>${u.name}</option>
                </c:forEach>
                        </select>
            <br />
            Salary: <input type = "number" name = "salary">
            <br />
            <input type = "submit" value = "Submit" />
        </form>
        
        
        
    </body>
</html>
