package pl.polsl.rajda.model;

import java.util.List;

/**
 * Interface for generating a tournament table.
 * Implements the Strategy pattern for table generation.
 * 
 * @version 2.0
 */
public abstract class TableGenerationStrategy {
    /**
     * Generates rounds for a tournament based on the provided players list.
     * 
     * @param players the list of players participating in the tournament
     * @return a list of rounds generated for the tournament
     */
    public abstract List<Round> generateRounds(List<Player> players);
}
