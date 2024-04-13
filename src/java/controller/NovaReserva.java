/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ReservaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agencia;
import model.Quarto;
import model.Reserva;
import model.User;

/**
 *
 * @author mariailsa
 */
@WebServlet(name = "adicionar", urlPatterns = {"/adicionar"})
public class NovaReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Login login = new Login();
            User globalUser = login.globalUser;

            ReservaDAO rdao = new ReservaDAO();
            Reserva reserva = new Reserva();
            Agencia agencia = new Agencia();
            Quarto quarto = new Quarto();

            String message = "";

            reserva = rdao.getReserva(globalUser.getHospede());
            if (reserva.getId() != 0) {
                message = "você já possui uma reserva";
                request.setAttribute("message", message);
                request.getRequestDispatcher("PaginasDinamicas/Mensagem.jsp").forward(request, response);
            } else {

                reserva.setDiaDaReserva(request.getParameter("dia_da_reserva"));
                reserva.setExpiracao(request.getParameter("dia_de_expiracao"));
                reserva.setServicosAdicionais(Byte.parseByte(request.getParameter("servicos")));

                agencia.setId(Integer.parseInt(request.getParameter("agencia")));
                quarto.setNumero(Integer.parseInt(request.getParameter("quarto")));
                reserva.setHospede(globalUser.getHospede());
                quarto.setClassificacao(request.getParameter("classe"));
                reserva.setQuarto(quarto);
                reserva.setAgencia(agencia);

                double despesaTotal = 0;
                double diaria = 0;
                if (reserva.getServicosAdicionais() == 1) {
                    despesaTotal += 100;
                }
                switch (reserva.getQuarto().getClassificacao()) {
                    case "A":
                        diaria = 200;
                        despesaTotal += diaria;
                        break;
                    case "B":
                        diaria = 150;
                        despesaTotal += diaria;
                        break;
                    case "C":
                        diaria = 100;
                        despesaTotal += diaria;
                        break;
                    default:
                        diaria = 50;
                        despesaTotal += diaria;
                }

                reserva.setDiaria(diaria);
                reserva.setDespesasTotais(despesaTotal);

                rdao.insertNewReserva(reserva);

                request.setAttribute("reserva", reserva);
                request.getRequestDispatcher("PaginasDinamicas/VerReserva.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
