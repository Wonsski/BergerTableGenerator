package pl.polsl.rajda.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for Table class.
 */
public class TableTest {

    @Test
    public void testRoundGeneration() {
        // Arrange
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

        // Act
        List<Round> rounds = table.getRounds();

        // Assert
        assertEquals(1, rounds.size(), "Table should generate one round.");
    }
}
