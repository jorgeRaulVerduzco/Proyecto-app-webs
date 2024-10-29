/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IPersistencia;

import Entidades.Comentario;
import Excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author INEGI
 */
public interface IComentarioDAO {

    public void registrarComentario(Comentario comentario, int idPublicacion) throws PersistenciaException;

    public void registrarComentarioAnclado(int idPublicacion, Comentario comentario) throws PersistenciaException ;

    public List<Comentario> consultarComentarios(int idPublicacion) throws PersistenciaException ;

    public boolean eliminarComentario(int idComentario) throws PersistenciaException ;
}
