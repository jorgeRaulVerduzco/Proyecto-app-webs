/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Usuario;
import Excepciones.PersistenciaException;

/**
 *
 * @author INEGI
 */
public interface IUsuarioDAO {

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
    public boolean IniciarSesion(String usuario, String contrasenia) throws PersistenciaException;

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario que se desea registrar en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el registro del
     * usuario.
     */
    public void RegistrarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Obtiene un usuario por su nombre de usuario (username).
     *
     * @param username Nombre de usuario a buscar.
     * @return El objeto Usuario correspondiente al nombre de usuario, o null si
     * no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda del
     * usuario.
     */
    public Usuario obtenerPorUsername(String username) throws PersistenciaException;

    /**
     * Obtiene un usuario por su correo electrónico (email).
     *
     * @param email Correo electrónico a buscar.
     * @return El objeto Usuario correspondiente al correo, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda del
     * usuario.
     */
    public Usuario obtenerPorEmail(String email) throws PersistenciaException;
    
     public boolean validarCredenciales(String email, String contrasenia) throws PersistenciaException ;
}
