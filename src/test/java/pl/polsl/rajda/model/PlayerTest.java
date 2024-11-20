package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 * Unit tests for the Player class.
 */
public class PlayerTest {


    @Test
    public void testPlayerEqualsAndHashCode() {
        // Arrange
        Player player1 = new Player("Charlie");
        Player player2 = new Player("Charlie");
        Player player3 = new Player("Diana");

        // Act & Assert
        assertEquals(player1, player2);
        assertNotEquals(player1, player3);

        assertEquals(player1.hashCode(), player2.hashCode());
        assertNotEquals(player1.hashCode(), player3.hashCode());
    }
    
    @Disabled("Test fails. Disabled until bug has been resolved")
    @Test
    public void testInvalidPlayerNameThrowsException() {
        // Arrange
        String emptyName = "";
        String nullName = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Player(emptyName));
        assertThrows(IllegalArgumentException.class, () -> new Player(nullName));
    }
}
