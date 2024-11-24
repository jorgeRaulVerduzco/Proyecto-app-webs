package Entidades;

import Entidades.Categoria;
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
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> contenido;
    public static volatile SingularAttribute<Post, Date> fechaEdicion;
    public static volatile SingularAttribute<Post, String> tipoPost;
    public static volatile SingularAttribute<Post, Categoria> categoria;
    public static volatile SingularAttribute<Post, Date> fechaCreacion;
    public static volatile SingularAttribute<Post, String> titulo;
    public static volatile SingularAttribute<Post, Usuario> usuario;
    public static volatile SingularAttribute<Post, Integer> id;
    public static volatile SingularAttribute<Post, Integer> numLikes;
    public static volatile ListAttribute<Post, PostComentario> postComentarios;
    public static volatile SingularAttribute<Post, String> urlImagen;

}