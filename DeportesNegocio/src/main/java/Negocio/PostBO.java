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
import INegocio.IPostBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author INEGI
 */
public class PostBO implements IPostBO {

    private PersistenciaFachada fachada;
    private Conversor conversor;

    /**
     * Constructor que inicializa la fachada y el conversor. El constructor crea
     * instancias de la fachada de persistencia y el conversor de objetos.
     */
    public PostBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    /**
     * Registra una nueva publicación en el sistema. Convierte el DTO de
     * publicación a una entidad y delega el registro a la fachada de
     * persistencia.
     *
     * @param postDTO El DTO que contiene los datos de la publicación a
     * registrar.
     */
    @Override
    public void registrarPublicacion(PostDTO postDTO) {
        try {
            Post post = conversor.postToEntity(postDTO);
            fachada.registrarPublicacion(post);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Edita una publicación existente. Convierte el DTO de publicación a una
     * entidad y delega la operación de edición a la fachada.
     *
     * @param idPost El ID de la publicación a editar.
     * @param postDTO El DTO que contiene los datos de la publicación editada.
     */
    @Override
    public void editarPublicacion(int idPost, PostDTO postDTO) {
        try {
            Post post = conversor.postToEntity(postDTO);
            fachada.editarPublicacion(idPost, post);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta todas las publicaciones existentes en el sistema. Convierte las
     * entidades de publicaciones a DTOs y las devuelve como una lista.
     *
     * @return Una lista de objetos DTO de las publicaciones.
     */
    @Override
    public List<PostDTO> consultarPublicaciones() {
        try {
            // Consulta las publicaciones desde la fachada
            List<Post> posts = fachada.consultarPublicaciones();
    
            // Verifica si la lista de publicaciones es nula
            if(posts == null) {
                throw new IllegalStateException("No se encontraron publicaciones.");
            }
            
            // Mapea las publicaciones a DTOs
            return posts.stream()
                    .map(conversor::postToDto)
                    .collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }
    

    /**
     * Elimina una publicación del sistema.
     *
     * @param idPost El ID de la publicación a eliminar.
     */
    @Override
    public void eliminarPublicacion(int idPost) {
        try {
            fachada.eliminarPublicacion(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Registra un "like" en una publicación.
     *
     * @param idPost El ID de la publicación a la que se le va a dar "like".
     */
    @Override
    public void darLike(int idPost) {
        try {
            fachada.darLikePublicacion(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ancla una publicación en el sistema.
     *
     * @param idPost El ID de la publicación a anclar.
     */
    @Override
    public void anclarPost(int idPost) {
        try {
            fachada.anclarPost(idPost);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
