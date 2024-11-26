/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Comentario;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IComentarioDAO {

    /**
     * Registra un nuevo comentario asociado a un post especificado por su ID.
     * Si el post existe, se persiste el comentario y se crea la relación con el
     * post mediante la entidad PostComentario.
     *
     * @param comentario El comentario que se quiere registrar.
     * @param idPublicacion El ID del post al que se asociará el comentario.
     * @throws PersistenciaException Si ocurre un error al registrar el
     * comentario o si el post no existe.
     */
    public void registrarComentario(Comentario comentario, int idPublicacion) throws PersistenciaException;

    /**
     * Registra un comentario anclado a un post especificado por su ID. Similar
     * al método de registro de comentario, pero aquí se incluye una lista vacía
     * de PostComentarios.
     *
     * @param idPublicacion El ID del post al que se asociará el comentario.
     * @param comentario El comentario que se quiere registrar.
     * @throws PersistenciaException Si ocurre un error al registrar el
     * comentario anclado.
     */
    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) throws PersistenciaException;

    /**
     * Consulta los comentarios asociados a un post específico utilizando su ID.
     *
     * @param idPost El ID del post para el cual se consultarán los comentarios.
     * @return Una lista de comentarios asociados al post especificado.
     * @throws PersistenciaException Si ocurre un error al consultar los
     * comentarios.
     */
    public List<Comentario> consultarComentarios(int idPublicacion) throws PersistenciaException;

    /**
     * Elimina un comentario de la base de datos según su ID.
     *
     * @param idComentario El ID del comentario que se desea eliminar.
     * @return true si el comentario fue eliminado exitosamente, false si no se
     * encontró el comentario.
     * @throws PersistenciaException Si ocurre un error al eliminar el
     * comentario.
     */
    public boolean eliminarComentario(int idComentario) throws PersistenciaException;

    public List<Comentario> consultarTodosLosComentarios() throws PersistenciaException;
}
