package pl.polsl.rajda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.rajda.entities.BergerTableEntity;
import pl.polsl.rajda.entities.DALManager;
import pl.polsl.rajda.model.*;

/**
 * Servlet to generate Berger tables.
 * 
 * @version 1.0
 * @author Radosław Rajda
 */
@WebServlet("/generate")
public class TableGeneratorServlet extends HttpServlet {
    /**
     * Initializes the servlet and sets up the TableModel.
     * 
     * @throws ServletException if an initialization error occurs
     */
    @Override
    public void init() throws ServletException {
        TableModel model = new TableModel();
        DALManager dal = new DALManager();
        getServletContext().setAttribute("tableModel", model);
        getServletContext().setAttribute("DALManager", dal);
    }

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

        try {
            String playersAmountParam = request.getParameter("playersAmount");
            int playersAmount = Integer.parseInt(playersAmountParam);

            if (playersAmount < 2) {
                throw new IllegalArgumentException("The number of players must be greater than 1.");
            }

            List<Player> players = new ArrayList<>();
            boolean useCustomNames = "on".equals(request.getParameter("customNames"));

            for (int i = 1; i <= playersAmount; i++) {
                String playerName = request.getParameter("playerName" + i);
                if (useCustomNames && playerName != null && !playerName.trim().isEmpty()) {
                    players.add(new Player(playerName));
                } else {
                    players.add(new Player("Player " + i));
                }
            }

            TableModel model = (TableModel) getServletContext().getAttribute("tableModel");
            DALManager dal = (DALManager) getServletContext().getAttribute("DALManager");
            Table table = model.generateTable(players);
            BergerTableEntity entity = new BergerTableEntity();
            dal.persistObject(entity);
            
            out.println("<html><body>");
            out.println("<h1>Berger Table</h1>");
            out.println(table.toHtml());
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("Invalid number format. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        } catch (Exception e) {
            out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}