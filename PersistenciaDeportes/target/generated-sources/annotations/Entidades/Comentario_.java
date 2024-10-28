package Entidades;

import Entidades.PostComentario;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-27T21:22:22", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Date> fechaHora;
    public static volatile SingularAttribute<Comentario, Usuario> usuario;
    public static volatile SingularAttribute<Comentario, Integer> id;
    public static volatile SingularAttribute<Comentario, Integer> numLikes;
    public static volatile ListAttribute<Comentario, PostComentario> postComentarios;

}