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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author INEGI
 */
@Entity
@Table(name = "Comentario")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(length = 255, nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL)
    private List<PostComentario> postComentarios;

    @Column(name = "num_likes")
    private Integer numLikes;

    public Comentario() {
    }

    public Comentario(Date fechaHora, String contenido, Usuario usuario, List<PostComentario> postComentarios, Integer numLikes) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.postComentarios = postComentarios;
        this.numLikes = numLikes;
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

    public Date getFechaHora() {
        return fechaHora;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PostComentario> getPostComentarios() {
        return postComentarios;
    }

    public void setPostComentarios(List<PostComentario> postComentarios) {
        this.postComentarios = postComentarios;
    }

}
