<%-- 
    Document   : Perfil
    Created on : Apr 10, 2024, 5:34:17 PM
    Author     : mariailsa
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("user");
        %>
        <h1>Bem vindo <%out.print(user.getHospede().getNome());%></h1>
        
    </body>
</html>
