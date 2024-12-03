package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for the Table class.
 * Verifies the behavior of the Table class including round generation.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class TableTest {

    /**
     * Test the round generation for Table class with a simple custom strategy.
     * Ensures rounds are generated based on the strategy provided.
     */
    @Test
    public void testRoundGeneration() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        List<Player> players = Arrays.asList(player1, player2);
        TableGenerationStrategy strategy = new TableGenerationStrategy() {
            @Override
            public List<Round> generateRounds(List<Player> players) {
                return Arrays.asList(new Round(Arrays.asList(new Pair(player1, player2))));
            }
        };

        Table table = new Table(players, strategy);

        List<Round> rounds = table.getRounds();

        assertEquals(1, rounds.size(), "Table should generate one round.");
    }
}
