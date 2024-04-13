<%-- 
    Document   : EditarReserva
    Created on : Apr 11, 2024, 11:00:00 AM
    Author     : mariailsa
--%>

<%@page import="model.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Quarto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Reserva reserva = new Reserva();
        reserva = (Reserva) request.getAttribute("reserva");
        %>
        <form action="EditarReserva">
            <div>
                <label for="Idia_reserva"></label>
                <input name="dia_da_reserva" id="Idia_reserva" type="date" required value=<%out.print(reserva.getDiaDaReserva());%>>
            </div>
            <div>
                <label for="Idia_expira"></label>
                <input name="dia_de_expiracao" id="Idia_expira" type="date" required value=<%out.print(reserva.getExpiracao());%>>
            </div>
            <div>
                <legend>serviços adicionais</legend>
                <label for="sim">Sim</label><input name="servicos" type="radio" id="sim" value="1"> 
                <label for="nao">Não</label><input name="servicos" type="radio" id="nao" value="0">
            </div>

            <div>
                <%
                    ArrayList<Quarto> quartos = new ArrayList<>();
                    quartos = (ArrayList<Quarto>) request.getAttribute("quartos");
                %>
                <label for="Iquarto"></label>
                <select name="quarto" id="Iquarto">
                    <%for (Quarto quarto: quartos){%>
                    <option value=<%out.print(quarto.getNumero());%>><%out.print(quarto.getNumero()+" - "); out.print(quarto.getClassificacao());%></option>
                    <%}%>
                </select>
            </div>
            <div>
                <label for="Iclasse">classe do quarto</label>
                <select name="classe" id="Iclasse">
                    <%for (Quarto q:quartos){%>
                    <option value=<%out.print(q.getClassificacao());%>><%out.print(q.getClassificacao()+" - "); %></option>
                    <%}%>
                </select>
            </div>
                <input name="novaReserva" type="submit" value="registrar">
        </form>
    </body>
</html>
