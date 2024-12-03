package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the InvalidPlayerAmountException class.
 * Ensures correct exception behavior for invalid player counts.
 * 
 * @version 4.0
 * @author Radosław Rajda
 */
public class InvalidPlayerAmountExceptionTest {

    /**
     * Test that the exception message is correctly passed and retrieved.
     */
    @Test
    public void testExceptionMessage() {
        String expectedMessage = "Invalid number of players: must be at least 2.";
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the input message.");
    }

    /**
     * Test that InvalidPlayerAmountException is a subclass of Exception.
     */
    @Test
    public void testExceptionInheritance() {
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException("Test message");

        assertTrue(exception instanceof Exception, "InvalidPlayerAmountException should inherit from Exception.");
    }

    /**
     * Test for passing a null message.
     */
    @Test
    public void testNullMessage() {
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException(null);

        assertNull(exception.getMessage(), "Message should be null if the exception is created with a null message.");
    }
}
