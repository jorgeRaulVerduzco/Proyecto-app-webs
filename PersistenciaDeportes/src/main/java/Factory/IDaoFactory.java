/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Factory;

import IPersistencia.IComentarioDAO;
import IPersistencia.IPostDAO;
import IPersistencia.IUsuarioDAO;

/**
 *
 * @author INEGI
 */
public interface IDaoFactory {
    IPostDAO getPostDAO();
    IComentarioDAO getComentarioDAO();
    IUsuarioDAO getUsuarioDAO();
}
