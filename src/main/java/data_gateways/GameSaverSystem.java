package data_gateways;

import entities.*;

import java.io.*;
import usecases.usecase_interfaces.GameSaveUsecase;

/**
 * This class is responsible for saving the current Game entity present in the game to a file named "data.ser".
 * @author Jazli & Umair
 */

public class GameSaverSystem implements GameSaveUsecase {
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
            File saveFile = new File(filename);
            FileOutputStream file = new FileOutputStream(saveFile); // output stream to write data to file
            ObjectOutputStream out = new ObjectOutputStream(file); // used to write objects to file

            // Method for serialization of objects
            out.writeObject(game); // write game object to output stream

            out.close(); // closes stream
            
            
            assert saveFile.exists();
                    
            
            file.close();
            
            System.out.println("Game state saved.");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }
}
