/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

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
import DTO.UsuarioDTO;
import Negocio.PostBO;
import jakarta.servlet.RequestDispatcher;
import Entidades.Comentario;
import Negocio.UsuarioBO;
import java.util.Date;

/**
 *
 * @author copad
 */
public class Comentarios extends HttpServlet {

    private ComentarioBO comentarioBo;
    private PostBO postBO;
    private int id;

    public Comentarios() {
        this.comentarioBo = new ComentarioBO();
        this.postBO = new PostBO();
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
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Ajustar la codificación
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    // Obtener el ID del usuario desde la sesión
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    System.out.println("email: " + email);

    // Obtener el comentario enviado por el fetch()
    String comentario = request.getParameter("comentario");
    System.out.println("Comentario recibido: " + comentario);
    System.out.println("id: " + id);

    // Verificar si el comentario está vacío
    if (comentario == null || comentario.trim().isEmpty()) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
        out.write("El comentario no puede estar vacío.");
        return;
    }

    UsuarioBO usuarioBO = new UsuarioBO();
    UsuarioDTO usua = usuarioBO.obtenerUsuarioPorEmail(email);
    Date fecha = new Date();

    ComentarioDTO com = new ComentarioDTO();
    com.setContenido(comentario);
    com.setFechaHora(fecha);
    com.setUsuario(usua);
    com.setNumLikes(0);

    ComentarioBO comentarios = new ComentarioBO();

    try {
        comentarios.registrarComentario(com, id);
        // Si llega aquí sin lanzar excepción, significa que se registró bien
        response.setStatus(HttpServletResponse.SC_OK); // 200
        out.write("Comentario registrado con éxito");
    } catch (Exception e) {
        System.err.println("Error al registrar comentario: " + e.getMessage());
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500
        out.write("Ocurrió un error al registrar el comentario.");
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
