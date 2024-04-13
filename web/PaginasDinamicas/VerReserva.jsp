<%-- 
    Document   : VerReserva
    Created on : Apr 12, 2024, 1:36:21 AM
    Author     : mariailsa
--%>

<%@page import="model.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Reserva</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Reserva reserva = (Reserva) request.getAttribute("reserva");
        %>
        
        
        
        <div id="visualizacao">
            <p>dia da reserva: <%out.print(reserva.getDiaDaReserva());%> </p>
            <p>dias reservado: <%out.print(reserva.getDiasReservados());%></p>
            <p>data de expiração: <%out.print(reserva.getExpiracao());%></p>
            <p>valor da diaria: <%out.print(reserva.getDiaria());%></p>
            <p>despesas totais: <%out.print(reserva.getDespesasTotais());%></p>
            <p>serviços adicionais: <%out.print(reserva.getServicosAdicionais());%></p>
            <p>hospede: <%out.print(reserva.getHospede().getNome());%></p>
            <p>agência: <%out.print(reserva.getAgencia().getNome());%></p>
            <p>quarto: <%out.print(reserva.getQuarto().getNumero());%></p>
            
        </div>
    </body>
</html>
