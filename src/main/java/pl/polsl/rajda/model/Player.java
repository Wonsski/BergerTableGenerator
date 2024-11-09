package pl.polsl.rajda.model;

/**
 * Class represents a player in the game.
 * Each player has a name that identifies them.
 * 
 * @author Radosław Rajda
 * @version 2.0
 */
public class Player {
    
    /**
     * Player name
     */
    private String name;

    /**
     * Constructor to initialize a Player with a name.
     * 
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Get player name
     * @return player name
     */
    public String getName() {
        return name;
    }
    
}
