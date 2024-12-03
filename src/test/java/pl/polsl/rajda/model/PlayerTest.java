package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 * Unit tests for the Player class.
 * Verifies the behavior of Player instances.
 * 
 * @version 4.0
 */
public class PlayerTest {

    /**
     * Test equals and hashCode methods for Player.
     */
    @Test
    public void testPlayerEqualsAndHashCode() {
        Player player1 = new Player("Charlie");
        Player player2 = new Player("Charlie");
        Player player3 = new Player("Diana");

        assertEquals(player1, player2, "Players with the same name should be equal.");
        assertNotEquals(player1, player3, "Players with different names should not be equal.");

        assertEquals(player1.hashCode(), player2.hashCode(), "Players with the same name should have the same hash code.");
        assertNotEquals(player1.hashCode(), player3.hashCode(), "Players with different names should have different hash codes.");
    }

    /**
     * Test for invalid player names (empty or null).
     */
    @Test
    public void testInvalidPlayerNameThrowsException() {
        String emptyName = "";
        String nullName = null;

        assertThrows(IllegalArgumentException.class, () -> new Player(emptyName), "Empty names should throw an exception.");
        assertThrows(IllegalArgumentException.class, () -> new Player(nullName), "Null names should throw an exception.");
    }
}
