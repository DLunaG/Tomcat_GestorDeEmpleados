<%-- 
    Document   : headboard
    Created on : 15 oct. 2020, 13:30:08
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Hello ${login.user.name}. <a href="http://localhost:8080/GestorEmpleados/Logout">Logout</a></h4>
        <p> hiperlinks <a href="http://localhost:8080/GestorEmpleados/AddEmployee">Add employee</a>, ubications </p> 
    </body>
</html>
