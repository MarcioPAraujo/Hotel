<%-- 
    Document   : Home
    Created on : Apr 9, 2024, 11:34:27 AM
    Author     : mariailsa
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       
        <h1>Welcome!</h1>
        <img src="" alt="">
        <p>temos X vagas disponiveis</p>
        <form action="tabs">
            <input type="submit" name="menu" class="tab buttons" value="reservas">
            <input type="submit" name="menu" class="tab buttons" value="historico">
            <input type="submit" name="menu" class="tab buttons" value="perfil">
        </form>
        <!--
        <main>
        <div>
            <button class="tab buttons" value="home">HOME</button>
            <button class="tab buttons" value="reseravs">RESERVAS</button>
            <button class="tab buttons" value="historico">HISTÓRICO</button>
            <button class="tab buttons" value="perfil">PERFIL</button>
        </div>
        <div id="home">
            <h1>HOME</h1>
            <img src="" alt="">
            <p>temos X vagas disponiveis</p>
        </div>


        <div id="reserva" class="hided">
            <button>fazer reserva</button>
            <button>editar reserva</button>
            <button>cancelar reserva</button>
            <div id="vizualizacao">
                <p>dia da reserva: </p>
                <p>dias reservado: </p>
                <p>data de expiração: </p>
                <p>valor da diaria: </p>
                <p>despesas totais: </p>
                <p>serviços adicionais: </p>
                <p>hospede: </p>
                <p>agência: </p>
                <p>quarto: </p>
            </div>



            <div id="fazer-reserva" class="hided">
                <form action="Reservar">
                    <div>
                        <label for="Idia_reserva"></label>
                        <input name="dia_da_reserva" id="Idia_reserva" type="date" required>
                    </div>
                    <div>
                        <label for="Idia_expira"></label>
                        <input name="dia_de_expiracao" id="Idia_expira" type="date" required>
                    </div>
                    <div>
                        <legend>serviços adicionais</legend>
                        <label for="sim">Sim</label><input name="servicos" type="radio" id="sim" value="1"> 
                        <label for="nao">Não</label><input name="servicos" type="radio" id="nao" value="0">
                    </div>
                    <div>
                        <label for="Iagencia">Agência</label>
                        <select name="agencia" id="Iagencia">
                            <option value="vem do banco">vem do banco</option>
                        </select>
                    </div>
                    <div>
                        <label for="Iquarto"></label>
                        <select name="quarto" id="Iquarto">
                            <option value="numero do quarto">número do quero + classe</option>
                        </select>
                    </div>
                </form>
            </div>



        </div>


        <div id="historico" class="hided">

        </div>
        <div id="usuario" class="hided">

        </div>
    </main>
        -->
    </body>
</html>
