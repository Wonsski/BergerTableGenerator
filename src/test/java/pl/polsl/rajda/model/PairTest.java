package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Pair class.
 * Verifies the behavior of Pair instances.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class PairTest {

    /**
     * Test the toString method for Pair class.
     * Ensures correct string representation of a pair.
     */
    @Test
    public void testToString() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        Pair pair = new Pair(player1, player2);

        assertEquals("(Alice vs Bob)", pair.toString(), "Pair's string representation should be correctly formatted.");
    }
}
