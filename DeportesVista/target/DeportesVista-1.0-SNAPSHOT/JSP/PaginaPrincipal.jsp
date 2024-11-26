<%-- 
    Document   : PaginaPrincipal
    Created on : 19 nov 2024, 9:30:00 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Ver Publicaciones</title>
        <link rel="preload" href="${pageContext.request.contextPath}/CSS/paginaPrincipalStyle.css" as="style" onload="this.rel = 'stylesheet'">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
        <link rel="stylesheet" href="CSS/animation.css">
        <style>
            .hidden {
                display: none;
            }
        </style>
    </head>

    <body>
        <nav class="navbar">
            <ul>
                <div class="navContainer">
                    <img src="imagenes/Sport_Logo-removebg.png" width="25" alt="">
                    <li><a href="PaginaPrincipal.jsp">AROWWAI</a></li>
                    <li><a href="login.jsp">Iniciar sesión</a></li>
                    <li><a href="Publicaciones.jsp">Crear publicación</a></li>
                    <li><a href="Administracion2.jsp">Administrativo</a></li>
                    <li><button id="darkModeToggle" class="dark-mode-btn">Modo Oscuro</button></li>
                </div>
            </ul>
        </nav>

        <header>
            <h1>Publicaciones</h1>
        </header>

        <main>
            <section class="publicacion">

                <h2>Publicación Anclada</h2>
                <div id="publicacionesAncladas" class="publicacionesAd">
                    <c:choose>
                    <c:when test="${not empty postList}">
                        <c:forEach var="post" items="${postList}">
                            <c:if test="${post.tipoPost == 'anclada'}">
                                <article class='anclada'>
                                    <div class='usuario'>
                                        <div class='usuarioImg'>
                                            <img src='' alt=''>
                                        </div>
                                        <div class='usuarioNombre'>
                                            <span>${post.usuario.nombreUsuario}</span>
                                        </div>
                                    </div>

                                    <div class='descripcion'>
                                        <h3>${post.titulo}</h3>
                                        <p>${post.contenido}</p>
                                    </div>

                                    <img src="${post.getUrlImagen()}" alt="Imagen de la publicación" class='imagen-publicacion'>
                                    <br>

                                    <div class='interacciones'>
                                        <div class='historia'>
                                            <span>Likes: 123</span>
                                            <span>Comentarios: 45</span>
                                            <span>Me gusta</span>
                                        </div>
                                        <div class='btn-post'>
                                            <form action="${pageContext.request.contextPath}/Comentarios" method="GET">
                                                <input type="hidden" name="id" value="${post.getID()}">
                                                <div class="bnt-gen">
                                                    <button class="btn-comentar" type="submit">
                                                        <svg xmlns="http://www.w3.org/2000/svg" class="icono-comentar" width="21" height="21" viewBox="0 0 24 24" fill="none" stroke="#6c757d" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                        <path fill="#858b93" d="M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z"></path>
                                                        </svg>
                                                        <span class="contenedorNombre">Comentar</span>
                                                    </button>
                                                </div>
                                            </form>

                                            <button class="btn-megusta">
                                                <div id="animateElement" class="animate__animated">
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="icono-megusta" width="21" height="21" viewBox="0 0 24 24" fill="#858b93" stroke="none" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                    <path d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path>
                                                    </svg>
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="icono-megusta hidden" width="21" height="21" viewBox="0 0 24 24" fill="none" stroke="none" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                    <path d="M20.884 13.19c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path>
                                                    </svg>
                                                </div>
                                                <span class="contenedorNombre">Me gusta</span>
                                            </button>
                                        </div>
                                    </div>
                                </article>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>No hay publicaciones disponibles.</p>
                    </c:otherwise>
                </c:choose>
                    
                </div>
            </section>

            <section class="publicaciones">
                <h2>Publicaciones</h2>
                <c:choose>
                    <c:when test="${not empty postList}">
                        <c:forEach var="post" items="${postList}">
                            <c:if test="${post.tipoPost == 'normal'}">
                                <article class='publicacion-normal'>
                                    <div class='usuario'>
                                        <div class='usuarioImg'>
                                            <img src='' alt=''>
                                        </div>
                                        <div class='usuarioNombre'>
                                            <span>${post.usuario.nombreUsuario}</span>
                                        </div>
                                    </div>

                                    <div class='descripcion'>
                                        <h3>${post.titulo}</h3>
                                        <p>${post.contenido}</p>
                                    </div>

                                    <img src="${post.getUrlImagen()}" alt="Imagen de la publicación" class='imagen-publicacion'>
                                    <br>

                                    <div class='interacciones'>
                                        <div class='historia'>
                                            <span>Likes: 123</span>
                                            <span>Comentarios: 45</span>
                                            <span>Me gusta</span>
                                        </div>
                                        <div class='btn-post'>
                                            <form action="${pageContext.request.contextPath}/Comentarios" method="GET">
                                                <input type="hidden" name="id" value="${post.getID()}">
                                                <div class="bnt-gen">
                                                    <button class="btn-comentar" type="submit">
                                                        <svg xmlns="http://www.w3.org/2000/svg" class="icono-comentar" width="21" height="21" viewBox="0 0 24 24" fill="none" stroke="#6c757d" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                        <path fill="#858b93" d="M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z"></path>
                                                        </svg>
                                                        <span class="contenedorNombre">Comentar</span>
                                                    </button>
                                                </div>
                                            </form>

                                            <button class="btn-megusta">
                                                <div id="animateElement" class="animate__animated">
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="icono-megusta" width="21" height="21" viewBox="0 0 24 24" fill="#858b93" stroke="none" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                    <path d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path>
                                                    </svg>
                                                    <svg xmlns="http://www.w3.org/2000/svg" class="icono-megusta hidden" width="21" height="21" viewBox="0 0 24 24" fill="none" stroke="none" stroke-width="0.1" stroke-linecap="round" stroke-linejoin="round">
                                                    <path d="M20.884 13.19c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path>
                                                    </svg>
                                                </div>
                                                <span class="contenedorNombre">Me gusta</span>
                                            </button>
                                        </div>
                                    </div>
                                </article>
                            </c:if>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <p>No hay publicaciones disponibles.</p>
                    </c:otherwise>
                </c:choose>


            </section>
        </main>

        <footer>
            <p>Todos los derechos reservados &copy; 2024 AROWWAI</p>
        </footer>

        <script>
            const jsonUrl = 'ejemploPublicaciones.json';
            const publicacionesAncladas = document.getElementById('publicacionesAncladas');

            fetch(jsonUrl)
                    .then(response => response.json()) // Convertir la respuesta a JSON
                    .then(data => {
                        // Generar cada publicación a partir de los datos del JSON
                        data.forEach(publicacion => {
                            const article = document.createElement('article');
                            article.classList.add('anclada');

                            // Crear la estructura de cada publicación
                            article.innerHTML = `
              <div class="imgAnclada">
                <img src="${publicacion.img}" alt="${publicacion.titulo}" width="300">
              </div>
              <h3>${publicacion.titulo}</h3>
              <p>${publicacion.contenido}</p>
            `;

                            // Añadir cada artículo al contenedor
                            publicacionesAncladas.appendChild(article);
                        });
                    })
                    .catch(error => console.error('Error al cargar el archivo JSON:', error));



            // JavaScript para alternar entre los SVG
            const animateBtn = document.getElementById('animateElement');
            const btnMegusta = document.querySelector('.btn-megusta');
            const svgDefault = btnMegusta.querySelector('.icono-megusta');
            const svgLiked = btnMegusta.querySelector('.icono-megusta.hidden');
            const contenedorMegusta = document.getElementsByClassName('btn-megusta')[0];

            contenedorMegusta.addEventListener('click', () => {
                animateBtn.classList.remove('animate__rubberBand');
                void animateBtn.offsetWidth;
                animateBtn.classList.add('animate__rubberBand');
                svgDefault.classList.toggle('hidden');
                svgLiked.classList.toggle('hidden');
            });
        </script>
    </body>

</html>
