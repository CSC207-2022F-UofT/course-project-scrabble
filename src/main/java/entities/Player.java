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
    private String[] hand;
    
    public Player(String name) {
        this.score = 0;
        this.name = name;
        this.hand = new String[7];
    }
    
    public Player(String loaded_name, int loaded_score, String[] loaded_hand) {
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
    
    public void setScore(int new_score) {
        this.score = new_score;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void setHand(String[] new_hand) {
        this.hand = new_hand;
        
    }
    
    public String[] getHand() {
        return this.hand;
    }
}
