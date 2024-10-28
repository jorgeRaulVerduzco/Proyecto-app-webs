/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Comentario;
import Entidades.Post;
import Entidades.PostComentario;
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
    public void registrarComentario(Comentario comentario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) {
        EntityManager em = emf.createEntityManager();
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
        em.close();
    }

    @Override
    public List<Comentario> consultarComentarios(int idPost) {
        EntityManager em = emf.createEntityManager();
        List<Comentario> comentarios = em.createQuery(
                "SELECT c FROM Comentario c JOIN PostComentario pc ON c.id = pc.comentario.id WHERE pc.post.id = :idPost",
                Comentario.class)
                .setParameter("idPost", idPost)
                .getResultList();
        em.close();
        return comentarios;
    }

    @Override
    public boolean eliminarComentario(int idComentario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comentario comentario = em.find(Comentario.class, idComentario);
        if (comentario != null) {
            em.remove(comentario);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().rollback();
        em.close();
        return false;
    }

}
