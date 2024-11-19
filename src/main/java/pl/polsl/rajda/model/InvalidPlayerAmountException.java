package pl.polsl.rajda.model;

/**
 * Custom exception to handle invalid player amount errors.
 * This exception is thrown when the number of players is less than 2.
 * 
 * @version 3.0
 */
public class InvalidPlayerAmountException extends Exception {

    public InvalidPlayerAmountException(String message) {
        super(message);
    }
}
