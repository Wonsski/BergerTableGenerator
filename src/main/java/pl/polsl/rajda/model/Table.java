package pl.polsl.rajda.model;

import java.util.List;

/**
 * Class holds all game information and manages rounds. Uses a strategy for
 * table generation based on the provided players.
 * 
 * @version 2.0
 */
public class Table {

    /**
     * List of rounds in the game.
     */
    private List<Round> rounds;
    /**
     * List of players.
     */
    private List<Player> players;
    /**
     * Table generation strategy.
     */
    private TableGenerationStrategy generationStrategy;

    /**
     * Constructor to initialize a Table with a list of players and a generation strategy.
     *
     * @param players the list of players participating in the tournament
     * @param generationStrategy the strategy used to generate rounds
     */
    public Table(List<Player> players, TableGenerationStrategy generationStrategy) {
        this.players = players;
        this.generationStrategy = generationStrategy;
        this.rounds = generationStrategy.generateRounds(players);
    }

    /**
     * Gets the list of rounds in the tournament.
     *
     * @return rounds list
     */
    public List<Round> getRounds() {
        return rounds;
    }
}
