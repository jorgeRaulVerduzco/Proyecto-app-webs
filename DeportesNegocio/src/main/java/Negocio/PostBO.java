/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConvertirDTOaEntidad.Conversor;
import DTO.PostDTO;
import Entidades.Post;
import Excepciones.PersistenciaException;
import Fachada.PersistenciaFachada;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author INEGI
 */
public class PostBO {

    private  PersistenciaFachada fachada;
    private  Conversor conversor;

    public PostBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    public void registrarPublicacion(PostDTO postDTO) {
        try {
            Post post = conversor.postToEntity(postDTO);
            fachada.registrarPublicacion(post);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPublicacion(int idPost, PostDTO postDTO) {
        try {
            Post post = conversor.postToEntity(postDTO);
            fachada.editarPublicacion(idPost, post);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PostDTO> consultarPublicaciones() {
        try {
            List<Post> posts = fachada.consultarPublicaciones();
            return posts.stream()
                    .map(conversor::postToDto)
                    .collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void eliminarPublicacion(int idPost) {
        try {
            fachada.eliminarPublicacion(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darLike(int idPost) {
        try {
            fachada.darLikePublicacion(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void anclarPost(int idPost) {
        try {
            fachada.anclarPost(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
