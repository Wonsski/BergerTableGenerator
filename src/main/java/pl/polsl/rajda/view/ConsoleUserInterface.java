package pl.polsl.rajda.view;

import java.util.Scanner;
import pl.polsl.rajda.controller.Controller;

/**
 * Class reads input data from the console.
 * It interacts with the user to retrieve game parameters and display results.
 * 
 * Author: Radosław Rajda
 * Version: 1.0
 */
public class ConsoleUserInterface {
    
    /**
     * Scanner initialization
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to input the number of players.
     * 
     * @return the number of players entered by the user
     */
    public int getUserAmount() {
        System.out.println("Enter the number of players:");
        return scanner.nextInt();
    }

    /**
     * Prints the total number of games to be played.
     * 
     * @param gamesAmount the number of games to display
     */
    public void printGamesAmount(int gamesAmount) {
        System.out.println("A total of " + gamesAmount + " games will be played.");
    }

    /**
     * Prints an error message.
     * 
     * @param errorMessage the message to display
     */
    public void printError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    /**
     * Asks the user if they want to input custom player names.
     * 
     * @return true if custom names are desired, false otherwise
     */
    public boolean askForCustomNames() {
        System.out.println("Do you want to enter custom player names? (yes/no):");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    /**
     * Prompts the user to enter the name for a player.
     * 
     * @param playerNumber the player number for which to input the name
     * @return the player's name entered by the user
     */
    public String getPlayerName(int playerNumber) {
        System.out.println("Enter name for player " + playerNumber + ":");
        return scanner.next();
    }
}
