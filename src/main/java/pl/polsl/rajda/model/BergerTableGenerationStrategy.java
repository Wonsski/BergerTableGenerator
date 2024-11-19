package pl.polsl.rajda.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy for generating a Berger tournament table.
 * This class generates rounds based on the Berger algorithm.
 * 
 * @version 3.0
 */
public class BergerTableGenerationStrategy extends TableGenerationStrategy {

    @Override
    public List<Round> generateRounds(List<Player> players) {
        int playersAmount = players.size();
        List<Round> rounds = new ArrayList<>();

        if (playersAmount % 2 != 0) {
            playersAmount++;
            players.add(new Player("---")); // Add a placeholder player
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
        
        return rounds;
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
}
