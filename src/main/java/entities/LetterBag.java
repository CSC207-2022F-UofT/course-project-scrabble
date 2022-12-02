/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.HashMap;
import java.util.Arrays;
import java.io.*;
/**
 * This class is responsible for keeping track of the letter bag used in a game of Scrabble
 * @author Clark
 */
public class LetterBag implements Serializable {
    private final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    private final HashMap<String, Integer> bag = new HashMap<>();

    /**
     * Constructor for LetterBag. Initializes the bag keeping track of the number of letters
     */
    public LetterBag() {
        int[] NUM_LETTERS = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 2, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 2}; // no blanks, extra z and k
        for(int i = 0; i<LETTERS.length; i++)
            bag.put(LETTERS[i], NUM_LETTERS[i]);
    }

    /**
     * Adds tile to bag
     * @param tile The string of the tile needing to be placed into the bag
     */
    public void putTile(String tile) { // adds a tile to the bag
        if(Arrays.asList(LETTERS).contains(tile)) {
            bag.put(tile, bag.get(tile)+1);
        }
    }

    /**
     * Removes tile from bag
     * @param tile The string of the tile needing to be removed from the bag
     */
    public void removeTile(String tile){ // takes out a tile from the bag
        if (Arrays.asList(LETTERS).contains(tile)) {
            if (bag.get(tile) > 0){ // checks if there is a tile that can be removed
                bag.replace(tile, bag.get(tile)-1);
            }
        }
    }

    /**
     * Removes tile from bag
     * @param tile The string of the tile whose number wants to be known
     * @return int number of tile tiles
     */
    public int getNumTile(String tile) {
        if(Arrays.asList(LETTERS).contains(tile)) {
            return bag.get(tile);
        }
        return -1;
    }
    
}
