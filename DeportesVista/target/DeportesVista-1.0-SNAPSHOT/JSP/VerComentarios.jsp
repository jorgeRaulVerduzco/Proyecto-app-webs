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
                        <div class="textArea">
                            <textarea id="comentario" name="comentario" rows="10" cols="30"
                                      placeholder="Comentario"></textarea>
                        </div>
                        <div class="btn-comment-submit">
                            <button onclick="comentar()" class="comment-submit" type="submit"><span>Comentar</span></button>
                        </div>
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
    <script>
function comentar() {
    const comentario = document.getElementById("comentario").value;
    fetch("${pageContext.request.contextPath}/Comentarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams({comentario: comentario})
    })
    .then(response => {
        if (!response.ok) {
            // Si no es 200, lanza un error para ir al catch
            return response.text().then(errorMessage => { throw new Error(errorMessage); });
        }
        return response.text(); // O response.json() si el servidor responde en JSON
    })
    .then(data => {
        // Si llega aquí, significa que la respuesta fue 200 OK
        // Recarga la página
        window.location.reload();
    })
    .catch(error => {
        // Si hubo un error, muestra el mensaje de error al usuario
        alert("Error: no se guardo el comentario");
    });
}

    </script>
</html>