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
import java.util.Date;
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
        // Ensure all required fields are set
        if (postDTO == null) {
            throw new IllegalArgumentException("PostDTO cannot be null");
        }
        
        // Set creation date if not already set
        if (postDTO.getFechaCreacion() == null) {
            postDTO.setFechaCreacion(new Date());
        }
        
        // Validate required fields
        if (postDTO.getTitulo() == null || postDTO.getContenido() == null) {
            throw new IllegalArgumentException("Titulo and Contenido are required");
        }
        
        Post post = conversor.postToEntity(postDTO);
        fachada.registrarPublicacion(post);
    } catch (PersistenciaException ex) {
        // Log the full exception for debugging
        Logger.getLogger(PostBO.class.getName()).log(Level.SEVERE, "Error registering publication", ex);
        // You might want to rethrow or handle differently based on your error handling strategy
        throw new RuntimeException("Error registering publication", ex);
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
     * Consulta una publicación por su ID. Convierte la entidad de publicación a
     * DTO y la devuelve.
     *
     * @param idPost El ID de la publicación a consultar.
     */
    @Override
    public PostDTO consultarPublicacionesById(int idPost) {
        try {
            Post post = fachada.consultarPublicacioneById(idPost);
            
            // Verifica si la publicación es nula
            if(post == null) {
                throw new IllegalStateException("No se encontró la publicación.");
            }
            
            // Mapea la publicación a DTO
            return conversor.postToDto(post);
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
