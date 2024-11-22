/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author ruben
 */
import Entidades.Usuario;
import Persistencia.UsuarioDAO;


public class UsuarioServicio {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

     public Usuario autenticar(String email, String password) {
        Usuario usuario = usuarioDAO.obtenerPorEmail(email);
        if (usuario != null && usuario.getContrasenia().equals(password)) {
            return usuario;
        }
        return null;
    }
}
