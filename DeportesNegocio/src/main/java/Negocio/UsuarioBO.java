/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConvertirDTOaEntidad.Conversor;
import DTO.UsuarioDTO;
import Entidades.Usuario;
import Excepciones.PersistenciaException;
import Fachada.PersistenciaFachada;
import INegocio.IUsuarioBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class UsuarioBO implements IUsuarioBO {

    private final PersistenciaFachada fachada;
    private final Conversor conversor;

    /**
     * Constructor que inicializa la fachada y el conversor.
     */
    public UsuarioBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    /**
     * Registra un nuevo usuario en el sistema. Convierte el DTO de usuario a
     * una entidad y delega el registro a la fachada de persistencia.
     *
     * @param usuarioDTO El DTO que contiene los datos del usuario a registrar.
     */
    @Override
    public void registrarUsuario(UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = conversor.usuarioToEntity(usuarioDTO);
            fachada.registrarUsuario(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inicia sesión verificando las credenciales del usuario.
     *
     * @param usuario El nombre de usuario.
     * @param contrasenia La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    @Override
    public boolean iniciarSesion(String usuario, String contrasenia) {
        try {
            return fachada.iniciarSesion(usuario, contrasenia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Inicia sesión verificando las credenciales del usuario por email.
     *
     * @param email El email del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    @Override
    public boolean iniciarSesionFinal(String email, String contrasenia) {
        try {
            return fachada.iniciarSesionFinal(email, contrasenia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Obtiene un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario a buscar.
     * @return El DTO del usuario encontrado, o null si no se encuentra.
     */
    @Override
    public UsuarioDTO obtenerUsuarioPorEmail(String email) {
        try {
            Usuario usuario = fachada.obtenerUsuarioPorEmail(email);
            return conversor.usuarioToDto(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
