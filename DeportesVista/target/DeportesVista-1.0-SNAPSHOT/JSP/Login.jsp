<%-- 
    Document   : Login
    Created on : 19 nov 2024, 9:28:29 p.m.
    Author     : INEGI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/loginStyle.css">

    </head>
    <body>
        <div class="container">
            <div class="form-container">
                <div class="logo-container">
                    <img src="imagenes/Sport_Logo-removebg.png" alt="">
                </div>
                <h1>
                    <span>Inicia Sesión</span>
                </h1>

                <%
                    String error = (String) request.getAttribute("error");
                    if (error != null) {
                %>
                <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                    <%= error%>
                </div>
                <%
                    }
                %>

               <form id="loginForm" action="${pageContext.request.contextPath}/Login" method="post">
                    <div id="emailElement" class="input-user">
                        <input
                            id="email"
                            required
                            type="text"
                            name="email"
                            autocomplete="off"
                            class="input"
                            />
                        <label class="user-label">Correo electrónico</label>
                    </div>
                    <div id="errorEmail"></div>

                    <div id="passwordElement" class="input-user">
                        <input
                            id="password"
                            required
                            type="password"
                            name="password"
                            class="input"
                            />
                        <label class="user-label">Contraseña</label>
                    </div>
                    <div id="errorContraseña"></div>

                    <a href="${pageContext.request.contextPath}/JSP/Registrar.jsp">¿No tienes cuenta?</a>
                    <button type="submit">Iniciar sesión</button>
                </form>

            </div>
        </div>
        <footer>
            <p>© 2024 Blog Deportes. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>