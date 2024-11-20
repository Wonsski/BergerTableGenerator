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

/**
 *
 * @author radoslawrajda
 */
public class TableGenerationStrategyTest {
    
    public TableGenerationStrategyTest() {
    }
   

    /**
     * Test of generateRounds method, of class TableGenerationStrategy.
     */
    @Test
    public void testGenerateRounds() {

        List<Player> players = new ArrayList<>();
        players.add(new Player("A"));
        players.add(new Player("B"));
        players.add(new Player("C"));
        players.add(new Player("D"));

        TableGenerationStrategyImpl instance = new TableGenerationStrategyImpl();
        List<Round> result = instance.generateRounds(players);

        assertNotNull(result, "List shouldnt be null");
        assertEquals(3, result.size(), "Should be generated 3 rounds");

    }

    public class TableGenerationStrategyImpl extends TableGenerationStrategy {

        @Override
        public List<Round> generateRounds(List<Player> players) {
           
            List<Round> rounds = new ArrayList<>();
            
            Player player1 = new Player("A");
            Player player2 = new Player("B");
            Player player3 = new Player("C");
            Player player4 = new Player("D");

            List<Pair> matchesRound1 = new ArrayList<>();
            matchesRound1.add(new Pair(player1, player2));
            matchesRound1.add(new Pair(player3, player4));
            Round round1 = new Round(matchesRound1);

            List<Pair> matchesRound2 = new ArrayList<>();
            matchesRound2.add(new Pair(player1, player3));
            matchesRound2.add(new Pair(player2, player4));
            Round round2 = new Round(matchesRound2);

            List<Pair> matchesRound3 = new ArrayList<>();
            matchesRound3.add(new Pair(player1, player4));
            matchesRound3.add(new Pair(player2, player3));
            Round round3 = new Round(matchesRound3);

            rounds.add(round1);
            rounds.add(round2);
            rounds.add(round3);

            return rounds;
        }
    }
    
}
