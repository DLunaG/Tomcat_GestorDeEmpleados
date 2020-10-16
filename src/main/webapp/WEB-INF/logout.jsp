<%-- 
    Document   : logout
    Created on : 16 oct. 2020, 11:14:44
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="formDialogDiv" style="display: none;">
    <jsp:include page="/WEB-INF/layout/headboard.jsp"/>
</div>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Goodbye ${login.user.name}</h3>
        <a href="http://localhost:8080/GestorEmpleados">Main menu</a></h4>
    </body>
</html>
