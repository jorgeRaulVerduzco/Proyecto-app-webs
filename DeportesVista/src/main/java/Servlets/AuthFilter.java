package Servlets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*") // Aplica el filtro a todas las rutas
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización si es necesario
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false); // Obtener sesión sin crear una nueva

        // Rutas que deben estar excluidas del filtro (como la de login)
        String loginURI = httpRequest.getContextPath() + "/Login";
        String loginPage = httpRequest.getContextPath() + "/JSP/Login.jsp";
        String singUpPage = httpRequest.getContextPath() + "/JSP/Registrar.jsp";
        String fileCssLogin = httpRequest.getContextPath() + "/CSS/loginStyle.css";
        String singUpURI = httpRequest.getContextPath() + "/Registrar";
        String javaScripSingUp = httpRequest.getContextPath() + "/javaScript/validarInputs.js";
        

        // Verifica si la URL es la de login o recursos públicos
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().equals(loginPage);
        boolean isSingUpPage = httpRequest.getRequestURI().equals(singUpPage);
        boolean isCssFileLogin = httpRequest.getRequestURI().equals(fileCssLogin);
        boolean isSingUpURI = httpRequest.getRequestURI().equals(singUpURI);
        boolean isJavaScripSingUp = httpRequest.getRequestURI().equals(javaScripSingUp);

        if (isLoginRequest || isLoginPage || isSingUpPage || isCssFileLogin || isSingUpURI || isJavaScripSingUp) {
            // Permitir acceso a /Login y a la página de login
            chain.doFilter(request, response);
            return;
        }

        // Si no es una solicitud de login, verifica la autenticación
        if (session != null && session.getAttribute("usuario") != null) {
            // Usuario autenticado
            chain.doFilter(request, response);
        } else {
            // Usuario no autenticado, redirigir a login
            httpResponse.sendRedirect(loginPage);
        }
    }

    @Override
    public void destroy() {
        // Limpieza si es necesario
    }
}
