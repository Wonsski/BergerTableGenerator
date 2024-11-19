package pl.polsl.rajda.controller;

import pl.polsl.rajda.view.ConsoleUserInterface;
import pl.polsl.rajda.model.InvalidPlayerAmountException;
import pl.polsl.rajda.model.Player;

import java.util.ArrayList;
import java.util.List;
import pl.polsl.rajda.model.BergerTableGenerationStrategy;
import pl.polsl.rajda.model.Table;
import pl.polsl.rajda.model.TableGenerationStrategy;

/**
 * Class supports user interaction with the application. It handles user input
 * and manages the game process.
 *
 * @author Radosław Rajda 
 * @version 3.0
 */
public class Controller {

    /**
     * Console User Interface initialization
     */
    private ConsoleUserInterface view = new ConsoleUserInterface();

    /**
     * Starts the application by prompting the user for input.
     */
    public void start() {
        try {
            int playersAmount = view.getUserAmount();
            if (playersAmount < 2) {
                throw new InvalidPlayerAmountException("The number of players must be greater than 1.");
            }
            List<Player> players = createPlayers(playersAmount);
            processGame(players);

        } catch (InvalidPlayerAmountException e) {
            view.printError(e.getMessage());
        }
    }

    /**
     * Starts the application with a predefined number of players.
     *
     * @param playersAmount the number of players to create
     */
    public void startWithPlayersAmount(int playersAmount) {
        try {
            List<Player> players = createPlayers(playersAmount);
            processGame(players);
        } catch (InvalidPlayerAmountException e) {
            view.printError(e.getMessage());
        }
    }

    /**
     * Processes the game logic using the provided list of players.
     *
     * @param players the list of players participating in the game
     * @throws InvalidPlayerAmountException if the number of players is invalid
     */
    private void processGame(List<Player> players) throws InvalidPlayerAmountException {
        if (players.size() < 2) {
            throw new InvalidPlayerAmountException("The number of players must be greater than 1.");
        }
        TableGenerationStrategy strategy = new BergerTableGenerationStrategy();
        Table table = new Table(players, strategy);
        view.printTable(table);
        view.printGamesAmount((players.size() * (players.size() - 1)) / 2);
    }

    /**
     * Creates a list of players based on user input or default names.
     *
     * @param playersAmount the number of players to create
     * @return a list of Player objects
     */
    public List<Player> createPlayers(int playersAmount) {
        List<Player> players = new ArrayList<>();
        boolean customNames = view.askForCustomNames();

        for (int i = 1; i <= playersAmount; i++) {
            if (customNames) {
                String name = view.getPlayerName(i);
                players.add(new Player(name));
            } else {
                players.add(new Player("Player " + i));
            }
        }
        return players;
    }
}
