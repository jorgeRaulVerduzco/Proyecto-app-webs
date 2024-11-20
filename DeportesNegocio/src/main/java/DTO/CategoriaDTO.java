/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 *
 * @author INEGI
 */
public class CategoriaDTO {
    private String nombre;

    private List<PostDTO> posts;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nombre, List<PostDTO> posts) {
        this.nombre = nombre;
        this.posts = posts;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" + "nombre=" + nombre + ", posts=" + posts + '}';
    }
}
