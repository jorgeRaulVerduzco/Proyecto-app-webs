/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Negocio.PostBO;

import java.util.ArrayList;
import java.util.List;

import DTO.ComentarioDTO;

/**
 *
 * @author copad
 */
public class Prueba {

    public static void main(String[] args) {
        // Instancia de PostBO
        ComentarioBO comentarioBO = new ComentarioBO();

        try {
            // Llamar al método que consulta publicaciones
            List<ComentarioDTO> comentarioList = comentarioBO.consultarComentarios(2);

            // Mostrar los resultados
            System.out.println("Listado de publicaciones:");
            for (ComentarioDTO comentario : comentarioList) {
                System.out.println(comentario.getContenido());
            }


        } catch (Exception e) {
            System.err.println("Error al consultar publicaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
