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
    public boolean IniciarSesion(String usuario,String contrasenia) throws PersistenciaException ;
    public void RegistrarUsuario(Usuario usuario) throws PersistenciaException ;
}
