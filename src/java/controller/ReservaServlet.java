/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AgenciaDAO;
import DAO.HistoricoDAO;
import DAO.HospedeDAO;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Agencia;
import model.Quarto;
import model.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 *
 * @author mariailsa
 */
@WebServlet(name = "reserva_actions", urlPatterns = {"/reserva_actions"})
public class ReservaServlet extends HttpServlet {

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
            reserva.setHospede(globalUser.getHospede());
            
            String option = request.getParameter("reservar");
            
            
            if(option.equals("editar")){
                reserva = rdao.getReserva(globalUser.getHospede());
                
                if(reserva.getId() == 0){
                    String message = "Você não possui reserva";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("PaginasDinamicas/Mensagem.jsp").forward(request, response);
                }else{
                    QuartoDAO qdao = new QuartoDAO();
                    ArrayList<Quarto> quartos = new ArrayList<>();
                    quartos = qdao.getAllRooms();

                    request.setAttribute("quartos", quartos);
                    request.setAttribute("reserva", reserva);
                    request.getRequestDispatcher("PaginasDinamicas/EditarReserva.jsp").forward(request, response);
                }
                
            }
            
            
            
            if(option.equals("cancelar reserva")){
                reserva.setHospede(globalUser.getHospede());
                reserva = rdao.getReserva(globalUser.getHospede());
                if(reserva.getId() == 0){
                    String message = "Você não possui reserva";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("PaginasDinamicas/Mensagem.jsp").forward(request, response);
                }else{
                    HistoricoDAO hdao = new HistoricoDAO();
                    hdao.insertNewReserva(reserva);
                    rdao.deleteReserva(reserva);
                    String message = "sua reserva foi cancelada";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("PaginasDinamicas/Mensagem.jsp").forward(request, response);
                }
            }
            
            
            
            if(option.equals("fazer reserva")){
               QuartoDAO qdao = new QuartoDAO();
               ArrayList<Quarto> quartos = new ArrayList<>();
               quartos = qdao.getAllRooms();
               
               AgenciaDAO adao = new AgenciaDAO();
               ArrayList<Agencia> agencias = new ArrayList<>();
               agencias = adao.getAllAgerncies();
               
               request.setAttribute("quartos", quartos);
               request.setAttribute("agencias", agencias);
               request.getRequestDispatcher("PaginasDinamicas/NovaReserva.jsp").forward(request, response);
                
            }
            if(option.equals("ver")){
               
                HospedeDAO hdao = new HospedeDAO();
                QuartoDAO qdao = new QuartoDAO();
                AgenciaDAO adao = new AgenciaDAO();
                
                reserva = rdao.getReserva(globalUser.getHospede());
                //se reserva é nula nao fazer busca no banco
                if(!(reserva.getId() == 0)){
                    reserva.setHospede(hdao.getHospede(reserva.getHospede()));
                    reserva.setQuarto(qdao.getRoom(reserva.getQuarto()));
                    reserva.setAgencia(adao.getAgency(reserva.getAgencia()));
                    
                    request.setAttribute("reserva", reserva);
                    request.setAttribute("user", globalUser);
                    
                    request.getRequestDispatcher("PaginasDinamicas/VerReserva.jsp").forward(request, response);
                }else{
                    String message = "Você não possui reserva";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("PaginasDinamicas/Mensagem.jsp").forward(request, response);
                }
                
                
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
