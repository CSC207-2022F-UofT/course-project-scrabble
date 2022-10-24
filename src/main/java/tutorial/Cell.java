/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.Scrabble.entities;

/**
 *
 * @author Clark
 */
public class Cell {
    private String value;
    private int score;
    private int multiplier; 
    
    public Cell() {
        value = "";
        score = 0;
        multiplier = 0;
    }
    
    public Cell(String val, int mult) {
        value = val;
        score = 0;
        multiplier = mult;
    }
    
    public void setValue(String value) {
        this.value = value;
   
    }
    
    public String getValue() {
        return this.value;
        
    }
    
    
    
}
