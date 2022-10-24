/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.Scrabble.entities;
import java.util.HashMap;
import java.util.Arrays;
/**
 *
 * @author Clark
 */
public class LetterBag {
    private final int[] NUM_LETTERS = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 2, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 2};
    private final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    private HashMap<String, Integer>bag = new HashMap<>();
    
    public LetterBag() {
        for(int i = 0; i<LETTERS.length; i++)
            bag.put(LETTERS[i], NUM_LETTERS[i]);
    }
    
    
    public void putTile(String tile) {
        if(Arrays.asList(LETTERS).contains(tile)) {
            bag.put(tile, bag.get(tile)+1);
        }
    }
    
    public int getNumTile(String tile) {
        if(Arrays.asList(LETTERS).contains(tile)) {
            return bag.get(tile);
        }
        return -1;
    }
    
    public String getRandomTile() { // not finished
        return "";
    }
    
}
