/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author INEGI
 */
public class EstadoDTO {

    private String nombre;
    private UsuarioDTO usuario;

    public EstadoDTO() {
    }

    public EstadoDTO(String nombre, UsuarioDTO usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "EstadoDTO{" + "nombre=" + nombre + ", usuario=" + usuario + '}';
    }
}