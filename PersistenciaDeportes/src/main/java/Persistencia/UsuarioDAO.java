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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author INEGI
 */
public class UsuarioDAO implements IUsuarioDAO {

    private EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("ConexionPu");
    }

    /**
     * Inicia sesión de un usuario verificando su nombre de usuario y contraseña
     * en la base de datos.
     *
     * @param usuario Nombre de usuario del usuario que desea iniciar sesión.
     * @param contrasenia Contraseña del usuario que desea iniciar sesión.
     * @return true si el nombre de usuario y la contraseña coinciden en la base
     * de datos, false en caso contrario.
     * @throws PersistenciaException Si ocurre un error al interactuar con la
     * base de datos.
     */
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

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario que se desea registrar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el registro del
     * usuario.
     */
    @Override
    public void RegistrarUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Iniciar transacción
            em.persist(usuario);
            em.getTransaction().commit(); // Confirmar transacción
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hacer rollback si algo falla
            }
            throw new PersistenciaException("Error al registrar usuario", e);
        } finally {
            em.close(); // Cerrar EntityManager
        }
    }

    /**
     * Obtiene un usuario por su nombre de usuario (username).
     *
     * @param username Nombre de usuario a buscar.
     * @return El objeto Usuario correspondiente al nombre de usuario, o null si
     * no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda del
     * usuario.
     */
    @Override
    public Usuario obtenerPorUsername(String username) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username");
            query.setParameter("username", username);
            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Obtiene un usuario por su correo electrónico (email).
     *
     * @param email Correo electrónico a buscar.
     * @return El objeto Usuario correspondiente al correo, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda del
     * usuario.
     */
    @Override
    public Usuario obtenerPorEmail(String email) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :email");
            query.setParameter("email", email);
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar usuario por email", e);
        } finally {
            em.close();
        }
    }
 /**
     * Valida las credenciales de un usuario
     * @param email Email del usuario
     * @param contrasenia Contraseña del usuario
     * @return true si las credenciales son válidas, false en caso contrario
     * @throws PersistenciaException Si ocurre un error durante la validación
     */
    @Override
    public boolean validarCredenciales(String email, String contrasenia) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            Usuario usuario = obtenerPorEmail(email);
            return usuario != null && usuario.getContrasenia().equals(contrasenia);
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar credenciales", e);
        } finally {
            em.close();
        }
    }
}
