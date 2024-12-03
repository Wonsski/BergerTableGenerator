package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the TableGenerationStrategy class.
 * Verifies the abstract method `generateRounds` in a concrete implementation.
 * 
 * @version 4.0
 */
public class TableGenerationStrategyTest {

    /**
     * Test the generateRounds method for the implementation of TableGenerationStrategy.
     */
    @Test
    public void testGenerateRounds() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("A"));
        players.add(new Player("B"));
        players.add(new Player("C"));

        TableGenerationStrategy strategy = new TableGenerationStrategy() {
            @Override
            public List<Round> generateRounds(List<Player> players) {
                // Simple strategy: one round with all players.
                List<Round> rounds = new ArrayList<>();
                rounds.add(new Round(List.of(new Pair(players.get(0), players.get(1)), new Pair(players.get(1), players.get(2)))));
                return rounds;
            }
        };

        List<Round> rounds = strategy.generateRounds(players);

        assertNotNull(rounds, "Generated rounds should not be null.");
        assertEquals(1, rounds.size(), "There should be exactly one round.");
    }
}
