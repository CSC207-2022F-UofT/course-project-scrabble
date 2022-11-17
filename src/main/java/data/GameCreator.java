package data;

import entities.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameCreator implements GameLoad{
    public static Object[] newGame(String name1, String name2){
        // method to initialize all variables needed to play a new game and returned as an array of objects
        GameBoard board = new GameBoard();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        LetterBag letterBag = new LetterBag();
        return new Object[]{board, player1 ,player2, letterBag};
    }
    @Override
    public Object[] loadGame(){
        // Method to load objects required to play game by reading data.ser to load objects
        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename); // Creates file to read stream of bytes

            ObjectInputStream in = new ObjectInputStream(file);
            // Creates object that converts stream of bytes to this object

            // Method for deserialization of object
            GameBoard gameboard = (GameBoard) in.readObject(); // Read GameBoard
            Player p1 = (Player) in.readObject(); // Read Player 1
            Player p2 = (Player) in.readObject(); // Read Player 2
            LetterBag lb = (LetterBag) in.readObject(); // Read LetterBag
            // TODO add turn to saved objects once type is known

            in.close();
            file.close();
            // Close the files/object and stream

            return new Object[]{gameboard, p1, p2, lb}; // Returns an array of the GameBoard, Player1, Player2, LetterBag
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            return null;
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            return null;
        }

    }
}
