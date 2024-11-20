package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Unit tests for the Round class.
 */
public class RoundTest {

    @Test
    public void testToString() {
        // Arrange
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        Pair pair = new Pair(player1, player2);

        Round round = new Round(List.of(pair));

        // Act
        String result = round.toString();

        // Assert
        assertEquals("(Alice vs Bob) ", result);
    }
}
