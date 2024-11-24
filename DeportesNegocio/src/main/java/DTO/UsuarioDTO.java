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
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String nombreUsuario;
    private String contrasenia;
    private String telefono;
    private Date fechaNacimiento;
    private List<PostDTO> posts;
    private List<ComentarioDTO> comentarios;
    private RolDTO rol;
    private String genero;
    private MunicipioDTO municipio; 
    private EstadoDTO estado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id,String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String nombreUsuario, String contrasenia, String telefono, Date fechaNacimiento, List<PostDTO> posts, List<ComentarioDTO> comentarios, RolDTO rol, String genero, MunicipioDTO municipio, EstadoDTO estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.posts = posts;
        this.comentarios = comentarios;
        this.rol = rol;
        this.genero = genero;
        this.municipio = municipio;
        this.estado = estado;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public MunicipioDTO getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDTO municipio) {
        this.municipio = municipio;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +"id: "+id+ "nombre=" + nombre + ", apellidoPaterno:" + apellidoPaterno + ", apellidoMaterno:" + apellidoMaterno + ", correo:" + correo + ", nombreUsuario: " + nombreUsuario + ", contrasenia: " + contrasenia + ", telefono: " + telefono + ", fechaNacimiento: " + fechaNacimiento + ", posts: " + posts + ", comentarios: " + comentarios + ", rol: " + rol + ", genero: " + genero + ", municipio: " + municipio + ", estado: " + estado + '}';
    }
}
