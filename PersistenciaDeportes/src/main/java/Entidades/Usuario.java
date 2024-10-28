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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author INEGI
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "nombreUsuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id", nullable = false)
    private Rol rol;

    @Column(name = "genero", nullable = false)
    private String genero;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "municipio_id", referencedColumnName = "id")
    private Municipio municipio;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private Estado estado;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String nombreUsuario, String contrasenia, String telefono, Date fechaNacimiento, List<Post> posts, List<Comentario> comentarios, Rol rol, String genero, Municipio municipio, Estado estado) {
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

    public Usuario() {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correo=" + correo + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", posts=" + posts + ", comentarios=" + comentarios + ", rol=" + rol + ", genero=" + genero + ", municipio=" + municipio + ", estado=" + estado + '}';
    }

}
