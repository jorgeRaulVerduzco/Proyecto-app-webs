/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author INEGI
 */
@Entity
@Table(name = "Post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(length = 255, nullable = false)
    private String titulo;

    @Column(length = 500, nullable = false)
    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(length = 50, nullable = false)
    private String tipoPost;  // Ej: "anclado" o "normal"

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostComentario> postComentarios;

    @Column(name = "num_likes")
    private Integer numLikes = 0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column
    private String urlImagen;

    public Post() {
    }

    public Post(Date fechaCreacion, String titulo, String contenido, Date fechaEdicion, Usuario usuario, String tipoPost, List<PostComentario> postComentarios, Integer numLikes, Categoria categoria, String urlImagen) {
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaEdicion = fechaEdicion;
        this.usuario = usuario;
        this.tipoPost = tipoPost;
        this.postComentarios = postComentarios;
        this.numLikes = numLikes;
        this.categoria = categoria;
        this.urlImagen = urlImagen;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoPost() {
        return tipoPost;
    }

    public void setTipoPost(String tipoPost) {
        this.tipoPost = tipoPost;
    }

    public List<PostComentario> getPostComentarios() {
        return postComentarios;
    }

    public void setPostComentarios(List<PostComentario> postComentarios) {
        this.postComentarios = postComentarios;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaEdicion=" + fechaEdicion + ", usuario=" + usuario + ", tipoPost=" + tipoPost + ", postComentarios=" + postComentarios + ", numLikes=" + numLikes + ", categoria=" + categoria + '}';
    }

}
