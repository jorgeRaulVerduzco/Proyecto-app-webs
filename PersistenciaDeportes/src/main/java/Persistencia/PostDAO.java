/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Post;
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

    @Override
    public void registrarPublicacion(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        post.setFechaCreacion(new Date());
        em.persist(post);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void editarPublicacion(int idPost, Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Post existingPost = em.find(Post.class, idPost);
        if (existingPost != null) {
            existingPost.setTitulo(post.getTitulo());
            existingPost.setContenido(post.getContenido());
            existingPost.setFechaEdicion(new Date());
            em.merge(existingPost);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Post> consultarPublicaciones() {
        EntityManager em = emf.createEntityManager();
        List<Post> publicaciones = em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        em.close();
        return publicaciones;
    }

    @Override
    public void eliminarPublicacion(int idPost) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Post post = em.find(Post.class, idPost);
        if (post != null) {
            em.remove(post);
        }
        em.getTransaction().commit();
        em.close();
    }

}
