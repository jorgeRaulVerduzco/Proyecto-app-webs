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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
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
        try {
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

            // Manejo de imagen de perfil mejorado
            String urlImagen = handleProfileImage(request, nombreUsuario);

            // Crear el DTO del usuario (código anterior se mantiene igual)
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre(nombre);
            usuarioDTO.setApellidoPaterno(apellidoPaterno);
            usuarioDTO.setApellidoMaterno(apellidoMaterno);
            usuarioDTO.setCorreo(correo);
            usuarioDTO.setNombreUsuario(nombreUsuario);
            usuarioDTO.setContrasenia(contrasenia);
            usuarioDTO.setTelefono(telefono);
            usuarioDTO.setGenero(genero);
            usuarioDTO.setUrlImagen(urlImagen);

            // Conversión de fecha (código anterior se mantiene)
            if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date fecha = sdf.parse(fechaNacimiento);
                    usuarioDTO.setFechaNacimiento(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            // Resto del código anterior para roles, municipio, etc.
            RolDTO rolDTO = new RolDTO();
            rolDTO.setTipoRol("usuario");
            usuarioDTO.setRol(rolDTO);

            MunicipioDTO municipioDTO = new MunicipioDTO();
            municipioDTO.setNombre(municipio);
            usuarioDTO.setMunicipio(municipioDTO);

            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setNombre(estado);
            usuarioDTO.setEstado(estadoDTO);

            // Registrar usuario
            usuarioBO.registrarUsuario(usuarioDTO);
            response.sendRedirect("JSP/Login.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Manejar el error de manera más robusta
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el registro");
        }
    }

    private String handleProfileImage(HttpServletRequest request, String nombreUsuario) throws IOException, ServletException {
        Part filePart = request.getPart("imagen");

        // Configurar directorio de subida con múltiples estrategias
        String uploadPath = determineUploadPath();

        // Crear directorio si no existe
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            boolean dirCreated = uploadDir.mkdirs();
            if (!dirCreated) {
                // Log de error si no se puede crear el directorio
                System.err.println("No se pudo crear el directorio: " + uploadPath);
            }
        }

        // Manejar imagen
        if (filePart != null && filePart.getSize() > 0) {
            try {
                // Generar nombre de archivo único y seguro
                String fileName = generateSafeFileName(nombreUsuario, filePart);
                String filePath = uploadPath + File.separator + fileName;

                // Validar y guardar archivo
                File file = new File(filePath);
                try (InputStream input = filePart.getInputStream(); OutputStream output = new FileOutputStream(file)) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                }

                // Devolver ruta relativa para almacenar en base de datos
                return "uploads/perfiles/" + fileName;
            } catch (IOException e) {
                System.err.println("Error al guardar imagen: " + e.getMessage());
                // Imagen por defecto en caso de error
                return "uploads/perfiles/default-profile.png";
            }
        } else {
            // Imagen por defecto si no se sube ninguna
            return "uploads/perfiles/default-profile.png";
        }
    }
private String determineUploadPath() {
    // Múltiples estrategias para determinar ruta de subida
    String[] possiblePaths = {
        getServletContext().getRealPath("") + File.separator + "uploads" + File.separator + "perfiles",
        System.getProperty("catalina.home") + File.separator + "webapps" + File.separator + 
            getServletContext().getContextPath().replace("/", "") + File.separator + "uploads" + File.separator + "perfiles",
        System.getProperty("user.home") + File.separator + "uploads" + File.separator + "perfiles"
    };
    
    for (String path : possiblePaths) {
        File dir = new File(path);
        if (canWriteToDirectory(dir)) {
            System.out.println("Usando directorio: " + path);
            return path;
        }
    }
    
    // Última opción - directorio temporal
    return System.getProperty("java.io.tmpdir") + File.separator + "perfiles";
}

private boolean canWriteToDirectory(File dir) {
    if (!dir.exists()) {
        return dir.mkdirs();
    }
    return dir.canWrite();
}

private String generateSafeFileName(String nombreUsuario, Part filePart) {
    // Generar nombre de archivo único y seguro
    String timestamp = String.valueOf(System.currentTimeMillis());
    String fileExtension = getFileExtension(filePart);
    
    // Limpiar nombre de usuario para usar en nombre de archivo
    String cleanNombreUsuario = nombreUsuario.replaceAll("[^a-zA-Z0-9.-]", "_");
    
    return "perfil_" + cleanNombreUsuario + "_" + timestamp + fileExtension;
}

private String getFileExtension(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    for (String cd : contentDisp.split(";")) {
        if (cd.trim().startsWith("filename")) {
            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            int lastDotIndex = filename.lastIndexOf('.');
            return (lastDotIndex > 0) ? "." + filename.substring(lastDotIndex + 1) : ".jpg";
        }
    }
    return ".jpg"; // Extensión por defecto
}
}
