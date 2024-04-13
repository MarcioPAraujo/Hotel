<%-- 
    Document   : Historico
    Created on : Apr 10, 2024, 5:33:59 PM
    Author     : mariailsa
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reserva"%>
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
            ArrayList<Reserva> historico = new ArrayList<>();
            historico = (ArrayList<Reserva>)request.getAttribute("historico");
        %>
        <h1>Histórico de <%out.print(user.getHospede().getNome());%></h1>
        <%for(Reserva r: historico){%>
        <div id="visualizacao">
            <p>dia da reserva: <%out.print(r.getDiaDaReserva());%> </p>
            <p>dias reservado: <%out.print(r.getDiasReservados());%></p>
            <p>data de expiração: <%out.print(r.getExpiracao());%></p>
            <p>valor da diaria: <%out.print(r.getDiaria());%></p>
            <p>despesas totais: <%out.print(r.getDespesasTotais());%></p>
            <p>serviços adicionais: <%out.print(r.getServicosAdicionais());%></p>
            <p>hospede: <%out.print(r.getHospede().getNome());%></p>
            <p>agência: <%out.print(r.getAgencia().getNome());%></p>
            <p>quarto: <%out.print(r.getQuarto().getNumero());%></p>
            
        </div>
        <%}%>
    </body>
</html>
