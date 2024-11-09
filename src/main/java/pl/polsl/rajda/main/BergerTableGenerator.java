package pl.polsl.rajda.main;

import pl.polsl.rajda.controller.Controller;
import pl.polsl.rajda.view.ConsoleUserInterface;

/**
 * Application generates Berger table for a tournament.
 * The program can be run with or without command line arguments
 * to specify the number of players.
 * 
 * 
 * @author Radosław Rajda
 * @version 2.0
 */
public class BergerTableGenerator {

    /**
     * Main method to run the application.
     * 
     *  * Command line parameters:
     * - If no parameters are provided, the program will prompt the user
     *   to enter the number of players and optionally their names.
     * - If a parameter is provided, it will be treated as the number of players.
     * 
     * @param args command line parameters used in the application
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        ConsoleUserInterface view = new ConsoleUserInterface();

        if (args.length == 0) {
            controller.start();
        } else {
            try {
                int playersAmount = Integer.parseInt(args[0]);
                controller.startWithPlayersAmount(playersAmount);
            } catch (NumberFormatException e) {
                view.printError("Invalid number format. Please enter a valid integer.");
            } catch (Exception e) {
                view.printError("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}