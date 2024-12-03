package pl.polsl.rajda.model;

/**
 * Record represents a player in the game.
 * Each player has a name that identifies them.
 * 
 * @version 3.1
 */
public record Player(String name) {

    /**
     * Constructor for Player.
     * Ensures the name is not null or empty.
     * 
     * @param name the name of the player
     * @throws IllegalArgumentException if the name is null or empty
     */
    public Player {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
