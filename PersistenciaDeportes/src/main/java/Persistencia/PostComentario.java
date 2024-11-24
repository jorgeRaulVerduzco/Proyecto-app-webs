package Persistencia;

import java.util.List;

// recursos de persistencia
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Excepciones.PersistenciaException;


import IPersistencia.IPostComentario;

public class PostComentario implements IPostComentario{

    private EntityManagerFactory emf;
    
    public PostComentario() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");
    }


    @Override
    public List<Entidades.PostComentario> getPostComentarios( int postId) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT pc FROM PostComentario pc", Entidades.PostComentario.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los comentarios de posts", e);
        } finally {
            em.close();
        }
    }
    
}
