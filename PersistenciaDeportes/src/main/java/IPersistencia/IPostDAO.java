/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Post;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPostDAO {

    public void registrarPublicacion(Post post);

    public void editarPublicacion(int idPost, Post post);

    public List<Post> consultarPublicaciones();

    public void eliminarPublicacion(int idPost);
    
    public void darLike(int idPost) ;
    
    public void anclarPost(int idPost) ;
}
