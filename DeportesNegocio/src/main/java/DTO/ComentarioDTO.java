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
public class ComentarioDTO {

    private int id;
    private Date fechaHora;

    private String contenido;

    private UsuarioDTO usuario;

    private List<PostComentarioDTO> postComentarios;

    private Integer numLikes;

    public ComentarioDTO() {
    }

    public ComentarioDTO(Date fechaHora, String contenido, UsuarioDTO usuario, List<PostComentarioDTO> postComentarios, Integer numLikes) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.postComentarios = postComentarios;
        this.numLikes = numLikes;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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

    @Override
    public String toString() {
        return "ComentarioDTO{" + "fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuario=" + usuario + ", postComentarios=" + postComentarios + ", numLikes=" + numLikes + '}';
    }

}
