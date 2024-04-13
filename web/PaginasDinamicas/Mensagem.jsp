<%-- 
    Document   : Mensagem
    Created on : Apr 11, 2024, 11:09:26 AM
    Author     : mariailsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem</title>
    </head>
    <body>
        <%
            String mensagem = (String) request.getAttribute("message");
           
        %>
        <h1><%out.print(mensagem);%></h1>
        
    </body>
</html>
