package Entidades;

import Entidades.PostComentario;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-24T01:51:27", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-23T21:37:03", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> 100d81acca6f52f37a0c7e7e4a78c5e2b62e8653
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Date> fechaHora;
    public static volatile SingularAttribute<Comentario, Usuario> usuario;
    public static volatile SingularAttribute<Comentario, Integer> id;
    public static volatile SingularAttribute<Comentario, Integer> numLikes;
    public static volatile ListAttribute<Comentario, PostComentario> postComentarios;

}