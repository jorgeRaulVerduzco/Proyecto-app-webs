/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Negocio.PostBO;

import java.util.ArrayList;
import java.util.List;

import DTO.PostDTO;
import Entidades.Post;

/**
 *
 * @author copad
 */
public class Prueba {

    public static void main(String[] args) {
        // Instancia de PostBO
        PostBO postBO = new PostBO();

        try {
            // Llamar al método que consulta publicaciones
            List<PostDTO> postList = postBO.consultarPublicaciones();

            // Mostrar los resultados
            System.out.println("Listado de publicaciones:");
            for (PostDTO postDTO : postList) {
                System.out.println(postDTO.getID());
                System.out.println(postDTO); 
            }


        } catch (Exception e) {
            System.err.println("Error al consultar publicaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
