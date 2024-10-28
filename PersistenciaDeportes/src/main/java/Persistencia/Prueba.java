/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Persistencia;

import Entidades.Categoria;
import Entidades.Comentario;
import Entidades.Estado;
import Entidades.Municipio;
import Entidades.Post;
import Entidades.PostComentario;
import Entidades.Rol;
import Entidades.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear instancias de DAOs
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PostDAO postDAO = new PostDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Jorge");
        nuevoUsuario.setApellidoPaterno("Verduzco");
        nuevoUsuario.setApellidoMaterno("Mora");
        nuevoUsuario.setCorreo("jjorge@gmail.com");
        nuevoUsuario.setNombreUsuario("jorgendo43");
        nuevoUsuario.setContrasenia("password");
        nuevoUsuario.setTelefono("1234567890");
        nuevoUsuario.setFechaNacimiento(new Date());

        Rol rol = new Rol();
        rol.setTipoRol("admin");

        Municipio municipio = new Municipio();
        municipio.setNombre("Obregon");

        Estado estado = new Estado();
        estado.setNombre("Sonora");

        nuevoUsuario.setRol(rol);
        nuevoUsuario.setMunicipio(municipio);
        nuevoUsuario.setEstado(estado);
        nuevoUsuario.setGenero("masculino");
        usuarioDAO.RegistrarUsuario(nuevoUsuario);

        System.out.println("Usuario registrado: " + nuevoUsuario.getNombreUsuario());

        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setNombre("General");

        Post nuevaPublicacion = new Post();
        nuevaPublicacion.setFechaCreacion(new Date());
        nuevaPublicacion.setTitulo("Curry es el mejor");
        nuevaPublicacion.setContenido("yo creo que curry es el goat");
        nuevaPublicacion.setTipoPost("normal");
        nuevaPublicacion.setUsuario(nuevoUsuario);
        nuevaPublicacion.setCategoria(nuevaCategoria);

        postDAO.registrarPublicacion(nuevaPublicacion);
        System.out.println("Publicacion registrada: " + nuevaPublicacion.getTitulo());

        List<Post> publicaciones = postDAO.consultarPublicaciones();
        System.out.println("Publicaciones:");
        for (Post post : publicaciones) {
            System.out.println("- " + post.getTitulo());
        }

        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setContenido("si le sabes");
        nuevoComentario.setFechaHora(new Date());
        nuevoComentario.setUsuario(nuevoUsuario); 
        comentarioDAO.registrarComentario(nuevoComentario, nuevaPublicacion.getId());
        System.out.println("Comentario registrado: " + nuevoComentario.getContenido());

        PostComentario postComentario = new PostComentario();
        postComentario.setPost(nuevaPublicacion);
        postComentario.setComentario(nuevoComentario);

        
        postDAO.darLike(nuevaPublicacion.getId());
        // Consultar comentarios de la publicación
        List<Comentario> comentarios = comentarioDAO.consultarComentarios(nuevaPublicacion.getId());
        System.out.println("Comentarios en la publicacion:");
        for (Comentario comentario : comentarios) {
            System.out.println("- " + comentario.getContenido());
        }
        
        
    }
}
