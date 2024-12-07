/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;


import DTO.PostDTO;

import java.util.Date;

import Entidades.Usuario;
import DTO.ComentarioDTO;
import DTO.UsuarioDTO;
import Negocio.ComentarioBO;
import Negocio.UsuarioBO;

/**
 *
 * @author copad
 */
public class Prueba {

    public static void main(String[] args) {
        UsuarioBO usuario = new UsuarioBO();
        UsuarioDTO usua = usuario.obtenerUsuarioPorEmail("copadoe6@gmail.com");
        Date fecha = new Date();
        // Instancia de PostBO
        ComentarioDTO com = new ComentarioDTO();
        com.setContenido("hola este es comentario 2");
        com.setFechaHora(fecha);
        com.setUsuario(usua);
        com.setNumLikes(1);

        ComentarioBO comentarios = new ComentarioBO();
       


        try {
            comentarios.registrarComentario(com, 1);         


        } catch (Exception e) {
            System.err.println("Error al consultar publicaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
