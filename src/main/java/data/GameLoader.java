package data;

import entities.*;

import java.io.*;

public class GameLoader {
    final static File filename = new File("src/main/java/data/data.ser");
    public static Object[] loadGame(){
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
