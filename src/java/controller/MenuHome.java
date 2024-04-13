/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/

import DAO.HistoricoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reserva;


/**
 *
 * @author mariailsa
 */
@WebServlet(name = "tabs", urlPatterns = {"/tabs"})
public class MenuHome extends HttpServlet {

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
            String tab = request.getParameter("menu");
            
            if(tab.equals("reservas")){
               
                request.getRequestDispatcher("PaginasDinamicas/MenuReservas.jsp").forward(request, response);
            }
            if(tab.equals("historico")){
                HistoricoDAO hdao = new HistoricoDAO();
                ArrayList<Reserva> historico = new ArrayList<>();
                historico = hdao.getAllReservas(globalUser.getHospede());
                request.setAttribute("historico", historico);
                request.setAttribute("user", globalUser);
                request.getRequestDispatcher("PaginasDinamicas/Historico.jsp").forward(request, response);
            }
            if(tab.equals("perfil")){
                request.setAttribute("user", globalUser);
                request.getRequestDispatcher("PaginasDinamicas/Perfil.jsp").forward(request, response);
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
