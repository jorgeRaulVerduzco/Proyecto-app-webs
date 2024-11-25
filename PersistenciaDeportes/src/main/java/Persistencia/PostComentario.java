package Persistencia;

import java.util.List;

// recursos de persistencia
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Excepciones.PersistenciaException;

import IPersistencia.IPostComentario;

public class PostComentario implements IPostComentario {

    private EntityManagerFactory emf;

    public PostComentario() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");
    }

    /**
     * This method retrieves a list of post comments based on the provided post ID.
     *
     * @param postId The unique identifier of the post for which to retrieve
     *               comments.
     * @return A list of {@link Entidades.PostComentario} objects representing the
     *         comments associated with the given post ID.
     * @throws PersistenciaException If an error occurs while querying the database
     *                               for post comments.
     */
    @Override
    public List<Entidades.PostComentario> getPostComentarios(int postId) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT pc FROM PostComentario pc WHERE pc.post.id = :postId",
                    Entidades.PostComentario.class)
                    .setParameter("postId", postId)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los comentarios de posts", e);
        } finally {
            em.close();
        }
    }

}
