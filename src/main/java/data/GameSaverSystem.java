package data;

import use_case_interfaces.GameSave;
import entities.*;

import java.io.*;

/**
 * This class is responsible for saving the current Game entity present in the game to a file named "data.ser".
 * @author Jazli & Umair
 */

public class GameSaverSystem implements GameSave {
    /**
     * This function is responsible for saving the Game entity to a file named "data.ser" which acts as the database.
     * @param game This is the Game entity that will be saved to the "data.ser" file.
     */
    @Override
    public void saveGame(Game game) {
        // Method to save objects to data.ser file

        // Serialization
        try {
            // Saving objects in a file
            FileOutputStream file = new FileOutputStream(filename); // output stream to write data to file
            ObjectOutputStream out = new ObjectOutputStream(file); // used to write objects to file

            // Method for serialization of objects
            out.writeObject(game); // write game object to output stream

            out.close(); // closes stream
            file.close();

            System.out.println("Game state saved.");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }
}
