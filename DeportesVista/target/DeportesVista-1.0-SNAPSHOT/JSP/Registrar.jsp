<%-- 
    Document   : Registrar
    Created on : 19 nov 2024, 9:28:11 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar</title>
        <link rel="stylesheet" href="../CSS/loginStyle.css">
        <script src="../javaScript/validarInputs.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <div class="logo-container">
                    <img src="imagenes/Sport_Logo-removebg.png" alt="">
                </div>
                <h1>Registrarse</h1>
                <form action="${pageContext.request.contextPath}/Registrar" method="POST">
                    <!-- Grupo 1: Información Personal Básica -->
                    <div id="grupo_1" class="grupo_1">
                        <div class="input-user">
                            <input id="name" required type="text" name="nombre" autocomplete="off" class="input" />
                            <label class="user-label">Nombre</label>
                        </div>
                        <div id="error-name"></div>

                        <div class="input-user">
                            <input id="apellidoPaterno" required type="text" name="apellidoPaterno" autocomplete="off" class="input" />
                            <label class="user-label">Apellido Paterno</label>
                        </div>
                        <div id="error-apellidoPaterno"></div>

                        <div class="input-user">
                            <input id="apellidoMaterno" required type="text" name="apellidoMaterno" autocomplete="off" class="input" />
                            <label class="user-label">Apellido Materno</label>
                        </div>
                        <div id="error-apellidoMaterno"></div>

                        <div id="emailElement" class="input-user">
                            <input id="email" required type="email" name="email" autocomplete="off" class="input" />
                            <label class="user-label">Correo electrónico</label>
                        </div>
                        <div id="errorEmail"></div>

                        <div class="input-user">
                            <input id="nombreUsuario" required type="text" name="nombreUsuario" autocomplete="off" class="input" />
                            <label class="user-label">Nombre de Usuario</label>
                        </div>
                        <div id="error-nombreUsuario"></div>

                        <div id="passwordElement" class="input-user">
                            <input id="password" required type="password" name="password" autocomplete="off" class="input" />
                            <label class="user-label">Contraseña</label>
                        </div>
                        <div id="errorContraseña"></div>
                    </div>

                    <!-- Grupo 2: Información Adicional -->
                    <div id="grupo_2" class="grupo_2">
                        <div class="input-user">
                            <input id="phone_number" required type="tel" name="telefono" autocomplete="off" class="input" />
                            <label class="user-label">Teléfono</label>
                        </div>
                        <div id="error-phone_number"></div>

                        <div id="dateElement" class="input-user">
                            <input id="nacimiento" required type="date" name="fechaNacimiento" autocomplete="off" class="input input-date" />
                            <label class="user-label">Fecha de nacimiento</label>
                        </div>
                        <div id="error-nacimiento"></div>

                        <!-- Ubicación -->
                        <div class="input-user">
                            <input id="estado" required type="text" name="estado" autocomplete="off" class="input" />
                            <label class="user-label">Estado</label>
                        </div>
                        <div id="error-estado"></div>

                        <div class="input-user">
                            <input id="municipio" required type="text" name="municipio" autocomplete="off" class="input" />
                            <label class="user-label">Municipio</label>
                        </div>
                        <div id="error-municipio"></div>

                        <!-- Género -->
                        <div id="genderElement" class="input-user-radio">
                            <p>Género:</p>
                            <div class="input-container">
                                <div class="inputGenero">
                                    <input type="radio" id="gender-male" name="genero" value="hombre" required>
                                    <span for="gender-male">Hombre</span>
                                </div>
                                <div class="inputGenero">
                                    <input type="radio" id="gender-female" name="genero" value="mujer">
                                    <span for="gender-female">Mujer</span>
                                </div>
                                <div class="inputGenero">
                                    <input type="radio" id="gender-other" name="genero" value="otro">
                                    <span for="gender-other">Otro</span>
                                </div>
                            </div>
                            <div id="error-gender"></div>
                        </div>

                        <!-- Campo oculto para el rol (por defecto 'usuario') -->
                        <input type="hidden" name="rol" value="usuario">
                    </div>

                    <button id="botonSiguiente" type="submit">Registrar</button>
                </form>
            </div>
        </div>
        <footer>
            <p>© 2024 Blog Deportes. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>