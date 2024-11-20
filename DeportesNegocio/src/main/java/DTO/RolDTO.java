/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author INEGI
 */
public class RolDTO {

    private String tipoRol;  // pues aqui serian: "admin" o "normal"

    public RolDTO() {
    }

    public RolDTO(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    @Override
    public String toString() {
        return "RolDTO{" + "tipoRol=" + tipoRol + '}';
    }
    
}
