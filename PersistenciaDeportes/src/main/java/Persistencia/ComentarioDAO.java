/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Comentario;
import Entidades.Post;
import Entidades.PostComentario;
import Excepciones.PersistenciaException;
import IPersistencia.IComentarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author INEGI
 */
public class ComentarioDAO implements IComentarioDAO {

    private EntityManagerFactory emf;

    /**
     * Constructor de la clase ComentarioDAO. Inicializa la fábrica de
     * EntityManager con la unidad de persistencia "ConexionPu".
     */
    public ComentarioDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");

    }

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
    @Override
    public void registrarComentario(Comentario comentario, int idPublicacion) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Post post = em.find(Post.class, idPublicacion);

            if (post != null) {
                comentario.setFechaHora(new Date());
                comentario.setNumLikes(0);
                em.persist(comentario);

                PostComentario postComentario = new PostComentario();
                postComentario.setPost(post);
                postComentario.setComentario(comentario);
                em.persist(postComentario);
            } else {
                throw new PersistenciaException("Post no encontrado con ID: " + idPublicacion);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar comentario", e);
        } finally {
            em.close();
        }
        
    }

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
    @Override
    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Post post = em.find(Post.class, idPublicacion);

            comentario.setFechaHora(new Date());
            comentario.setNumLikes(0);
            comentario.setPostComentarios(new ArrayList<>());

            em.persist(comentario);

            PostComentario postComentario = new PostComentario();
            postComentario.setPost(post);
            postComentario.setComentario(comentario);
            em.persist(postComentario);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar comentario anclado", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta los comentarios asociados a un post específico utilizando su ID.
     *
     * @param idPost El ID del post para el cual se consultarán los comentarios.
     * @return Una lista de comentarios asociados al post especificado.
     * @throws PersistenciaException Si ocurre un error al consultar los
     * comentarios.
     */
    @Override
    public List<Comentario> consultarComentarios(int idPost) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT c FROM Comentario c JOIN PostComentario pc ON c.id = pc.comentario.id WHERE pc.post.id = :idPost",
                    Comentario.class)
                    .setParameter("idPost", idPost)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los comentarios", e);
        } finally {
            em.close();
        }
    }

    /**
     * Elimina un comentario de la base de datos según su ID.
     *
     * @param idComentario El ID del comentario que se desea eliminar.
     * @return true si el comentario fue eliminado exitosamente, false si no se
     * encontró el comentario.
     * @throws PersistenciaException Si ocurre un error al eliminar el
     * comentario.
     */
    @Override
    public boolean eliminarComentario(int idComentario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Comentario comentario = em.find(Comentario.class, idComentario);
            if (comentario != null) {
                em.remove(comentario);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el comentario", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Comentario> consultarTodosLosComentarios() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar todos los comentarios", e);
        } finally {
            em.close();
        }
    }
}
