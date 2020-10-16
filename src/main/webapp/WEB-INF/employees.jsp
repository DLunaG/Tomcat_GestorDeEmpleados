
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/layout/headboard.jsp" %>
        <h1>Employees</h1>
        <table border="1">
        <tbody>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Ubicación</th>
                <c:if test="${login.user.admin == true}">
                    <th>Salario</th>
                    <th>Acciones</th>
                </c:if>
            </tr>
            <c:forEach items="${employees}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.ubication.name}</td>
                <c:if test="${login.user.admin == true}">
                    <td>${e.salary}</td>
                    <td>edit, delete</td>
                </c:if>
            </tr>
            </c:forEach>
        </tbody>
        </table>
                
    </body>
</html>
