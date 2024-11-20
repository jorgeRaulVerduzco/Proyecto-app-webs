/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.EstadoDTO;
import DTO.MunicipioDTO;
import DTO.RolDTO;
import DTO.UsuarioDTO;
import Negocio.UsuarioBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
@WebServlet("/Registrar")
public class RegistrarServlet extends HttpServlet {

    private UsuarioBO usuarioBO;

    public RegistrarServlet() {
        this.usuarioBO = new UsuarioBO(); // Inicializamos el objeto de negocio
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
            out.println("<title>Servlet RegistrarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarServlet at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            // Datos básicos
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String correo = request.getParameter("email");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        
        // Ubicación
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        
        // Crear el DTO del usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(nombre);
        usuarioDTO.setApellidoPaterno(apellidoPaterno);
        usuarioDTO.setApellidoMaterno(apellidoMaterno);
        usuarioDTO.setCorreo(correo);
        usuarioDTO.setNombreUsuario(nombreUsuario);
        usuarioDTO.setContrasenia(contrasenia);
        usuarioDTO.setTelefono(telefono);
        usuarioDTO.setGenero(genero);
        
        // Convertir y setear la fecha
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fecha = sdf.parse(fechaNacimiento);
                usuarioDTO.setFechaNacimiento(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        // Crear y setear el rol
        RolDTO rolDTO = new RolDTO();
        rolDTO.setTipoRol("usuario");
        usuarioDTO.setRol(rolDTO);
        
        // Crear y setear municipio
        MunicipioDTO municipioDTO = new MunicipioDTO();
        municipioDTO.setNombre(municipio);
        usuarioDTO.setMunicipio(municipioDTO);
        
        // Crear y setear estado
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setNombre(estado);
        usuarioDTO.setEstado(estadoDTO);

        // Registrar usuario
        usuarioBO.registrarUsuario(usuarioDTO);
        response.sendRedirect("JSP/Login.jsp");
        }
    }

