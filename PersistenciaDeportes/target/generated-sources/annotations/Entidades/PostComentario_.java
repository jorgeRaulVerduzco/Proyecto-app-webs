package Entidades;

import Entidades.Comentario;
import Entidades.Post;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-21T18:55:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PostComentario.class)
public class PostComentario_ { 

    public static volatile SingularAttribute<PostComentario, Post> post;
    public static volatile SingularAttribute<PostComentario, Integer> id;
    public static volatile SingularAttribute<PostComentario, Comentario> comentario;

}