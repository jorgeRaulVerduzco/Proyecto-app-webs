/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.CategoriaDTO;
import DTO.PostDTO;
import DTO.UsuarioDTO;
import Negocio.PostBO;
import Negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author INEGI
 */
@WebServlet("/CrearPublicacion")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
    maxFileSize = 1024 * 1024 * 10,       // 10MB
    maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class CrearPublicacionServlet extends HttpServlet {
    private PostBO postBO;
    private UsuarioBO usuarioBO;

    public CrearPublicacionServlet() {
        this.postBO = new PostBO();
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
            out.println("<title>Servlet CrearPublicacionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearPublicacionServlet at " + request.getContextPath() + "</h1>");
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
        // Verificar autenticación para mostrar página de crear publicación
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("JSP/Login.jsp");
            return;
        }
        
        request.getRequestDispatcher("/JSP/Publicaciones.jsp").forward(request, response);
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
        
        // Obtener la sesión y el usuario
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("JSP/Login.jsp");
            return;
        }

        UsuarioDTO usuarioLogueado = (UsuarioDTO) session.getAttribute("usuario");

        // Obtener parámetros del formulario
     // Obtener parámetros del formulario
    String titulo = request.getParameter("titulo");  // Cambiado de getSubmittedFileName()
    String contenido = request.getParameter("contenido");
    String categoria = request.getParameter("categoria");
    boolean anclar = request.getParameter("anclar") != null;

        // Manejar la imagen
        Part filePart = request.getPart("archivo");
        String fileName = null;
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String urlImagen = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            urlImagen = "uploads/" + fileName;
        }

        // Crear DTO para la publicación
        PostDTO postDTO = new PostDTO();
        postDTO.setTitulo(titulo);
        postDTO.setContenido(contenido);
        postDTO.setUrlImagen(urlImagen);
        postDTO.setTipoPost(anclar ? "anclada" : "normal");

        // Crear y setear categoría
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre(categoria);
        postDTO.setCategoria(categoriaDTO);

        // Setear usuario
        postDTO.setUsuario(usuarioLogueado);

        // Registrar publicación
        postBO.registrarPublicacion(postDTO);

        // Redirigir
        response.sendRedirect("Post");
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
