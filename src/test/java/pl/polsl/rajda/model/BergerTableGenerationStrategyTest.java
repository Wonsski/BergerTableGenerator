package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Unit tests for the BergerTableGenerationStrategy class.
 * Tests the generation of rounds based on the Berger algorithm.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class BergerTableGenerationStrategyTest {

    /**
     * Test of generateRounds method for valid player counts.
     * Ensures that rounds are generated correctly for valid player lists.
     */
    @ParameterizedTest
    @MethodSource("provideValidPlayerCounts")
    public void testGenerateRoundsWithValidPlayers(List<Player> players, int expectedRoundCount) {
        BergerTableGenerationStrategy instance = new BergerTableGenerationStrategy();
        List<Round> result = instance.generateRounds(new ArrayList<>(players));

        assertNotNull(result, "Generated rounds list should not be null.");
        assertEquals(expectedRoundCount, result.size(), "Incorrect number of rounds generated.");
    }

    /**
     * Parameterized source for valid player counts.
     * Provides lists of players and expected round counts.
     */
    private static Stream<Arguments> provideValidPlayerCounts() {
        return Stream.of(
            Arguments.of(List.of(new Player("A"), new Player("B")), 1),
            Arguments.of(List.of(new Player("A"), new Player("B"), new Player("C"), new Player("D")), 3),
            Arguments.of(List.of(new Player("A"), new Player("B"), new Player("C"), new Player("D"), new Player("E")), 5)
        );
    }

    /**
     * Test of generateRounds method for an odd number of players.
     * Ensures that a placeholder player is added and rounds are generated correctly.
     */
    @Test
    public void testGenerateRoundsWithOddNumberOfPlayers() {
        List<Player> players = new ArrayList<>(List.of(new Player("A"), new Player("B"), new Player("C")));

        BergerTableGenerationStrategy instance = new BergerTableGenerationStrategy();
        List<Round> result = instance.generateRounds(players);

        assertEquals(4, players.size(), "Odd number of players should result in a placeholder being added.");
        assertEquals(3, result.size(), "There should be 3 rounds generated for 4 players.");
    }

    /**
     * Test of generateRounds method with an empty player list.
     * Expected behavior is that no rounds are generated.
     */
    @Test
    public void testGenerateRoundsWithEmptyPlayers() {
        List<Player> players = new ArrayList<>();

        BergerTableGenerationStrategy instance = new BergerTableGenerationStrategy();
        List<Round> result = instance.generateRounds(players);

        assertTrue(result.isEmpty(), "No rounds should be generated with an empty player list.");
    }

    /**
     * Test of generateRounds method with null player list.
     * Ensures that an exception is thrown for null input.
     */
    @Test
    public void testGenerateRoundsWithNullPlayers() {
        BergerTableGenerationStrategy instance = new BergerTableGenerationStrategy();
        assertThrows(NullPointerException.class, () -> instance.generateRounds(null),
                "Null player list should throw a NullPointerException.");
    }
}
