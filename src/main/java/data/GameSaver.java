package data;

import entities.*;

import java.io.*;

public class GameSaver {
    final static File filename = new File("src/main/java/data/data.ser");
    public static void saveGame(GameBoard board, Player p1, Player p2, LetterBag bag) { // TODO add turn to parameters once type is known
        // Method to save objects to data.ser file

        // Serialization
        try {
            // Saving objects in a file
            FileOutputStream file = new FileOutputStream(filename); // output stream to write data to file
            ObjectOutputStream out = new ObjectOutputStream(file); // used to write objects to file

            // Method for serialization of objects
            out.writeObject(board); // write objects to output stream
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(bag);

            out.close(); // closes stream
            file.close();

            System.out.println("Game state saved.");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }

    }
}
