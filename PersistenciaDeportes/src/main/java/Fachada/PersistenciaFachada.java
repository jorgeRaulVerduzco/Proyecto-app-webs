/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Entidades.Comentario;
import Entidades.Post;
import Entidades.Usuario;
import Excepciones.PersistenciaException;
import Factory.DaoFactory;
import Factory.IDaoFactory;
import IPersistencia.IComentarioDAO;
import IPersistencia.IPostDAO;
import IPersistencia.IUsuarioDAO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class PersistenciaFachada {

    private IDaoFactory daoFactory;
    private IUsuarioDAO usuarioDAO;
    private IPostDAO postDAO;
    private IComentarioDAO comentarioDAO;

    public PersistenciaFachada() {
        daoFactory = DaoFactory.getInstance();
        usuarioDAO = daoFactory.getUsuarioDAO();
        postDAO = daoFactory.getPostDAO();
        comentarioDAO = daoFactory.getComentarioDAO();
    }

    public void registrarUsuario(Usuario usuario) throws PersistenciaException {
        usuarioDAO.RegistrarUsuario(usuario);
    }

    public void registrarPublicacion(Post post) throws PersistenciaException {
        postDAO.registrarPublicacion(post);
    }

    public List<Post> consultarPublicaciones() throws PersistenciaException {
        return postDAO.consultarPublicaciones();
    }

    public void registrarComentario(Comentario comentario, int idPublicacion) throws PersistenciaException {
        comentarioDAO.registrarComentario(comentario, idPublicacion);
    }

    public void darLikePublicacion(int idPublicacion) throws PersistenciaException {
        postDAO.darLike(idPublicacion);
    }

    public List<Comentario> consultarComentarios(int idPublicacion) throws PersistenciaException {
        return comentarioDAO.consultarComentarios(idPublicacion);
    }

    public boolean iniciarSesion(String usuario, String contrasenia) throws PersistenciaException {
        return usuarioDAO.IniciarSesion(usuario, contrasenia);
    }

    public void editarPublicacion(int idPost, Post post) throws PersistenciaException {
        postDAO.editarPublicacion(idPost, post);
    }

    public void eliminarPublicacion(int idPost) throws PersistenciaException {
        postDAO.eliminarPublicacion(idPost);
    }

    public void anclarPost(int idPost) throws PersistenciaException {
        postDAO.anclarPost(idPost);
    }

    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) throws PersistenciaException {
        comentarioDAO.registrarComentarioAnclado(idPublicacion, comentario);
    }

    public boolean eliminarComentario(int idComentario) throws PersistenciaException {
        return comentarioDAO.eliminarComentario(idComentario);
    }
}
