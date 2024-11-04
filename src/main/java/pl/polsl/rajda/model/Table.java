package pl.polsl.rajda.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class holds all game information and manages rounds. It generates a Berger
 * table based on the provided players.
 *
 * @author Radosław Rajda
 * @version 1.0
 */
public class Table extends GameElement {

    /**
     * List of rounds in the game
     */
    private List<Round> rounds;
    /**
     * List of players
     */
    private List<Player> players;

    /**
     * Constructor to initialize a Table with a list of players.
     *
     * @param players the list of players participating in the tournament
     */
    public Table(List<Player> players) {
        this.players = players;
        rounds = new ArrayList<>();
        generateBergerTable();
    }

    /**
     * Generates the Berger table using the player list.
     */
    private void generateBergerTable() {
        int playersAmount = players.size();

        if (playersAmount % 2 != 0) {
            playersAmount++;
            players.add(new Player("---")); // Add a null player
        }

        List<Player> playerList = new ArrayList<>(players);
        for (int round = 0; round < playersAmount - 1; round++) {
            List<Pair> currentRound = new ArrayList<>();
            for (int i = 0; i < playersAmount / 2; i++) {
                Player player1 = playerList.get(i);
                Player player2 = playerList.get(playersAmount - 1 - i);
                if (player1 != null && player2 != null) {
                    currentRound.add(new Pair(player1, player2));
                }
            }
            rounds.add(new Round(currentRound));
            rotatePlayers(playerList);
        }
    }

    /**
     * Rotates players in the list to prepare for the next round. The last
     * player is moved to the second position.
     *
     * @param playerList the list of players to rotate
     */
    private void rotatePlayers(List<Player> playerList) {
        Player lastPlayer = playerList.remove(playerList.size() - 1);
        playerList.add(1, lastPlayer);
    }
    
    /**
     * Get list of rounds
     * @return Rounds list
     */
    public List<Round> getRounds() {
        return rounds;
    }

    /**
     * Displays details of each round and its pairs.
     */
    @Override
    public void displayElementDetails() {
        for (int i = 0; i < rounds.size(); i++) {
            System.out.println("Round " + (i + 1) + ": " + rounds.get(i));
        }
    }
}
