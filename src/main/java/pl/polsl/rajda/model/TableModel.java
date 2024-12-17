package pl.polsl.rajda.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class to handle Berger table generation and store history.
 * 
 * @version 1.0
 */
public class TableModel {
    private List<Table> history = new ArrayList<>();

    /**
     * Generates a Berger table and stores it in history.
     * 
     * @param players List of players
     * @return Generated table
     */
    public Table generateTable(List<Player> players) {
        Table table = new Table(players, new BergerTableGenerationStrategy());
        history.add(table);
        return table;
    }

    /**
     * Returns the history of generated tables.
     * 
     * @return List of tables
     */
    public List<Table> getHistory() {
        return history;
    }
}
