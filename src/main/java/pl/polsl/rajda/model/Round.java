package pl.polsl.rajda.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class represents a single round of matches.
 * This class holds a list of pairs of players that will compete
 * in that round.
 * 
 * @version 2.0
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Round {
    
    /**
     * List of pairs in the round
     */
    private List<Pair> pairs;

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
