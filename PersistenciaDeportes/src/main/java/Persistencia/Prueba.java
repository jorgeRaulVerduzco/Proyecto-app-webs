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
        prueba1(fachada);

    }
    public static void pruebaComentarios(PersistenciaFachada fachada){
        try {
            Usuario usuario = fachada.obtenerPorId(5);
            System.out.println(usuario.getNombre());

            Comentario nuevoComentario = new Comentario();
            nuevoComentario.setContenido("contenido del comentario");
            nuevoComentario.setFechaHora(new Date());
            nuevoComentario.setUsuario(usuario);

            Post nuevaPublicacion = fachada.consultarPublicacioneById(2);
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
        nuevoUsuario.setUrlImagen("http://localhost");
        

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
        nuevaPublicacion.setTitulo("Messi has 'more years to play', but unwilling to make World Cup commitment");
        nuevaPublicacion.setContenido("Lionel Messi has not given any thought to his retirement, though the Argentina legend has again refused to commit to playing at the 2026 World Cup.\r\n" + //
                        "\r\n" + //
                        "One day before he celebrated the 20th anniversary of his senior debut for Barcelona, Messi recorded five goal involvements (three goals, two assists) in Argentina's 6-0 rout of Bolivia on Tuesday.");
        nuevaPublicacion.setTipoPost("anclada");
        nuevaPublicacion.setUrlImagen("https://prod-media.beinsports.com/image/1729203628634_ee83c009-2cdd-4d56-afdc-2f15f30d31e5.jpg");
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
        nuevoComentario.setContenido("his decision to turn his back on Europe led many to suggest the end of his career was near");
        nuevoComentario.setFechaHora(new Date());
        nuevoComentario.setUsuario(nuevoUsuario);

        try {
            fachada.registrarComentario(nuevoComentario, 1);
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
