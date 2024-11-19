package pl.polsl.rajda.model;

/**
 * Record represents a player in the game.
 * Each player has a name that identifies them.
 * 
 * @version 3.0
 */
public record Player(String name) {

    @Override
    public String toString() {
        return name;
    }
}
