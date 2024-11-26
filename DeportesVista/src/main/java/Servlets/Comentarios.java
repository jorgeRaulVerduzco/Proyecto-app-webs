/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.Comentario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

import Negocio.ComentarioBO;
import DTO.ComentarioDTO;
import DTO.PostDTO;
import Negocio.PostBO;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author copad
 */
public class Comentarios extends HttpServlet {
    
    private ComentarioBO comentarioBo;
    private PostBO postBO;
    
    public Comentarios(){
        this.comentarioBo=new ComentarioBO();
        this.postBO=new PostBO();
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
            out.println("<title>Servlet Comentarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comentarios at " + request.getContextPath() + "</h1>");
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
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    try {
        // Validar y obtener el parámetro 'id'
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El parámetro 'id' no es válido");
            return;
        }

        // Consultar la publicación por id
        PostDTO post = postBO.consultarPublicacionesById(id);

        // Consultar los comentarios usando el BO
        List<ComentarioDTO> comentarios = comentarioBo.consultarComentarios(id);

        // Pasar los datos a la solicitud
        request.setAttribute("id", id);
        request.setAttribute("post", post);
        request.setAttribute("comentarios", comentarios);
        
        // Redirigir a la página JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/VerComentarios.jsp");
        dispatcher.forward(request, response);

    } catch (Exception e) {
        e.printStackTrace(); // Registra el error en el servidor
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al consultar publicaciones");
    }
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
