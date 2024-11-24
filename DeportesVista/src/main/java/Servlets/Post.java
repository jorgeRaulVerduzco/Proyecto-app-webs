/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

//Objetos de negocio
import DTO.PostDTO;
import Negocio.PostBO;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author copad
 */
public class Post extends HttpServlet {
    
    private PostBO postBO;
    
    public Post(){
        this.postBO= new PostBO();
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
            out.println("<title>Servlet Post</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Post at " + request.getContextPath() + "</h1>");
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
    try (PrintWriter out = response.getWriter()) {
        List<PostDTO> postList = postBO.consultarPublicaciones();
        
        for(PostDTO p: postList){
            out.println("<article class='publicacion-normal'>");
            out.println("<div class='usuario'>");
            out.println("<div class='usuarioImg'>");
            out.println("<img src='' alt=''>");
            out.println("</div>");
            out.println("<div class='usuarioNombre'>");
            out.println("<span>"+p.getUsuario().getNombreUsuario()+"</span>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class='descripcion'>");
            out.println("<h3>"+p.getTitulo()+"</h3>");
            out.println("<p>");
            out.println(p.getContenido());
            out.println("</p>");
            out.println("</div>");

            out.println("<img src='"+p.getUrlImagen()+"' alt='Stephen Curry' class='imagen-publicacion'>");
            out.println("<br>");
            out.println("<div class='interacciones'>");
            out.println("<div class='historia'>");
            out.println("<span>Likes: 123</span>");
            out.println("<span>Comentarios: 45</span>");
            out.println("<span>Me gusta</span>");
            out.println("</div>");

            // Aquí agregamos el ID del post en el atributo data-id
            out.println("<div class='bnt-gen'>");
            out.println("<button class='btn-comentar' data-id='"+p.getID()+"'>");
            out.println("<svg xmlns='http://www.w3.org/2000/svg' class='icono-comentar' width='21' height='21' viewBox='0 0 24 24' fill='none' stroke='#6c757d' stroke-width='0.1' stroke-linecap='round' stroke-linejoin='round'>");
            out.println("<path fill='#858b93' d='M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z'></path>");
            out.println("</svg>");
            out.println("<span class='contenedorNombre'>Comentar</span>");
            out.println("</button>");

            out.println("<button class='btn-megusta '>");
            out.println("<div id='animateElement' class='animate__animated'>");
            out.println("<svg xmlns='http://www.w3.org/2000/svg' class='icono-megusta' width='21' height='21' viewBox='0 0 24 24' fill='#858b93' stroke='none' stroke-width='0.1' stroke-linecap='round' stroke-linejoin='round'>");
            out.println("<path d='M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z'></path>");
            out.println("</svg>");
            out.println("<svg xmlns='http://www.w3.org/2000/svg' class='icono-megusta hidden' width='21' height='21' viewBox='0 0 24 24' fill='none' stroke='none' stroke-width='0.1' stroke-linecap='round' stroke-linejoin='round'>");
            out.println("<path d='M20.884 13.19c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z'></path>");
            out.println("</svg>");
            out.println("</div>");
            out.println("<span class='contenedorNombre'>Me gusta</span>");
            out.println("</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("</article>");
        }
    } catch (Exception e) {
        e.printStackTrace();
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
