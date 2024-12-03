package pl.polsl.rajda.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the GameResult class.
 * 
 * This class contains unit tests for the GameResult class, which models a 
 * game result with a pair of players and the result value. Tests cover 
 * the constructor, getters, toString method, and equality checks.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class GameResultTest {

    private Player player1;
    private Player player2;
    private Pair pair;

    /**
     * Set up the necessary objects for the tests.
     * 
     * This method is called before each test is run. It initializes two players 
     * and a Pair object that represents the pairing of those players.
     */
    @BeforeEach
    public void setUp() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        pair = new Pair(player1, player2);
    }

    /**
     * Test constructor and getter methods of GameResult.
     */
    @Test
    public void testConstructorAndGetters() {
        GameResult<String> gameResult = new GameResult<>(pair, "Win");
        assertEquals(pair, gameResult.getPair());
        assertEquals("Win", gameResult.getResult());
    }

    /**
     * Test constructor with Integer result type.
     */
    @Test
    public void testConstructorWithIntegerResult() {
        GameResult<Integer> gameResult = new GameResult<>(pair, 1);
        assertEquals(pair, gameResult.getPair());
        assertEquals(1, gameResult.getResult());
    }

    /**
     * Test toString method for GameResult with String result.
     */
    @Test
    public void testToString() {
        GameResult<String> gameResult = new GameResult<>(pair, "Win");
        assertEquals("(Player 1 vs Player 2) - Result: Win", gameResult.toString());
    }

    /**
     * Test toString method for GameResult with Integer result.
     */
    @Test
    public void testToStringWithIntegerResult() {
        GameResult<Integer> gameResult = new GameResult<>(pair, 1);
        assertEquals("(Player 1 vs Player 2) - Result: 1", gameResult.toString());
    }

    /**
     * Test equality check between different GameResult objects.
     */
    @Test
    public void testNotEquals() {
        GameResult<String> gameResult1 = new GameResult<>(pair, "Win");
        GameResult<String> gameResult2 = new GameResult<>(pair, "Lose");
        assertNotEquals(gameResult1, gameResult2);
    }
}
