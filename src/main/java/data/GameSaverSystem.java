package data;

import UsecaseInterfaces.GameSave;
import entities.*;

import java.io.*;

public class GameSaverSystem implements GameSave {
    // final static File filename = new File("src/main/java/data/data.ser");
    @Override
    public void saveGame(Game game) { // TODO add turn to parameters once type is known
        // Method to save objects to data.ser file

        // Serialization
        try {
            // Saving objects in a file
            FileOutputStream file = new FileOutputStream(filename); // output stream to write data to file
            ObjectOutputStream out = new ObjectOutputStream(file); // used to write objects to file

            // Method for serialization of objects
            out.writeObject(game); // write objects to output stream

            out.close(); // closes stream
            file.close();

            System.out.println("Game state saved.");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }

    }
}
