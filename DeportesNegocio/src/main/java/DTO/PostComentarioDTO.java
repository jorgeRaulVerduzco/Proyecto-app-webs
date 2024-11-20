/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author INEGI
 */
public class PostComentarioDTO {

    private PostDTO post;
    private ComentarioDTO comentario;

    public PostComentarioDTO() {
    }

    public PostComentarioDTO(PostDTO post, ComentarioDTO comentario) {
        this.post = post;
        this.comentario = comentario;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public ComentarioDTO getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioDTO comentario) {
        this.comentario = comentario;
    }

}
