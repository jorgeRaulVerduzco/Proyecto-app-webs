package Entidades;

import Entidades.Comentario;
import Entidades.Post;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-07T13:12:17", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-06T13:33:21", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f2f06c0
@StaticMetamodel(PostComentario.class)
public class PostComentario_ { 

    public static volatile SingularAttribute<PostComentario, Post> post;
    public static volatile SingularAttribute<PostComentario, Integer> id;
    public static volatile SingularAttribute<PostComentario, Comentario> comentario;

}