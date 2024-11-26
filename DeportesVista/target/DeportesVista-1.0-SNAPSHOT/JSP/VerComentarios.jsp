<%-- 
    Document   : VerComentarios
    Created on : 19 nov 2024, 9:31:18 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ver publicacion</title>
        <link rel="preload" href="${pageContext.request.contextPath}/CSS/commentStyle.css" as="style" onload="this.rel = 'stylesheet'">
    </head>
    <body>





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

            <c:forEach var="comentario" items="${comentarios}">
                <div class="container-comments">
                    <div class="comentarioContenedor">
                        <div class="comment-box">
                            <div class="user">
                                <img src="https://via.placeholder.com/150" alt="User Avatar">
                                <div class="user-name">
                                    <span>${comentario.usuario.nombreUsuario}</span> <!-- Accediendo correctamente al nombre del usuario -->
                                </div>
                            </div>
                            <div class="area-comment">
                                <!-- Aquí se colocará el comentario del usuario -->
                                <div class="comment">
                                    ${comentario.contenido} <!-- Accediendo correctamente al contenido del comentario -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!-- Si no hay comentarios, mostramos un mensaje con JSTL -->
            <c:if test="${empty comentarios}">
                <li>No hay comentarios disponibles.</li>
            </c:if>


        </div>

    </body>
</html>