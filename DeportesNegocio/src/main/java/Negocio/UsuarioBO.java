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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INEGI
 */
public class UsuarioBO {

    private final PersistenciaFachada fachada;
    private final Conversor conversor;

    public UsuarioBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    public void registrarUsuario(UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = conversor.usuarioToEntity(usuarioDTO);
            fachada.registrarUsuario(usuario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean iniciarSesion(String usuario, String contrasenia) {
        try {
            return fachada.iniciarSesion(usuario, contrasenia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

