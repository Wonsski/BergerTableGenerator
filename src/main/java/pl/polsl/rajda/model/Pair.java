package pl.polsl.rajda.model;

/**
 * Class represents a pair of players.
 * This class is responsible for storing two Player objects
 * that will compete against each other in a round.
 * 
 * @author Radosław Rajda
 * @version 2.0
 */
public class Pair {
    
    /**
     * First player
     */
    private Player player1;
    /**
     * Second player
     */
    private Player player2;

    /**
     * Constructor to initialize a Pair of players.
     * 
     * @param player1 the first player
     * @param player2 the second player
     */
    public Pair(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    /**
     * Get first player
     * @return First player object
     */
    public Player getPlayer1() {
        return player1;
    }
    
    /**
     * Get second player
     * @return second player object
     */
    public Player getPlayer2() {
        return player2;
    }
    
    /**
     * Convert object to string
     * @return string object representation
     */
    @Override
    public String toString() {
        return "(" + player1.getName() + " vs " + player2.getName() + ")";
    }
    
}
