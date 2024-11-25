/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;


import DTO.PostDTO;

/**
 *
 * @author copad
 */
public class Prueba {

    public static void main(String[] args) {
        // Instancia de PostBO
        PostBO postBO = new PostBO();

        try {
            PostDTO post=postBO.consultarPublicacionesById(2);
            System.out.println("Post: " + post);
            


        } catch (Exception e) {
            System.err.println("Error al consultar publicaciones: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
