<%-- 
    Document   : Administracion2
    Created on : 19 nov 2024, 9:29:37 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            background-color: red;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>
    <h1>Panel Administrativo</h1>
    
    <!-- Sección de Publicaciones -->
    <h2>Publicaciones</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Contenido</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody id="publicaciones-lista">
            <tr>
                <td>1</td>
                <td>Primera Publicación</td>
                <td>Este es el contenido de la primera publicación</td>
                <td>
                    <button onclick="verPublicacion(1)">Ver</button>
                    <button onclick="borrarPublicacion(1)">Borrar</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Segunda Publicación</td>
                <td>Este es el contenido de la segunda publicación</td>
                <td>
                    <button onclick="verPublicacion(2)">Ver</button>
                    <button onclick="borrarPublicacion(2)">Borrar</button>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- Sección de Comentarios -->
    <h2>Comentarios</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Comentario</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody id="comentarios-lista">
            <tr>
                <td>101</td>
                <td>Este es un comentario sobre la primera publicación</td>
                <td>
                    <button onclick="verComentario(101)">Ver</button>
                    <button onclick="borrarComentario(101)">Borrar</button>
                </td>
            </tr>
            <tr>
                <td>102</td>
                <td>Otro comentario más</td>
                <td>
                    <button onclick="verComentario(102)">Ver</button>
                    <button onclick="borrarComentario(102)">Borrar</button>
                </td>
            </tr>
        </tbody>
    </table>

    <script>
        // Función para ver una publicación
        function verPublicacion(id) {
            alert('Ver publicación con ID: ' + id);
        }

        // Función para borrar una publicación
        function borrarPublicacion(id) {
            if (confirm('¿Estás seguro de borrar esta publicación?')) {
                alert('Publicación con ID ' + id + ' borrada.');
                // Eliminar del DOM
                const fila = document.querySelector(`#publicaciones-lista tr:nth-child(${id})`);
                fila.remove();
            }
        }

        // Función para ver un comentario
        function verComentario(id) {
            alert('Ver comentario con ID: ' + id);
        }
        // Función para borrar un comentario
        function borrarComentario(id) {
            if (confirm('¿Estás seguro de borrar este comentario?')) {
                alert('Comentario con ID ' + id + ' borrado.');
                const fila = document.querySelector(`#comentarios-lista tr:nth-child(${id - 100})`);
                fila.remove();
            }
        }
    </script>
</body>
</html>
