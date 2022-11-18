package data;

import UsecaseInterfaces.GameLoad;
import entities.*;

import java.io.*;

public class GameLoaderSystem implements GameLoad{
//    final static File filename = new File("src/main/java/data/data.ser");
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

            return game;
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
