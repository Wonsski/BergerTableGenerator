package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Pair class.
 */
public class PairTest {

    @Test
    public void testToString() {
        // Arrange
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        // Act
        Pair pair = new Pair(player1, player2);

        // Assert
        assertEquals("(Alice vs Bob)", pair.toString());
    }
}
