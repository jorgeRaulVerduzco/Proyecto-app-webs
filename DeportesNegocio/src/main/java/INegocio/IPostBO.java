/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.PostDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IPostBO {

    public void registrarPublicacion(PostDTO postDTO);

    public void editarPublicacion(int idPost, PostDTO postDTO);

    public List<PostDTO> consultarPublicaciones();

    public void eliminarPublicacion(int idPost);

    public void darLike(int idPost);

    public void anclarPost(int idPost);
}
