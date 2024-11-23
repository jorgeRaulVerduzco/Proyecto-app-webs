/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.UsuarioDTO;

/**
 *
 * @author INEGI
 */
public interface IUsuarioBO {
      public boolean iniciarSesion(String usuario, String contrasenia);
     public void registrarUsuario(UsuarioDTO usuarioDTO);
     public boolean iniciarSesionFinal(String email, String contrasenia) ;
     public UsuarioDTO obtenerUsuarioPorEmail(String email);
}
