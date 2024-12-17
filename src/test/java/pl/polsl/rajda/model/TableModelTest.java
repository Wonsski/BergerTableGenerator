package pl.polsl.rajda.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the TableModel class.
 * Verifies the behavior of TableModel instances.
 * 
 * @version 1.0
 */
public class TableModelTest {

    private TableModel tableModel;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        tableModel = new TableModel();
    }

    /**
     * Tests the generateTable method.
     * Ensures that a table is generated and added to the history.
     */
    @Test
    public void testGenerateTable() {
        List<Player> players = List.of(new Player("Player 1"), new Player("Player 2"));
        Table table = tableModel.generateTable(players);

        assertNotNull(table, "Generated table should not be null.");
        assertEquals(1, tableModel.getHistory().size(), "History should contain one table.");
        assertEquals(table, tableModel.getHistory().get(0), "Generated table should be in the history.");
    }

    /**
     * Tests the getHistory method.
     * Ensures that the history is returned correctly.
     */
    @Test
    public void testGetHistory() {
        List<Player> players1 = List.of(new Player("Player 1"), new Player("Player 2"));
        List<Player> players2 = List.of(new Player("Player 3"), new Player("Player 4"));

        tableModel.generateTable(players1);
        tableModel.generateTable(players2);

        List<Table> history = tableModel.getHistory();

        assertNotNull(history, "History should not be null.");
        assertEquals(2, history.size(), "History should contain two tables.");
    }
}