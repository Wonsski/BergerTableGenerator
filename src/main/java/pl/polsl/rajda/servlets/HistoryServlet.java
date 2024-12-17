package pl.polsl.rajda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import pl.polsl.rajda.model.*;

/**
 * Servlet to access the history of generated Berger tables.
 * 
 * @version 1.0
 * @author Radosław Rajda
 */
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Check for authentication cookie
        Cookie[] cookies = request.getCookies();
        boolean authenticated = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    authenticated = true;
                    break;
                }
            }
        }

        if (!authenticated) {
            response.sendRedirect("/BergerWeb/login.html");
            return;
        }

        TableModel model = (TableModel) getServletContext().getAttribute("tableModel");
        if (model == null) {
            out.println("<html><body>");
            out.println("<h1>History of Generated Tables</h1>");
            out.println("<p>No history available.</p>");
            out.println("</body></html>");
            return;
        }

        out.println("<html><body>");
        out.println("<h1>History of Generated Tables</h1>");
        out.println("<ul>");

        for (Table table : model.getHistory()) {
            out.println("<li>" + table.toHtml() + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}