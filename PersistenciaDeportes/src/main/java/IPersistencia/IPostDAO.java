/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Post;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPostDAO {

    /**
     * Registra una nueva publicación en la base de datos, incluyendo la fecha
     * de creación.
     *
     * @param post Objeto Post que se desea registrar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el registro de
     * la publicación.
     */
    public void registrarPublicacion(Post post) throws PersistenciaException;

    /**
     * Edita una publicación existente en la base de datos, actualizando su
     * título, contenido y fecha de edición.
     *
     * @param idPost ID de la publicación que se desea editar.
     * @param post Objeto Post que contiene los nuevos datos de la publicación.
     * @throws PersistenciaException Si ocurre un error durante la edición de la
     * publicación.
     */
    public void editarPublicacion(int idPost, Post post) throws PersistenciaException;

    /**
     * Consulta todas las publicaciones en la base de datos.
     *
     * @return Lista de todas las publicaciones encontradas.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las publicaciones.
     */
    public List<Post> consultarPublicaciones() throws PersistenciaException;

    /**
     * Consulta una publicación por su ID.
     *
     * @param id ID de la publicación que se desea consultar.
     * @return Objeto Post con los datos de la publicación.
     */
    public Post consultarPublicacionePorId(int id) throws PersistenciaException;

    /**
     * Elimina una publicación de la base de datos por su ID.
     *
     * @param idPost ID de la publicación que se desea eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación
     * de la publicación.
     */
    public void eliminarPublicacion(int idPost) throws PersistenciaException;

    /**
     * Incrementa el número de "likes" de una publicación por su ID.
     *
     * @param idPost ID de la publicación a la que se le dará un "like".
     * @throws PersistenciaException Si ocurre un error al dar el "like" a la
     * publicación.
     */
    public void darLike(int idPost) throws PersistenciaException;

    /**
     * Ancla una publicación, cambiando su tipo a "anclado".
     *
     * @param idPost ID de la publicación que se desea anclar.
     * @throws PersistenciaException Si ocurre un error al anclar la
     * publicación.
     */
    public void anclarPost(int idPost) throws PersistenciaException;
}
