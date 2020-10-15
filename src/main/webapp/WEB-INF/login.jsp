<%-- 
    Document   : login
    Created on : 15 oct. 2020, 12:52:01
    Author     : tecnara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/GestorEmpleados/Login" method="post">
          <label for="uname">Username:</label><br>
          <input type="text" id="uname" name="uname" value="User"><br>
          <label for="pass">Password:</label><br>
          <input type="password" id="pass" name="pass" value="Pass">
          <br/>
          <input type="submit" value="Send">
        </form>  
        
        <% HttpSession mySession = request.getSession(false);
        String invalidMsg = (String)mySession.getAttribute("invalidMsg"); 
        if (invalidMsg != null){%>
        <p style="color:red"> <%= invalidMsg %> Try again.</p>
        <% } %>
    </body>
</html>
