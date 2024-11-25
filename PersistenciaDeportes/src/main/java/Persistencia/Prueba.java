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
import Excepciones.PersistenciaException;
import Fachada.PersistenciaFachada;
import Factory.DaoFactory;
import Factory.IDaoFactory;
import IPersistencia.IComentarioDAO;
import IPersistencia.IPostDAO;
import IPersistencia.IUsuarioDAO;
import java.util.ArrayList;
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
        PersistenciaFachada fachada = new PersistenciaFachada();
        /**
         * 
         */
        try {
            List<Comentario> comentario = fachada.consultarComentarios(2);
            for (Comentario comentario1 : comentario) {
                System.out.println("Comentario: " + comentario1.toString());
            }
        } catch (PersistenciaException e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
            e.printStackTrace();
        }

         

         
         

         


    }
    public static void pruebaComentarios(PersistenciaFachada fachada){
        try {
            Usuario usuario = fachada.obtenerPorId(5);
            System.out.println(usuario.getNombre());

            Comentario nuevoComentario = new Comentario();
            nuevoComentario.setContenido("contenido del comentario");
            nuevoComentario.setFechaHora(new Date());
            nuevoComentario.setUsuario(usuario);

            Post nuevaPublicacion = fachada.consultarPublicacionePorId(2);
            System.out.println("Título: " + nuevaPublicacion.getTitulo());

            fachada.registrarComentario(nuevoComentario, nuevaPublicacion.getId());
        } catch (PersistenciaException e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
            e.printStackTrace();
        }

    }
    public static void prueba1(PersistenciaFachada fachada){
        Rol rol = new Rol();
        rol.setTipoRol("admin");

        Municipio municipio = new Municipio();
        municipio.setNombre("Obregon");

        Estado estado = new Estado();
        estado.setNombre("Sonora");
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Jorge");
        nuevoUsuario.setApellidoPaterno("Verduzco");
        nuevoUsuario.setApellidoMaterno("Mora");
        nuevoUsuario.setCorreo("jjorge@gmail.com");
        nuevoUsuario.setNombreUsuario("jorgendo43");
        nuevoUsuario.setContrasenia("password");
        nuevoUsuario.setTelefono("1234567890");
        nuevoUsuario.setFechaNacimiento(new Date());

        nuevoUsuario.setRol(rol);
        nuevoUsuario.setMunicipio(municipio);
        nuevoUsuario.setEstado(estado);
        nuevoUsuario.setGenero("masculino");

        try {
            fachada.registrarUsuario(nuevoUsuario);
            System.out.println("Usuario registrado: " + nuevoUsuario.toString());
        } catch (PersistenciaException e) {
            System.err.println("Error al registrar el usuario: " + e.getMessage());
            e.printStackTrace();
        }

        Categoria nuevaCategoria = new Categoria();
        nuevaCategoria.setNombre("General");

        Post nuevaPublicacion = new Post();
        nuevaPublicacion.setFechaCreacion(new Date());
        nuevaPublicacion.setTitulo("Curry es el mejorcito");
        nuevaPublicacion.setContenido("yo creo que curry es el goat");
        nuevaPublicacion.setTipoPost("normal");
        nuevaPublicacion.setUrlImagen("https://pbs.twimg.com/media/FnU_6aDaMAAkOyz.jpg");
        nuevaPublicacion.setUsuario(nuevoUsuario);
        nuevaPublicacion.setCategoria(nuevaCategoria);

        try {
            fachada.registrarPublicacion(nuevaPublicacion);
            System.out.println("Publicación registrada: " + nuevaPublicacion.getTitulo());
        } catch (PersistenciaException e) {
            System.err.println("Error al registrar la publicación: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            List<Post> publicaciones = fachada.consultarPublicaciones();
            System.out.println("Publicaciones:");
            for (Post post : publicaciones) {
                System.out.println("- " + post.getTitulo());
            }
        } catch (PersistenciaException e) {
            System.err.println("Error al consultar las publicaciones: " + e.getMessage());
            e.printStackTrace();
        }

        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setContenido("si le sabes");
        nuevoComentario.setFechaHora(new Date());
        nuevoComentario.setUsuario(nuevoUsuario);

        try {
            fachada.registrarComentario(nuevoComentario, nuevaPublicacion.getId());
            System.out.println("Comentario registrado: " + nuevoComentario.getContenido());
        } catch (PersistenciaException e) {
            System.err.println("Error al registrar el comentario: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            fachada.darLikePublicacion(nuevaPublicacion.getId());
        } catch (PersistenciaException e) {
            System.err.println("Error al dar like a la publicación: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            List<Comentario> comentarios = fachada.consultarComentarios(nuevaPublicacion.getId());
            System.out.println("Comentarios en la publicación:");
            for (Comentario comentario : comentarios) {
                System.out.println("- " + comentario.getContenido());
            }
        } catch (PersistenciaException e) {
            System.err.println("Error al consultar los comentarios: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
