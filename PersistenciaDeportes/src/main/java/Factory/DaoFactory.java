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

    /**
     * Constructor para evitar la creación de múltiples instancias de
     * DaoFactory. Esto asegura que se utilice el patrón Singleton.
     */
    private DaoFactory() {
    }

    /**
     * Método estático que obtiene la única instancia de DaoFactory. Si aún no
     * se ha creado la instancia, la crea.
     *
     * @return La única instancia de DaoFactory.
     */
    public static IDaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    /**
     * Método que obtiene una nueva instancia de IPostDAO.
     *
     * @return Una nueva instancia de PostDAO que implementa la interfaz
     * IPostDAO.
     */
    @Override
    public IPostDAO getPostDAO() {
        return new PostDAO();
    }

    /**
     * Método que obtiene una nueva instancia de IComentarioDAO.
     *
     * @return Una nueva instancia de ComentarioDAO que implementa la interfaz
     * IComentarioDAO.
     */
    @Override
    public IComentarioDAO getComentarioDAO() {
        return new ComentarioDAO();
    }

    /**
     * Método que obtiene una nueva instancia de IUsuarioDAO.
     *
     * @return Una nueva instancia de UsuarioDAO que implementa la interfaz
     * IUsuarioDAO.
     */
    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
}
