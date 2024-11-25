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

    /**
     * Constructor que inicializa la fábrica de DAOs y obtiene las instancias
     * correspondientes para las operaciones de usuario, publicación y
     * comentario.
     */
    public PersistenciaFachada() {
        daoFactory = DaoFactory.getInstance();
        usuarioDAO = daoFactory.getUsuarioDAO();
        postDAO = daoFactory.getPostDAO();
        comentarioDAO = daoFactory.getComentarioDAO();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario El usuario que se desea registrar.
     * @throws PersistenciaException Si ocurre un error durante el registro del
     * usuario.
     */
    public void registrarUsuario(Usuario usuario) throws PersistenciaException {
        usuarioDAO.RegistrarUsuario(usuario);
    }
    
    /**
     * Obtiene un usuario por su identificador único.
     *
     * @param id El identificador único del usuario a buscar.
     * @return El usuario encontrado con el identificador proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda del usuario.
     */
    public Usuario obtenerPorId(int id) throws PersistenciaException {
        return usuarioDAO.obtenerPorId(id);
    }


    /**
     * Registra una nueva publicación en el sistema.
     *
     * @param post La publicación que se desea registrar.
     * @throws PersistenciaException Si ocurre un error durante el registro de
     * la publicación.
     */
    public void registrarPublicacion(Post post) throws PersistenciaException {
        postDAO.registrarPublicacion(post);
    }

    /**
     * Consulta todas las publicaciones en el sistema.
     *
     * @return Una lista de todas las publicaciones.
     * @throws PersistenciaException Si ocurre un error al consultar las
     * publicaciones.
     */
    public List<Post> consultarPublicaciones() throws PersistenciaException {
        return postDAO.consultarPublicaciones();
    }

    /**
     * Registra un comentario en una publicación específica.
     *
     * @param comentario El comentario que se desea registrar.
     * @param idPublicacion El ID de la publicación a la que se asociará el
     * comentario.
     * @throws PersistenciaException Si ocurre un error al registrar el
     * comentario.
     */
    public void registrarComentario(Comentario comentario, int idPublicacion) throws PersistenciaException {
        comentarioDAO.registrarComentario(comentario, idPublicacion);
    }

    /**
     * Da un "like" a una publicación.
     *
     * @param idPublicacion El ID de la publicación a la que se le dará el
     * "like".
     * @throws PersistenciaException Si ocurre un error al dar el "like".
     */
    public void darLikePublicacion(int idPublicacion) throws PersistenciaException {
        postDAO.darLike(idPublicacion);
    }

    /**
     * Retrieves a specific post from the system using its unique identifier.
     *
     * @param idPublicacion The unique identifier of the post to be retrieved.
     * @return The post found with the provided identifier.
     * @throws PersistenciaException If an error occurs while searching for the post.
     */
    public Post consultarPublicacioneById (int idPublicacion) throws PersistenciaException {
        return postDAO.consultarPublicacionePorId(idPublicacion);
    }


    /**
     * Consulta todos los comentarios asociados a una publicación.
     *
     * @param idPublicacion El ID de la publicación cuyos comentarios se desean
     * consultar.
     * @return Una lista de comentarios asociados a la publicación.
     * @throws PersistenciaException Si ocurre un error al consultar los
     * comentarios.
     */
    public List<Comentario> consultarComentarios(int idPublicacion) throws PersistenciaException {
        return comentarioDAO.consultarComentarios(idPublicacion);
    }

    /**
     * Inicia sesión verificando las credenciales del usuario.
     *
     * @param usuario El nombre de usuario.
     * @param contrasenia La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error durante la validación de
     * las credenciales.
     */
    public boolean iniciarSesion(String usuario, String contrasenia) throws PersistenciaException {
        return usuarioDAO.IniciarSesion(usuario, contrasenia);
    }

    /**
     * Permite editar una publicación existente.
     *
     * @param idPost El ID de la publicación a editar.
     * @param post El objeto Post que contiene la información actualizada.
     * @throws PersistenciaException Si ocurre un error al editar la
     * publicación.
     */
    public void editarPublicacion(int idPost, Post post) throws PersistenciaException {
        postDAO.editarPublicacion(idPost, post);
    }

    /**
     * Elimina una publicación del sistema.
     *
     * @param idPost El ID de la publicación a eliminar.
     * @throws PersistenciaException Si ocurre un error al eliminar la
     * publicación.
     */
    public void eliminarPublicacion(int idPost) throws PersistenciaException {
        postDAO.eliminarPublicacion(idPost);
    }

    /**
     * Ancla una publicación, es decir, la hace destacada en el sistema.
     *
     * @param idPost El ID de la publicación a anclar.
     * @throws PersistenciaException Si ocurre un error al anclar la
     * publicación.
     */
    public void anclarPost(int idPost) throws PersistenciaException {
        postDAO.anclarPost(idPost);
    }

    /**
     * Registra un comentario anclado en una publicación específica.
     *
     * @param idPublicacion El ID de la publicación a la que se asociará el
     * comentario anclado.
     * @param comentario El comentario anclado que se desea registrar.
     * @throws PersistenciaException Si ocurre un error al registrar el
     * comentario anclado.
     */
    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) throws PersistenciaException {
        comentarioDAO.registrarComentarioAnclado(idPublicacion, comentario);
    }

    /**
     * Elimina un comentario específico.
     *
     * @param idComentario El ID del comentario a eliminar.
     * @return true si el comentario se eliminó correctamente, false si no
     * existía.
     * @throws PersistenciaException Si ocurre un error al eliminar el
     * comentario.
     */
    public boolean eliminarComentario(int idComentario) throws PersistenciaException {
        return comentarioDAO.eliminarComentario(idComentario);
    }

    /**
     * Obtiene un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario a buscar.
     * @return El usuario encontrado.
     * @throws PersistenciaException Si ocurre un error al buscar al usuario.
     */
    public Usuario obtenerUsuarioPorEmail(String email) throws PersistenciaException {
        return usuarioDAO.obtenerPorEmail(email);
    }

    /**
     * Inicia sesión verificando las credenciales del usuario por email
     *
     * @param email Email del usuario
     * @param contrasenia Contraseña del usuario
     * @return true si las credenciales son correctas, false en caso contrario
     * @throws PersistenciaException Si ocurre un error durante la validación
     */
    public boolean iniciarSesionFinal(String email, String contrasenia) throws PersistenciaException {
        return usuarioDAO.validarCredenciales(email, contrasenia);
    }
}
