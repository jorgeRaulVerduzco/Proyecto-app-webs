/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servicio;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ruben
 */
@WebFilter("/*")
public class AutFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Verifica si el usuario tiene sesión activa
        boolean isLoggedIn = (session != null && session.getAttribute("usuario") != null);
        String loginURI = httpRequest.getContextPath() + "/JSP/Login.jsp";

        if (isLoggedIn || httpRequest.getRequestURI().equals(loginURI)) {
            chain.doFilter(request, response);
        } else {
            // Redirige al login solo si no estás en Login.jsp
            httpResponse.sendRedirect(loginURI);
        }

    }

    @Override
    public void destroy() {
    }
}
