/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author INEGI
 */
public class PostDTO {

    private int ID;

    private Date fechaCreacion;

    private String titulo;

    private String contenido;

    private Date fechaEdicion;

    private UsuarioDTO usuario;

    private String tipoPost;  // Ej: "anclado" o "normal"

    private List<PostComentarioDTO> postComentarios;

    private Integer numLikes = 0;

    private CategoriaDTO categoria;

    private String urlImagen;

    public PostDTO() {
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setID(int id) {
        ID = id;
    }
    public int getID() {
        return ID;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getTipoPost() {
        return tipoPost;
    }

    public void setTipoPost(String tipoPost) {
        this.tipoPost = tipoPost;
    }

    public List<PostComentarioDTO> getPostComentarios() {
        return postComentarios;
    }

    public void setPostComentarios(List<PostComentarioDTO> postComentarios) {
        this.postComentarios = postComentarios;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
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
        return "PostDTO{" + "fechaCreacion=" + fechaCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaEdicion=" + fechaEdicion + ", usuario=" + usuario + ", tipoPost=" + tipoPost + ", postComentarios=" + postComentarios + ", numLikes=" + numLikes + ", categoria=" + categoria + ", urlImagen=" + urlImagen + '}';
    }

}
