/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.ComentarioDTO;
import DTO.PostDTO;
import Negocio.ComentarioBO;
import Negocio.PostBO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INEGI
 */

@WebServlet("/AdminPanel")
public class Administracion extends HttpServlet {
    private PostBO postBO;
    private ComentarioBO comentarioBO;

    public Administracion() {
        this.postBO = new PostBO();
        this.comentarioBO = new ComentarioBO();
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
            out.println("<title>Servlet Administracion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administracion at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtener la acción solicitada
        String action = request.getParameter("action");
        
        if (action == null) {
            // Mostrar panel administrativo por defecto
            mostrarPanelAdministrativo(request, response);
        } else {
            switch (action) {
                case "verPublicacion":
                    verPublicacion(request, response);
                    break;
                case "borrarPublicacion":
                    borrarPublicacion(request, response);
                    break;
                case "borrarComentario":
                    borrarComentario(request, response);
                    break;
                default:
                    mostrarPanelAdministrativo(request, response);
            }
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
        String action = request.getParameter("action");
        
        if ("editarPublicacion".equals(action)) {
            editarPublicacion(request, response);
        }
    }
    
    
    private void mostrarPanelAdministrativo(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obtener todas las publicaciones
        List<PostDTO> publicaciones = postBO.consultarPublicaciones();
        
        // Obtener todos los comentarios
        List<ComentarioDTO> comentarios = comentarioBO.consultarTodosLosComentarios();
        
        // Formatear la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Panel Administrativo</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }");
            out.println("table, th, td { border: 1px solid black; }");
            out.println("th, td { padding: 10px; text-align: left; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("button { background-color: red; color: white; padding: 5px 10px; border: none; cursor: pointer; }");
            out.println("button:hover { background-color: darkred; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Panel Administrativo</h1>");
            
            // Sección de Publicaciones
            out.println("<h2>Publicaciones</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Título</th>");
            out.println("<th>Contenido</th>");
            out.println("<th>Autor</th>");
            out.println("<th>Fecha Creación</th>");
            out.println("<th>Acciones</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody id='publicaciones-lista'>");
            
            // Imprimir publicaciones
            if (publicaciones != null) {
                for (PostDTO p : publicaciones) {
                    out.println("<tr>");
                    out.println("<td>" + p.getID() + "</td>");
                    out.println("<td>" + p.getTitulo() + "</td>");
                    out.println("<td>" + p.getContenido() + "</td>");
                    out.println("<td>" + p.getUsuario().getNombreUsuario() + "</td>");
                    out.println("<td>" + sdf.format(p.getFechaCreacion()) + "</td>");
                    out.println("<td>");
                    out.println("<button onclick='verPublicacion(" + p.getID() + ")'>Ver</button>");
                    out.println("<button onclick='borrarPublicacion(" + p.getID() + ")'>Borrar</button>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
            
            out.println("</tbody>");
            out.println("</table>");
            
            // Sección de Comentarios
            out.println("<h2>Comentarios</h2>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Contenido</th>");
            out.println("<th>Autor</th>");
            out.println("<th>Fecha</th>");
            out.println("<th>Acciones</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody id='comentarios-lista'>");
            
            // Imprimir comentarios
            if (comentarios != null) {
                for (ComentarioDTO c : comentarios) {
                    out.println("<tr>");
                    out.println("<td>" + c.getId() + "</td>");
                    out.println("<td>" + c.getContenido() + "</td>");
                    out.println("<td>" + c.getUsuario().getNombreUsuario() + "</td>");
                    out.println("<td>" + sdf.format(c.getFechaHora()) + "</td>");
                    out.println("<td>");
                    out.println("<button onclick='verComentario(" + c.getId() + ")'>Ver</button>");
                    out.println("<button onclick='borrarComentario(" + c.getId() + ")'>Borrar</button>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
            
            out.println("</tbody>");
            out.println("</table>");
            
            // Script para manejar acciones
            out.println("<script>");
            out.println("function verPublicacion(id) {");
            out.println("    window.location.href = 'AdminPanel.jsp?action=verPublicacion&id=' + id;");
            out.println("}");
            
            out.println("function borrarPublicacion(id) {");
            out.println("    if (confirm('¿Estás seguro de borrar esta publicación?')) {");
            out.println("        window.location.href = 'AdminPanel.jsp?action=borrarPublicacion&id=' + id;");
            out.println("    }");
            out.println("}");
            
            out.println("function verComentario(id) {");
            out.println("    alert('Ver comentario con ID: ' + id);");
            out.println("}");
            
            out.println("function borrarComentario(id) {");
            out.println("    if (confirm('¿Estás seguro de borrar este comentario?')) {");
            out.println("        window.location.href = 'AdminPanel.jsp?action=borrarComentario&id=' + id;");
            out.println("    }");
            out.println("}");
            out.println("</script>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void verPublicacion(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PostDTO post = postBO.consultarPublicacionesById(id);
        List<ComentarioDTO> comentarios = comentarioBO.consultarComentarios(id);
        
        request.setAttribute("post", post);
        request.setAttribute("comentarios", comentarios);
        request.getRequestDispatcher("/JSP/VerPublicacion.jsp").forward(request, response);
    }

    private void borrarPublicacion(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        postBO.eliminarPublicacion(id);
        response.sendRedirect("Administracion2");
    } catch (NumberFormatException e) {
        request.setAttribute("error", "ID de publicación inválido.");
        request.getRequestDispatcher("/JSP/Error.jsp").forward(request, response);
    }
}


    private void borrarComentario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        comentarioBO.eliminarComentario(id);
        response.sendRedirect("Administracion2");
    }

    private void editarPublicacion(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        PostDTO postDTO = new PostDTO();
        postDTO.setTitulo(titulo);
        postDTO.setContenido(contenido);
        
        postBO.editarPublicacion(id, postDTO);
        response.sendRedirect("AdminPanel.jsp");
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
