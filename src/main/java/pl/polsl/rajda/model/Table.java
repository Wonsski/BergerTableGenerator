package pl.polsl.rajda.model;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class holds all game information and manages rounds. Uses a strategy for
 * table generation based on the provided players.
 * 
 * @version 3.0
 */
@Getter
@EqualsAndHashCode
public class Table {

    /**
     * List of rounds in the game.
     */
    private List<Round> rounds;
    /**
     * List of players.
     */
    private List<Player> players;
    /**
     * Table generation strategy.
     */
    private TableGenerationStrategy generationStrategy;

    /**
     * Constructor to initialize a Table with a list of players and a generation strategy.
     *
     * @param players the list of players participating in the tournament
     * @param generationStrategy the strategy used to generate rounds
     */
    public Table(List<Player> players, TableGenerationStrategy generationStrategy) {
        this.players = players;
        this.generationStrategy = generationStrategy;
        this.rounds = generationStrategy.generateRounds(players);
    }
    
    /**
     * Generates an HTML representation of the table with styling.
     * 
     * @return HTML string
     */
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<style>")
            .append("table { width: 100%; border-collapse: collapse; margin: 20px 0; }")
            .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }")
            .append("th { background-color: #f2f2f2; }")
            .append("</style>");
        html.append("<table>");
        html.append("<tr><th>Round</th><th>Matches</th></tr>");

        for (int i = 0; i < rounds.size(); i++) {
            html.append("<tr>");
            html.append("<td>Round ").append(i + 1).append("</td>");
            html.append("<td>");
            html.append("<table border='0' style='width: 100%;'>");
            List<Pair> pairs = rounds.get(i).getPairs();
            for (Pair pair : pairs) {
                html.append("<tr><td>").append(pair.toString()).append("</td></tr>");
            }
            html.append("</table>");
            html.append("</td>");
            html.append("</tr>");
        }

        html.append("</table>");
        return html.toString();
    }
}
