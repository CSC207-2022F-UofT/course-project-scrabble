package data;

import entities.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GameCreator implements GameLoad, CreateGame{
    public Game newGame(String name1, String name2){
        // method to initialize all variables needed to play a new game and returned as an array of objects

        Game game = new Game();
        Player p1 = new Player(name1);
        Player p2 = new Player(name2);
        game.addPlayer(p1);
        game.addPlayer(p2);

        return game;
    }
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
