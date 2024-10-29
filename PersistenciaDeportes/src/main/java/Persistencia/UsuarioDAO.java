/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Usuario;
import Excepciones.PersistenciaException;
import IPersistencia.IUsuarioDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author INEGI
 */
public class UsuarioDAO implements IUsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");
    }

    @Override
    public boolean IniciarSesion(String usuario, String contrasenia) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasenia = :contrasenia",
                    Usuario.class)
                    .setParameter("nombreUsuario", usuario)
                    .setParameter("contrasenia", contrasenia)
                    .getResultList()
                    .size() > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al iniciar sesión", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void RegistrarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar el usuario", e);
        } finally {
            em.close();
        }
    }
}
