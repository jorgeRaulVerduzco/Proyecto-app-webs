/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Post;
import Excepciones.PersistenciaException;
import IPersistencia.IPostDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author INEGI
 */
public class PostDAO implements IPostDAO {

    private EntityManagerFactory emf;

    public PostDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");

    }

    /**
     * Registra una nueva publicación en la base de datos, incluyendo la fecha
     * de creación.
     *
     * @param post Objeto Post que se desea registrar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el registro de
     * la publicación.
     */
    @Override
    public void registrarPublicacion(Post post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            post.setFechaCreacion(new Date());
            em.persist(post);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar la publicacion", e);
        } finally {
            em.close();
        }
    }

    /**
     * Edita una publicación existente en la base de datos, actualizando su
     * título, contenido y fecha de edición.
     *
     * @param idPost ID de la publicación que se desea editar.
     * @param post Objeto Post que contiene los nuevos datos de la publicación.
     * @throws PersistenciaException Si ocurre un error durante la edición de la
     * publicación.
     */
    @Override
    public void editarPublicacion(int idPost, Post post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Post existingPost = em.find(Post.class, idPost);
            if (existingPost != null) {
                existingPost.setTitulo(post.getTitulo());
                existingPost.setContenido(post.getContenido());
                existingPost.setFechaEdicion(new Date());
                em.merge(existingPost);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al editar la publicacion", e);
        } finally {
            em.close();
        }
    }

    /**
     * Consulta todas las publicaciones en la base de datos.
     *
     * @return Lista de todas las publicaciones encontradas.
     * @throws PersistenciaException Si ocurre un error durante la consulta de
     * las publicaciones.
     */
    @Override
    public List<Post> consultarPublicaciones() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar las publicaciones", e);
        } finally {
            em.close();
        }
    }

    /**
     * Elimina una publicación de la base de datos por su ID.
     *
     * @param idPost ID de la publicación que se desea eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación
     * de la publicación.
     */
    @Override
    public void eliminarPublicacion(int idPost) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Post post = em.find(Post.class, idPost);
            if (post != null) {
                em.remove(post);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar la publicacion", e);
        } finally {
            em.close();
        }
    }

    /**
     * Incrementa el número de "likes" de una publicación por su ID.
     *
     * @param idPost ID de la publicación a la que se le dará un "like".
     * @throws PersistenciaException Si ocurre un error al dar el "like" a la
     * publicación.
     */
    @Override
    public void darLike(int idPost) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Post post = em.find(Post.class, idPost);
            if (post != null) {
                post.setNumLikes(post.getNumLikes() + 1);
                em.merge(post);
            } else {
                System.out.println("Post no encontrado con ID: " + idPost);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al dar like a la publicacion", e);
        } finally {
            em.close();
        }
    }

    /**
     * Ancla una publicación, cambiando su tipo a "anclado".
     *
     * @param idPost ID de la publicación que se desea anclar.
     * @throws PersistenciaException Si ocurre un error al anclar la
     * publicación.
     */
    @Override
    public void anclarPost(int idPost) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Post post = em.find(Post.class, idPost);
            if (post != null) {
                post.setTipoPost("anclado");
                em.merge(post);
            } else {
                System.out.println("Post no encontrado con ID: " + idPost);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al anclar la publicación", e);
        } finally {
            em.close();
        }
    }
}
