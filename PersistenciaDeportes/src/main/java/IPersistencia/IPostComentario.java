package IPersistencia;

import Entidades.PostComentario;
import java.util.List;
import Excepciones.PersistenciaException;

public interface IPostComentario {

    public List<PostComentario> getPostComentarios( int postId) throws PersistenciaException;

    
}
