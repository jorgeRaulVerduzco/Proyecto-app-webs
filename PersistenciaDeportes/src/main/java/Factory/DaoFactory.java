/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import IPersistencia.IComentarioDAO;
import IPersistencia.IPostDAO;
import IPersistencia.IUsuarioDAO;
import Persistencia.ComentarioDAO;
import Persistencia.PostDAO;
import Persistencia.UsuarioDAO;

/**
 *
 * @author INEGI
 */
public class DaoFactory implements IDaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {
    }

    public static IDaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    @Override
    public IPostDAO getPostDAO() {
        return new PostDAO();
    }

    @Override
    public IComentarioDAO getComentarioDAO() {
        return new ComentarioDAO();
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
}
