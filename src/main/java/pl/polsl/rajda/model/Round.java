package pl.polsl.rajda.model;

import java.util.List;

/**
 * Class represents a single round of matches.
 * This class holds a list of pairs of players that will compete
 * in that round.
 * 
 * @author Radosław Rajda
 * @version 2.0
 */
public class Round {
    
    /**
     * List of pairs in the round
     */
    private List<Pair> pairs;

    /**
     * Constructor to initialize a Round with a list of player pairs.
     * 
     * @param pairs the list of pairs competing in this round
     */
    public Round(List<Pair> pairs) {
        this.pairs = pairs;
    }
    
    /**
     * Get list of pairs in the round
     * @return Pair objects list
     */
    public List<Pair> getPairs() {
        return pairs;
    }
    
    /**
     * Convert object to string
     * @return string object representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : pairs) {
            sb.append(pair.toString()).append(" ");
        }
        return sb.toString();
    }
    
}
