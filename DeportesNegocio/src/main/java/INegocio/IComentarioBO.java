/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INegocio;

import DTO.ComentarioDTO;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IComentarioBO {

    public void registrarComentario(ComentarioDTO comentarioDTO, int idPublicacion);

    public void registrarComentarioAnclado(int idPublicacion, ComentarioDTO comentarioDTO);

    public List<ComentarioDTO> consultarComentarios(int idPost);

    public boolean eliminarComentario(int idComentario);
}
