package pl.polsl.rajda.model;

/**
 * Generic class representing a game result.
 * 
 * @param <T> the type of the result value
 * @version 4.0
 */
public class GameResult<T> {
    private final Pair pair;
    private final T result;

    public GameResult(Pair pair, T result) {
        this.pair = pair;
        this.result = result;
    }

    public Pair getPair() {
        return pair;
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return pair + " - Result: " + result;
    }
}
