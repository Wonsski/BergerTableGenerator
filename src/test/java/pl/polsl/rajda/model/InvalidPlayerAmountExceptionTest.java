package pl.polsl.rajda.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the InvalidPlayerAmountException class.
 */
public class InvalidPlayerAmountExceptionTest {

    /**
     * Test of exception message storage.
     */
    @Test
    public void testExceptionMessage() {
        String expectedMessage = "Invalid number of players: must be at least 2.";
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException(expectedMessage);

        // Assert that the message is correctly stored and retrievable
        assertEquals(expectedMessage, exception.getMessage(), 
            "Exception message should match the input message.");
    }

    /**
     * Test that the exception is of the correct type.
     */
    @Test
    public void testExceptionInheritance() {
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException("Test message");

        // Assert that it is a subclass of Exception
        assertTrue(exception instanceof Exception, 
            "InvalidPlayerAmountException should inherit from Exception.");
    }

    /**
     * Test with a null message.
     */
    @Test
    public void testNullMessage() {
        InvalidPlayerAmountException exception = new InvalidPlayerAmountException(null);

        // Assert that the message can be null
        assertNull(exception.getMessage(), 
            "Exception message should be null if constructed with null.");
    }
}
