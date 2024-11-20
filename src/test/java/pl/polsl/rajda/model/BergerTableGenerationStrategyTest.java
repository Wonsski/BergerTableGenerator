/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.rajda.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.engine.support.discovery.SelectorResolver.Match;

/**
 *
 * @author radoslawrajda
 */
public class BergerTableGenerationStrategyTest {
    
    public BergerTableGenerationStrategyTest() {
    }
    
    /**
     * Test of generateRounds method, of class BergerTableGenerationStrategy.
     */
    @Test
    public void testGenerateRounds() {

        List<Player> players = new ArrayList<>();
        players.add(new Player("A"));
        players.add(new Player("B"));
        players.add(new Player("C"));
        players.add(new Player("D"));

        BergerTableGenerationStrategy instance = new BergerTableGenerationStrategy();
        List<Round> result = instance.generateRounds(players);

        assertNotNull(result, "List shouldnt be null");
        assertEquals(3, result.size(), "Should be generated 3 rounds");

    }
    
}
