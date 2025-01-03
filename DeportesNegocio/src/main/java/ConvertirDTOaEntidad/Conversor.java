/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConvertirDTOaEntidad;

import DTO.CategoriaDTO;
import DTO.ComentarioDTO;
import DTO.EstadoDTO;
import DTO.MunicipioDTO;
import DTO.PostComentarioDTO;
import DTO.PostDTO;
import DTO.RolDTO;
import DTO.UsuarioDTO;
import Entidades.Categoria;
import Entidades.Comentario;
import Entidades.Estado;
import Entidades.Municipio;
import Entidades.Post;
import Entidades.PostComentario;
import Entidades.Rol;
import Entidades.Usuario;

import Persistencia.UsuarioDAO;
import Entidades.Usuario;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author INEGI
 */
public class Conversor {

    public Usuario usuarioToEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidoPaterno(dto.getApellidoPaterno());
        usuario.setApellidoMaterno(dto.getApellidoMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setContrasenia(dto.getContrasenia());
        usuario.setTelefono(dto.getTelefono());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setGenero(dto.getGenero());
        usuario.setRol(rolToEntity(dto.getRol()));
        usuario.setMunicipio(municipioToEntity(dto.getMunicipio()));
        usuario.setEstado(estadoToEntity(dto.getEstado()));
        usuario.setUrlImagen(dto.getUrlImagen());
        if (dto.getPosts() != null) {
            usuario.setPosts(dto.getPosts().stream()
                    .map(this::postToEntity)
                    .collect(Collectors.toList()));
        }

        if (dto.getComentarios() != null) {
            usuario.setComentarios(dto.getComentarios().stream()
                    .map(this::comentarioToEntity)
                    .collect(Collectors.toList()));
        }

        return usuario;
    }

    public Post postToEntity(PostDTO dto) {
        if (dto == null) {
            return null;
        }

        Post post = new Post();
        post.setFechaCreacion(dto.getFechaCreacion());
        post.setTitulo(dto.getTitulo());
        post.setContenido(dto.getContenido());
        post.setFechaEdicion(dto.getFechaEdicion());
        post.setTipoPost(dto.getTipoPost());
        post.setNumLikes(dto.getNumLikes());
        post.setUrlImagen(dto.getUrlImagen());
        post.setUsuario(usuarioToEntity(dto.getUsuario()));
        post.setCategoria(categoriaToEntity(dto.getCategoria()));

        if (dto.getPostComentarios() != null) {
            post.setPostComentarios(dto.getPostComentarios().stream()
                    .map(this::postComentarioToEntity)
                    .collect(Collectors.toList()));
        }

        return post;
    }

    /**
     * Converts a DTO (Data Transfer Object) of a Comentario to an Entity object.
     *
     * @param dto The DTO object to be converted.
     * @return The corresponding Entity object. If the input DTO is null, returns null.
     *
     * @throws NullPointerException If the input DTO is null or any of its nested objects are null.
     */
    public Comentario comentarioToEntity(ComentarioDTO dto) {
        if (dto == null) {
            return null;
        }
        UsuarioDAO buscarUsuario = new UsuarioDAO();
        Usuario usuario = null;
        try {
            usuario = buscarUsuario.obtenerPorEmail(dto.getUsuario().getCorreo());
            if (usuario == null) {
                throw new IllegalStateException("No se encontró un usuario con el correo: " + dto.getUsuario().getCorreo());
            }
        } catch (Exception e) {
            // Maneja la excepción adecuadamente, por ejemplo:
            throw new IllegalStateException("Error al obtener el usuario desde la BD", e);
        }
        
        

        Comentario comentario = new Comentario();
        comentario.setFechaHora(dto.getFechaHora());
        comentario.setContenido(dto.getContenido());
        comentario.setNumLikes(dto.getNumLikes());
        comentario.setUsuario(usuario);

        if (dto.getPostComentarios() != null) {
            comentario.setPostComentarios(dto.getPostComentarios().stream()
                    .map(this::postComentarioToEntity)
                    .collect(Collectors.toList()));
        }

        return comentario;
    }


    public Categoria categoriaToEntity(CategoriaDTO dto) {
        if (dto == null) {
            return null;
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());

        if (dto.getPosts() != null) {
            categoria.setPosts(dto.getPosts().stream()
                    .map(this::postToEntity)
                    .collect(Collectors.toList()));
        }

        return categoria;
    }

    public PostComentario postComentarioToEntity(PostComentarioDTO dto) {
        if (dto == null) {
            return null;
        }

        PostComentario postComentario = new PostComentario();
        postComentario.setPost(postToEntity(dto.getPost()));
        postComentario.setComentario(comentarioToEntity(dto.getComentario()));

        return postComentario;
    }

    public Estado estadoToEntity(EstadoDTO dto) {
        if (dto == null) {
            return null;
        }

        Estado estado = new Estado();
        estado.setNombre(dto.getNombre());
        estado.setUsuario(usuarioToEntity(dto.getUsuario()));

        return estado;
    }

    public Municipio municipioToEntity(MunicipioDTO dto) {
        if (dto == null) {
            return null;
        }

        Municipio municipio = new Municipio();
        municipio.setNombre(dto.getNombre());
        municipio.setUsuario(usuarioToEntity(dto.getUsuario()));

        return municipio;
    }

    public Rol rolToEntity(RolDTO dto) {
        if (dto == null) {
            return null;
        }

        Rol rol = new Rol();
        rol.setTipoRol(dto.getTipoRol());

        return rol;
    }

    public UsuarioDTO usuarioToDto(Usuario entity) {
        if (entity == null) {
            return null;
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNombre(entity.getNombre());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setCorreo(entity.getCorreo());
        dto.setNombreUsuario(entity.getNombreUsuario());
        dto.setContrasenia(entity.getContrasenia());
        dto.setTelefono(entity.getTelefono());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setGenero(entity.getGenero());
        dto.setRol(rolToDto(entity.getRol()));
        dto.setMunicipio(municipioToDto(entity.getMunicipio()));
        dto.setEstado(estadoToDto(entity.getEstado()));
        dto.setUrlImagen(entity.getUrlImagen());

        // No convertir las colecciones aquí para evitar la recursión
        return dto;
    }

    public PostDTO postToDto(Post entity) {
        if (entity == null) {
            return null;
        }

        PostDTO dto = new PostDTO();
        dto.setID(entity.getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setTitulo(entity.getTitulo());
        dto.setContenido(entity.getContenido());
        dto.setFechaEdicion(entity.getFechaEdicion());
        dto.setTipoPost(entity.getTipoPost());
        dto.setNumLikes(entity.getNumLikes());
        dto.setUrlImagen(entity.getUrlImagen());

        // Solo establecer información básica del usuario, sin sus posts
        if (entity.getUsuario() != null) {
            UsuarioDTO usuarioDto = new UsuarioDTO();
            usuarioDto.setId(entity.getUsuario().getId());
            usuarioDto.setNombre(entity.getUsuario().getNombre());
            usuarioDto.setNombreUsuario(entity.getUsuario().getNombreUsuario());
            dto.setUsuario(usuarioDto);
        }

        return dto;
    }

    public RolDTO rolToDto(Rol entity) {
        if (entity == null) {
            return null;
        }

        RolDTO dto = new RolDTO();
        dto.setTipoRol(entity.getTipoRol());
        // No establecer la lista de usuarios para evitar la recursión
        return dto;
    }

    public MunicipioDTO municipioToDto(Municipio entity) {
        if (entity == null) {
            return null;
        }

        MunicipioDTO dto = new MunicipioDTO();
        dto.setNombre(entity.getNombre());
        // No convertir el usuario aquí para evitar la recursión
        return dto;
    }

    public EstadoDTO estadoToDto(Estado entity) {
        if (entity == null) {
            return null;
        }

        EstadoDTO dto = new EstadoDTO();
        dto.setNombre(entity.getNombre());
        // No convertir el usuario aquí para evitar la recursión
        return dto;
    }

    private final Set<Integer> processedComentarioIds = new HashSet<>();// evita la recursión infinita

    public ComentarioDTO comentarioToDto(Comentario entity) {
        if (entity == null) {
            return null;
        }

        // Verifica si este Comentario ya fue procesado
        if (processedComentarioIds.contains(entity.getId())) {
            return null; // O devuelve un DTO parcial si lo necesitas
        }

        // Marca este Comentario como procesado
        processedComentarioIds.add(entity.getId());

        ComentarioDTO dto = new ComentarioDTO();
        dto.setFechaHora(entity.getFechaHora());
        dto.setContenido(entity.getContenido());
        dto.setNumLikes(entity.getNumLikes());
        dto.setUsuario(usuarioToDto(entity.getUsuario()));

        System.out.println(dto.toString());

        if (entity.getPostComentarios() != null) {
            dto.setPostComentarios(entity.getPostComentarios().stream()
                    .map(this::postComentarioToDto)
                    .filter(Objects::nonNull) // Evita agregar objetos nulos
                    .collect(Collectors.toList()));
        }

        // Limpia el conjunto después de la conversión para mantener la consistencia
        processedComentarioIds.remove(entity.getId());

        return dto;
    }

    public CategoriaDTO categoriaToDto(Categoria entity) {
        if (entity == null) {
            return null;
        }

        CategoriaDTO dto = new CategoriaDTO();
        dto.setNombre(entity.getNombre());

        if (entity.getPosts() != null) {
            dto.setPosts(entity.getPosts().stream()
                    .map(this::postToDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public PostComentarioDTO postComentarioToDto(PostComentario entity) {
        if (entity == null) {
            return null;
        }

        PostComentarioDTO dto = new PostComentarioDTO();
        dto.setPost(postToDto(entity.getPost()));
        dto.setComentario(comentarioToDto(entity.getComentario()));

        return dto;
    }

    public List<PostDTO> getPostsForUsuario(Usuario usuario) {
        if (usuario == null || usuario.getPosts() == null) {
            return null;
        }

        return usuario.getPosts().stream()
                .map(post -> {
                    PostDTO dto = new PostDTO();
                    dto.setTitulo(post.getTitulo());
                    dto.setContenido(post.getContenido());
                    // No incluir el usuario completo, solo información básica
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
