/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.UsuarioDTO;
import Negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ruben
 */
public class LoginServlet extends HttpServlet {

    private UsuarioBO usuarioBO;

    public LoginServlet() {
        this.usuarioBO = new UsuarioBO();
    }

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("login: " + email + " password: " + password);

        // Validar que los campos no estén vacíos
        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            request.setAttribute("error", "Por favor complete todos los campos");
            request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
            return;
        }

        try {
            boolean loginSuccess = usuarioBO.iniciarSesionFinal(email, password);
            if (loginSuccess) {
                UsuarioDTO usuario = usuarioBO.obtenerUsuarioPorEmail(email);
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("email", email);
                session.setAttribute("nombreUsuario", usuario.getNombreUsuario());

                // Redirige al servlet "Post" para cargar las publicaciones
                response.sendRedirect("Post");
            } else {
                request.setAttribute("error", "Email o contraseña incorrectos");
                request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error en servlet: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Error al iniciar sesión. Por favor intente nuevamente.");
            request.getRequestDispatcher("JSP/Login.jsp").forward(request, response);
        }
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
