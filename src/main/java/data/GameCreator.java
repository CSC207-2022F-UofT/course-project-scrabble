package data;

import UsecaseInterfaces.CreateGame;
import UsecaseInterfaces.GameLoad;
import entities.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * This class is responsible for creating a new Game instance or loading a previous Game instance from file.
 * @author Jazli
 */

public class GameCreator implements GameLoad, CreateGame {

    public GameCreator(){

    }
	
    /**
     * This method is responsbile for creating a new Game instance that loads in all strings from an array "names"
     * which hold all the names of the future players to be added.
     * @param names This is the only parameter that is an array of strings holding names
     * @return Game This returns an instance of Game holding Players with each name from array names
     */
    public Game createNewGame(String[] names){


        // method to initialize all variables needed to play a new game and returned as an array of objects

        Game game = new Game();                 // initialize a new Game object
        for (String name: names) {              // loop through the string of names
            game.addPlayer(new Player(name));   // add each name as a Player to the game.
        }

        return game;                            // returns the newly initialized game
    }

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
            Game game = (Game) in.readObject(); // Read GameBoard

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
