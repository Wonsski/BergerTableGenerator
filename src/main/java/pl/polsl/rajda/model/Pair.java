package pl.polsl.rajda.model;

/**
 * Record represents a pair of players.
 * This class is responsible for storing two Player objects
 * that will compete against each other in a round.
 * 
 * @version 2.0
 */
public record Pair(Player player1, Player player2) {

    /**
     * Convert object to string
     * @return string object representation
     */
    @Override
    public String toString() {
        return "(" + player1.name() + " vs " + player2.name() + ")";
    }
}
