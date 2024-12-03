package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Unit tests for the Round class.
 * Verifies the behavior of Round instances.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class RoundTest {

    /**
     * Test the toString method for Round class.
     * Ensures the round matches the expected format for pair representation.
     */
    @Test
    public void testToString() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Pair pair = new Pair(player1, player2);

        Round round = new Round(List.of(pair));

        assertEquals("(Alice vs Bob) ", round.toString(), "Round's string representation should match the expected format.");
    }
}
