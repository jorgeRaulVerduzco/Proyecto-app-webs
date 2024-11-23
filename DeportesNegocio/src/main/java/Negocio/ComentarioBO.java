/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import ConvertirDTOaEntidad.Conversor;
import DTO.ComentarioDTO;
import Entidades.Comentario;
import Excepciones.PersistenciaException;
import Fachada.PersistenciaFachada;
import INegocio.IComentarioBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author INEGI
 */
public class ComentarioBO implements IComentarioBO {

    private final PersistenciaFachada fachada;
    private final Conversor conversor;

    /**
     * Constructor que inicializa la fachada y el conversor. El constructor crea
     * instancias de la fachada de persistencia y el conversor de objetos.
     */
    public ComentarioBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    /**
     * Registra un nuevo comentario para una publicación específica. Convierte
     * el DTO de comentario a una entidad y delega el registro a la fachada de
     * persistencia.
     *
     * @param comentarioDTO El DTO que contiene los datos del comentario a
     * registrar.
     * @param idPublicacion El ID de la publicación a la que pertenece el
     * comentario.
     */
    @Override
    public void registrarComentario(ComentarioDTO comentarioDTO, int idPublicacion) {
        try {
            Comentario comentario = conversor.comentarioToEntity(comentarioDTO);
            fachada.registrarComentario(comentario, idPublicacion);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Registra un comentario anclado para una publicación específica. Convierte
     * el DTO de comentario a una entidad y delega el registro a la fachada de
     * persistencia.
     *
     * @param idPublicacion El ID de la publicación a la que pertenece el
     * comentario anclado.
     * @param comentarioDTO El DTO que contiene los datos del comentario anclado
     * a registrar.
     */
    @Override
    public void registrarComentarioAnclado(int idPublicacion, ComentarioDTO comentarioDTO) {
        try {
            Comentario comentario = conversor.comentarioToEntity(comentarioDTO);
            fachada.registrarComentarioAnclado(idPublicacion, comentario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta los comentarios de una publicación específica. Convierte las
     * entidades de comentarios a DTOs y los devuelve como una lista.
     *
     * @param idPost El ID de la publicación cuyos comentarios se desean
     * consultar.
     * @return Una lista de objetos DTO de los comentarios.
     */
    @Override
    public List<ComentarioDTO> consultarComentarios(int idPost) {
        try {
            List<Comentario> comentarios = fachada.consultarComentarios(idPost);
            return comentarios.stream()
                    .map(conversor::comentarioToDto)
                    .collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   /**
     * Elimina un comentario del sistema.
     * 
     * @param idComentario El ID del comentario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    @Override
    public boolean eliminarComentario(int idComentario) {
        try {
            return fachada.eliminarComentario(idComentario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
