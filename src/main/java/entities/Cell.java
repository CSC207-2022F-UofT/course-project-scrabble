/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 * This class represents the Cell entity and is responsible for handling Cell actions, where each holds value,
 * score and multiplier.
 * @author Clark & Jazli
 */
public class Cell implements Serializable {
    private String value;
    private int score;
    private int multiplier;

    /**
     * This method is responsible for being the constructor of the Cell class with no parameters
     */
    public Cell() {

        value = "";
        score = 0;
        multiplier = 0;
    }
    /**
     * This method is responsible for being the constructor of the Cell class passed with a value and multiplier
     * @param val This is a string that represents the value of the cell
     * @param mult This is an integer for being the multiplier of the cell score
     */

    public Cell(String val, int mult) {
        value = val;
        score = 0;
        multiplier = mult;
    }

    /**
     * This method is responsible for being the constructor of the Cell class passed with a value and multiplier
     * @param val This is a string that represents the value of the cell
     * @param score This is an integer that represents the score of the cell.
     * @param mult This is an integer for being the multiplier of the cell score
     */

    public Cell(String val, int score, int mult){
        value = val;
        this.score = score;
        multiplier = mult;
    }

    /**
     * This method is responsible reassigning the value of a cell
     * @param value This is a String that will set the value of the cell to be this.
     */
    public void setValue(String value) {
        this.value = value;
   
    }
    /**
     * This method is responsible reassigning the score of a cell
     * @param score This is an integer that will set the score of the cell to be this.
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * This method is responsible reassigning the multiplier of a cell
     * @param multiplier This is an integer that will set the multiplier of the cell to be this.
     */
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    /**
     * This method is responsible returning the multiplier of a cell
     * @return Return an integer that represents the multiplier of this cell
     */
    public int getMultiplier() {
        return this.multiplier;
    }
    /**
     * This method is responsible returning the score of a cell
     * @return Return an integer that represents the score of this cell
     */
    public int getScore() {
        return this.score;
    }
    /**
     * This method is responsible returning the value of a cell
     * @return Return an integer that represents the value of this cell
     */
    public String getValue() {
        return this.value;
    }
}
