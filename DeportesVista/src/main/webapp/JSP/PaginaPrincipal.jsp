<%-- 
    Document   : PaginaPrincipal
    Created on : 19 nov 2024, 9:30:00 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Ver Publicaciones</title>
  <link rel="preload" href="${pageContext.request.contextPath}/CSS/paginaPrincipalStyle.css" as="style" onload="this.rel='stylesheet'">
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
       <!--aqui se imprimen las publicaciones ancladas-->
      </div>
    </section>

    <section class="publicaciones">
      <h2>Publicaciones</h2>

        <jsp:include page="/Post" />

      <article class="publicacion-normal">
        <h3>Cristiano nunca sera mejor que messi 😹</h3>
        <p>
          Simplemente cristiano no le mueve ni le sabe, messi 2 años menos que
          cristiano y ya tiene una copa del mundo mientras que cr7 cero
          😹😹.
        </p>
        <img src="https://cdn.abcotvs.com/dip/images/10670663_10168817623567850_4517994180212703123_n.jpg"
          alt="Cristiano Ronaldo vs Messi" class="imagen-publicacion">
      </article>
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
