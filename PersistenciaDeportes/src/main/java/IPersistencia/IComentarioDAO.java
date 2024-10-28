/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Comentario;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IComentarioDAO {

    public void registrarComentario(Comentario comentario);

    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario);

    public List<Comentario> consultarComentarios(int idPublicacion);

    public boolean eliminarComentario(int idComentario);
}
