package pl.polsl.rajda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

/**
 * Servlet to handle user login.
 * 
 * @version 1.0
 * @author Radosław Rajda
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple authentication logic (replace with real authentication)
        if ("admin".equals(username) && "password".equals(password)) {
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(userCookie);
            response.sendRedirect("/BergerWeb/index.html");
        } else {
            response.sendRedirect("/BergerWeb/login.html?error=Invalid username or password");
        }
    }
}