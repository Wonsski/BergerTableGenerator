package pl.polsl.rajda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.rajda.model.BergerTableGenerationStrategy;
import pl.polsl.rajda.model.Player;
import pl.polsl.rajda.model.Round;
import pl.polsl.rajda.model.Table;


/**
 * Servlet to generate Berger tables.
 * 
 * @author Radosław Rajda
 * @version 1.0
 */
@WebServlet("/generate")
public class TableGeneratorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Pobierz liczbę graczy z parametru żądania
        String playersAmountParam = request.getParameter("playersAmount");
        int playersAmount = 0;

        playersAmount = Integer.parseInt(playersAmountParam);
        if (playersAmount < 2) {
            throw new IllegalArgumentException("The number of players must be greater than 1.");
        }

        // Tworzenie graczy z domyślnymi nazwami
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playersAmount; i++) {
            players.add(new Player("Player " + i));
        }

        // Generowanie tabeli za pomocą strategii
        Table table = new Table(players, new BergerTableGenerationStrategy());

        // Generowanie odpowiedzi w HTML
        out.println("<html><body>");
        out.println("<h1>Berger Table</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Round</th><th>Matches</th></tr>");

        List<Round> rounds = table.getRounds();
        for (int i = 0; i < rounds.size(); i++) {
            out.println("<tr>");
            out.println("<td>Round " + (i + 1) + "</td>");
            out.println("<td>" + rounds.get(i).toString() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<p>Total games: " + ((playersAmount * (playersAmount - 1)) / 2) + "</p>");
        out.println("</body></html>");
    }
}
