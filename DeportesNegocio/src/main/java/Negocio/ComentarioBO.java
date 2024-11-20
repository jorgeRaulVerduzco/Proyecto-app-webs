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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author INEGI
 */
public class ComentarioBO {

    private final PersistenciaFachada fachada;
    private final Conversor conversor;

    public ComentarioBO() {
        this.fachada = new PersistenciaFachada();
        this.conversor = new Conversor();
    }

    public void registrarComentario(ComentarioDTO comentarioDTO, int idPublicacion) {
        try {
            Comentario comentario = conversor.comentarioToEntity(comentarioDTO);
            fachada.registrarComentario(comentario, idPublicacion);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrarComentarioAnclado(int idPublicacion, ComentarioDTO comentarioDTO) {
        try {
            Comentario comentario = conversor.comentarioToEntity(comentarioDTO);
            fachada.registrarComentarioAnclado(idPublicacion, comentario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public boolean eliminarComentario(int idComentario) {
        try {
            return fachada.eliminarComentario(idComentario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComentarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
