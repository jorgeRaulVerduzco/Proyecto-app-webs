<%-- 
    Document   : VerComentarios
    Created on : 19 nov 2024, 9:31:18 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.ComentarioDTO"%>
<%@page import="java.util.List"%>
<%@page import="DTO.PostDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ver publicacion</title>
        <link rel="preload" href="${pageContext.request.contextPath}/CSS/commentStyle.css" as="style" onload="this.rel = 'stylesheet'">
    </head>
    <body>

        <%
           List<ComentarioDTO> comentarios = (List<ComentarioDTO>) request.getAttribute("comentarios");
        %>





        <div class="main-comment">
            <div class="comentarioContenedor">
                <div class="comment-box">
                    <div class="user">
                        <img src="https://via.placeholder.com/150" alt="User Avatar">
                        <div class="user-name">
                            <span>User Name</span>
                        </div>
                    </div>
                    <div class="form-comment">
                        <form action="">
                            <div class="textArea">
                                <textarea id="comentario" name="comentario" rows="10" cols="30"
                                          placeholder="Comentario"></textarea>
                            </div>
                            <div class="btn-comment-submit">
                                <button class="comment-submit" type="submit"><span>Comentar</span></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <% 
                if (comentarios != null && !comentarios.isEmpty()) {
                    for (ComentarioDTO comentario : comentarios) {
            %>
            <div class="container-comments">
                <div class="comentarioContenedor">
                    <div class="comment-box">
                        <div class="user">
                            <img src="https://via.placeholder.com/150" alt="User Avatar">
                            <div class="user-name">
                                <span><%= comentario.getUsuario().getNombreUsuario() %></span>
                            </div>
                        </div>
                        <div class="area-comment">
                            <!--aqui se colocara el comentario del usuario-->
                            <div class="comment">
                                <%= comentario.getContenido() %>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <% 
                    }
                } else { 
            %>
            <li>No hay comentarios disponibles.</li>
                <% 
                    }
                %>


        </div>

    </body>
</html>