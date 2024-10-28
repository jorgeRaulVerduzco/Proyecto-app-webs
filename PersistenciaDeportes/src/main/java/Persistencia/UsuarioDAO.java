/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Usuario;
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
    public boolean IniciarSesion(String usuario, String contrasenia) {
        EntityManager em = emf.createEntityManager();
        boolean existe = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasenia = :contrasenia",
                Usuario.class)
                .setParameter("nombreUsuario", usuario)
                .setParameter("contrasenia", contrasenia)
                .getResultList()
                .size() > 0;
        em.close();
        return existe;
    }

    @Override
    public void RegistrarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

}
