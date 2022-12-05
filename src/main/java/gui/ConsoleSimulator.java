package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The ConsoleSimulator implements an application that displays the onto the console a 15x15 representation of the game.
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

// class to simulate game in the console.
public class ConsoleSimulator {
    final private String[][] gameBoard; // create the gameBoard
    int DEFAULT_SIZE = 15;

    // constructor to create the game based on the default sizes of the board
    public ConsoleSimulator()
            throws IOException {
        this.gameBoard = initializeGameBoard(DEFAULT_SIZE, DEFAULT_SIZE); // initialize board to default size

        System.out.println("Player Number 1 Name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();

        System.out.println("Player Number 2 Name: ");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String name2 = reader2.readLine();

        System.out.println("Game Between: " + name1 + " & " + name2);
    }

    /**
     * @return Returns an initial grid of the game
     * @param columns initialize the game based on the number of columns
     * @param rows initialize the game based on the number of rows
     */
    private static String[][] initializeGameBoard(int rows, int columns) {


        String[][] outputDisplay = new String[rows][columns];
        // ArrayList<ArrayList<String>> outputDisplay = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                outputDisplay[i][j] = "-";
            }
        }
        return (outputDisplay);
    }

    /** Prints the game board into the console
     * @param gameBoard state to be printed
     */
    public static void printGameBoard(String[][] gameBoard) {
        // iterate through the length of the board
        for (String[] strings : gameBoard) {
            StringBuilder rowPrint = new StringBuilder();
            // iterate through each row
            for (String string : strings) {
                rowPrint.append(string).append(" ");
            }
            System.out.println(rowPrint);
        }
        System.out.println("\n");
    }

    /** Plays a move and updates the gameBoard
     * @param letter is the letter we want to add
     * @param coordinate is the coordinate of the x and y location of the new placed cell
     *
     */
    public void playMove(String letter, int[] coordinate) {

        this.gameBoard[coordinate[0]][coordinate[1]] = letter;
    }

    public static void main(String[] args) // for testing the console app
            throws IOException {
        ConsoleSimulator game = new ConsoleSimulator();
        printGameBoard(game.gameBoard);
        int[] coord = {2, 2};
        game.playMove("A", coord);
        printGameBoard(game.gameBoard);
    }
}
