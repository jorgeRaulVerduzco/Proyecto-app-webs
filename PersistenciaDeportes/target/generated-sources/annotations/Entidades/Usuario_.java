package Entidades;

import Entidades.Comentario;
import Entidades.Estado;
import Entidades.Municipio;
import Entidades.Post;
import Entidades.Rol;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-07T13:12:17", comments="EclipseLink-2.7.12.v20230209-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-06T13:33:21", comments="EclipseLink-2.7.12.v20230209-rNA")
>>>>>>> f2f06c0
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidoPaterno;
    public static volatile SingularAttribute<Usuario, Estado> estado;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, Municipio> municipio;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Post> posts;
    public static volatile SingularAttribute<Usuario, Rol> rol;
    public static volatile SingularAttribute<Usuario, String> apellidoMaterno;
    public static volatile SingularAttribute<Usuario, String> urlImagen;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> genero;
    public static volatile SingularAttribute<Usuario, String> contrasenia;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile ListAttribute<Usuario, Comentario> comentarios;

}