<%-- 
    Document   : Publicaciones
    Created on : 19 nov 2024, 9:30:36 p.m.
    Author     : INEGI
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Publicación</title>
        <link rel="preload" href="${pageContext.request.contextPath}/CSS/Styles2.css" as="style" onload="this.rel = 'stylesheet'">
</head>
<body>
    <header>
        <h1>Crear Publicación</h1>
    </header>

    <main>
        <section class="formulario-publicacion">
            <h2>Crear nueva publicación</h2>

            <form id="form-publicacion" action="${pageContext.request.contextPath}/CrearPublicacion" method="POST" enctype="multipart/form-data">
                <div class="campo-formulario">
                    <label for="titulo">Título <span class="requerido">*</span></label>
                    <input type="text" id="titulo" name="titulo" required>
                </div>

                <div class="campo-formulario">
                    <label for="contenido">Contenido <span class="requerido">*</span></label>
                    <textarea id="contenido" name="contenido" rows="5" required></textarea>
                </div>

                <div class="campo-formulario">
                    <label for="categoria">Categoría</label>
                    <select id="categoria" name="categoria">
                        <option value="">Seleccione una categoría</option>
                        <option value="noticia">Noticia</option>
                        <option value="anuncio">Anuncio</option>
                        <option value="informativo">Informativo</option>
                    </select>
                </div>

                <div class="checkbox-container">
                    <input type="checkbox" id="anclar" name="anclar">
                    <label for="anclar">Anclar publicación</label>
                </div>

                <div class="campo-formulario">
                    <label for="archivo">Subir archivo adjunto</label>
                    <input type="file" id="archivo" name="archivo" accept="image/*, .pdf, .doc, .docx">
                </div>

                <div class="campo-formulario">
                    <button type="submit">Publicar</button>
                </div>
            </form>
        </section>
    </main>

    <footer>
        <p>© 2024 Blog App. All rights reserved.</p>
    </footer>
</body>
</html>