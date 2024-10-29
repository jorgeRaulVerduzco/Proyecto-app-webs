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

    public ComentarioDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");

    }

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
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar comentario", e);
        } finally {
            em.close();
        }
    }

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

}
