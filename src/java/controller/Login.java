/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.HospedeDao;
import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.User;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

/**
 *
 * @author mariailsa
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            
            // encapsular regra de negócio
            String message = "";
            User user = new User();
            UserDAO udao = new UserDAO();
            user.setEmail(request.getParameter("mail"));
            user.setSenha(request.getParameter("senha"));
            
            User userFromDataBase = new User();
            userFromDataBase = udao.getUser(user);
            System.out.println(userFromDataBase.getEmail());
            System.out.println(user.getEmail());
            
           
            
           
            
            if(userFromDataBase.getEmail() == null){
                message = "dados inválidos";
                request.setAttribute("message", message);
                request.getRequestDispatcher("PaginasDinamicas/ErrorPage.jsp").forward(request, response);
            }else {
                
                boolean senhaValida = userFromDataBase.getSenha() == user.getSenha();
                
                if(senhaValida){
                
                //chamar a página home passando hospede
                /*HospedeDao hdao = new HospedeDao();
                user.setHospede(hdao.getHospede(userFromDataBase.getHospede()));
                */
                request.setAttribute("user", userFromDataBase);
                request.getRequestDispatcher("PaginasDinamicas/Home.jsp").forward(request, response);
                }
                message = "dados inválidos";
                request.setAttribute("message", message);
                request.getRequestDispatcher("PaginasDinamicas/ErrorPage.jsp").forward(request, response);
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

