package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConsoleSimulator {

    public static String[][] initializeGameBoard(int rows, int columns){
        /** Returns an initial grid of the state
         * @return
         * @param columns
         * @param rows
         */

        String[][] outputDisplay = new String[rows][columns];
        // ArrayList<ArrayList<String>> outputDisplay = new ArrayList<ArrayList<String>>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                outputDisplay[i][j] = "-";
            }
        }
        return(outputDisplay);
    }

    public static void printGameBoard(String[][] gameBoard){
        /**
         * @param gameBoard state to be printed
         */

        // ArrayList<ArrayList<String>> outputDisplay = new ArrayList<ArrayList<String>>();
        for(int i=0; i<gameBoard.length; i++){
            String rowPrint = "";
            for(int j=0; j<gameBoard[i].length; j++){
                rowPrint += gameBoard[i][j] + " ";
            }
            System.out.println(rowPrint);
        }
    }

    public static void main(String[] args)
        throws IOException
    {
        System.out.println("Player Number 1 Name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();

        System.out.println("Player Number 2 Name: ");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String name2 = reader2.readLine();

        System.out.println("Game Between: " + name1 + " & " + name2);

        String[][] newGame = initializeGameBoard(15,15);
        printGameBoard(newGame);
    }
}
