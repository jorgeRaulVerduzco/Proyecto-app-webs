/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import IPersistencia.IUsuarioDAO;
import javax.persistence.EntityManagerFactory;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void RegistrarUsuario(Entidades.Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
