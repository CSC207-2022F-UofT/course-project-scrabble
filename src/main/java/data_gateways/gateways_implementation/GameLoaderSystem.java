package data_gateways.gateways_implementation;

import entities.*;

import java.io.*;
import data.gateway_interfaces.GameLoadUsecase;

/**
 * This class is responsible for loading an instance of a Game from a file that stored the object called "data.ser" file.
 * @author Jazli & Umair
 */
public class GameLoaderSystem implements GameLoadUsecase {
    /**
     * This method is responsible for loading a Game object from the "data.ser" file and returning the Game instance
     * @return Game This is the Game instance/object that is taken from "data.ser" file
     */
    @Override
    public Game loadGame(){
        // Method to load objects required to play game by reading data.ser to load objects
        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename); // Creates file to read stream of bytes

            ObjectInputStream in = new ObjectInputStream(file);
            // Creates object that converts stream of bytes to this object

            // Method for deserialization of object
            Game game = (Game) in.readObject(); // Read Game

            in.close();
            file.close();
            // Close the files/object and stream

            return game; // Returns the loaded Game object
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
