/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Usuario;

/**
 *
 * @author INEGI
 */
public interface IUsuarioDAO {
    public boolean IniciarSesion(String usuario,String contrasenia);
    public Usuario RegistrarUsuario(Usuario usuario);
}
