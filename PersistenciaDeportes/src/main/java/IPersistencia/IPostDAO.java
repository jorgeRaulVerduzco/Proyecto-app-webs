/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Post;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPostDAO {

    public void registrarPublicacion(Post post)  throws PersistenciaException;

    public void editarPublicacion(int idPost, Post post)  throws PersistenciaException;

    public List<Post> consultarPublicaciones()  throws PersistenciaException ;

    public void eliminarPublicacion(int idPost) throws PersistenciaException;
    
    public void darLike(int idPost) throws PersistenciaException ;
    
    public void anclarPost(int idPost) throws PersistenciaException ;
}
