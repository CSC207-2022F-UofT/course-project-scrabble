/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.io.*;


/**
 *
 * @author Clark
 */

public class Player implements Serializable {
    private int score;
    private String name;
    private Cell[] hand;

    /**
     * This method is the constructor for the player class which sets up a player to default values
     * @param name the name of the Player
     */
    public Player(String name) {
        this.score = 0;
        this.name = name;
        this.hand = new Cell[7];
    }
    
    public Player(String loaded_name, int loaded_score, Cell[] loaded_hand) {
        this.name = loaded_name;
        this.score = loaded_score;
        this.hand = loaded_hand;
    }



    public void setName(String new_name) {
        this.name = new_name;
    }
    
    public String getName() {
        return this.name;
    }

    /**
     * This method sets the score of the player to new_score
     * @param new_score The score player's score will be changed to
     */
    public void setScore(int new_score) {
        this.score = new_score;
    }

    /**
     * This method returns the player's score
     * @return player's score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * This method sets player's hand to new_hand where new_hand is of size 7
     * @param new_hand the array of cells the player's hand will be changed to. Must be of size 7
     */
    public void setHand(Cell[] new_hand) {
        this.hand = new_hand;
        
    }

    /**
     * This method is returns the player's hand
     * @return player's hand
     */
    public Cell[] getHand() {
        return this.hand;
    }
}
