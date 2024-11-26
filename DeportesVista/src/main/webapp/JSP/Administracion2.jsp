<%-- 
    Document   : Administracion2
    Created on : 19 nov 2024, 9:29:37 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="DTO.PostDTO"%>
<%@page import="DTO.ComentarioDTO"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel Administrativo</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            margin: 20px; 
            line-height: 1.6; 
        }
        table { 
            width: 100%; 
            border-collapse: collapse; 
            margin-bottom: 20px; 
        }
        table, th, td { 
            border: 1px solid #ddd; 
        }
        th, td { 
            padding: 12px; 
            text-align: left; 
        }
        th { 
            background-color: #f2f2f2; 
        }
        .acciones {
            display: flex;
            gap: 10px;
        }
        .btn {
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .btn-ver { background-color: #4CAF50; color: white; }
        .btn-editar { background-color: #2196F3; color: white; }
        .btn-eliminar { background-color: #f44336; color: white; }
    </style>
</head>
<body>
    <h1>Panel Administrativo</h1>
        <jsp:include page="/AdminPanel" />

    <!-- Sección de Publicaciones -->
    <h2>Publicaciones</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Contenido</th>
                <th>Autor</th>
                <th>Fecha Creación</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<PostDTO> publicaciones = (List<PostDTO>) request.getAttribute("publicaciones");
            if (publicaciones != null) {
                for (PostDTO post : publicaciones) { 
            %>
            <tr>
                <td><%= post.getID() %></td>
                <td><%= post.getTitulo() %></td>
                <td><%= post.getContenido() %></td>
                <td><%= post.getUsuario().getNombreUsuario() %></td>
                <td><%= post.getFechaCreacion() != null ? post.getFechaCreacion().toString() : "Sin fecha" %></td>
                <td class="acciones">
                    <form action="Administracion" method="post">
                        <input type="hidden" name="accion" value="editarPublicacion">
                        <input type="hidden" name="idPost" value="<%= post.getID() %>">
                        <button type="button" class="btn btn-editar" onclick="mostrarFormularioEdicion(this)">Editar</button>
                    </form>
                    <form action="Administracion" method="post">
                        <input type="hidden" name="accion" value="eliminarPublicacion">
                        <input type="hidden" name="idPost" value="<%= post.getID() %>">
                        <button type="submit" class="btn btn-eliminar" onclick="return confirm('¿Estás seguro de eliminar esta publicación?')">Eliminar</button>
                    </form>
                </td>
            </tr>
            <% } } %>
        </tbody>
    </table>

    <!-- Sección de Comentarios -->
    <h2>Comentarios</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Contenido</th>
                <th>Autor</th>
                <th>Fecha</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<ComentarioDTO> comentarios = (List<ComentarioDTO>) request.getAttribute("comentarios");
            if (comentarios != null) {
                for (ComentarioDTO comentario : comentarios) { 
            %>
            <tr>
                <td><%= comentario.getId() %></td>
                <td><%= comentario.getContenido() %></td>
                <td><%= comentario.getUsuario().getNombreUsuario() %></td>
                <td><%= comentario.getFechaHora() != null ? comentario.getFechaHora().toString() : "Sin fecha" %></td>
                <td class="acciones">
                    <form action="Administracion" method="post">
                        <input type="hidden" name="accion" value="eliminarComentario">
                        <input type="hidden" name="idComentario" value="<%= comentario.getId() %>">
                        <button type="submit" class="btn btn-eliminar" onclick="return confirm('¿Estás seguro de eliminar este comentario?')">Eliminar</button>
                    </form>
                </td>
            </tr>
            <% } } %>
        </tbody>
    </table>

    <script>
    function mostrarFormularioEdicion(boton) {
        const fila = boton.closest('tr');
        const titulo = fila.querySelector('td:nth-child(2)').textContent;
        const contenido = fila.querySelector('td:nth-child(3)').textContent;
        const idPost = fila.querySelector('input[name="idPost"]').value;

        const formularioEdicion = `
            <form action="Administracion" method="post">
                <input type="hidden" name="accion" value="editarPublicacion">
                <input type="hidden" name="idPost" value="${idPost}">
                <input type="text" name="titulo" value="${titulo}" required>
                <textarea name="contenido" required>${contenido}</textarea>
                <button type="submit">Guardar</button>
                <button type="button" onclick="cancelarEdicion(this)">Cancelar</button>
            </form>
        `;

        const celdaAcciones = fila.querySelector('.acciones');
        const contenidoOriginal = celdaAcciones.innerHTML;
        celdaAcciones.innerHTML = formularioEdicion;

        function cancelarEdicion(botonCancelar) {
            celdaAcciones.innerHTML = contenidoOriginal;
        }
    }
    </script>
</body>
</html>