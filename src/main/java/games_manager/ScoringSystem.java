package games_manager;
import entities.*;

import java.util.ArrayList;
import java.util.List;

public class ScoringSystem implements ScoreCalculator{

    @Override
    public int score(GameBoard board, List<List<Integer>> word) {
        /* returns the score of the move given the new word's coordinates and current board state
        * word formatted as: [[2, 3], [4, 1], ...]
        */
        int points_so_far = 0; // variable to store points of word
        for (List<Integer> coordinates: word){ // loops over coordinates
            Cell letter = board.getBoardCell(coordinates.get(0), coordinates.get(1)); // saves the cell representing the letter in letter
            points_so_far += letter.getScore()*letter.getMultiplier(); // multiplies the score of the cell by the multiplier
        }
        if (word.size() == 7) { // If all words in hand are used then add 50 points to turn
           points_so_far += 50;
        }
        return points_so_far;
    }

    @Override
    public int multiScore(GameBoard board, List<List<List<Integer>>> words){
        /* Calculates the score of multiple words given the board state
        * words are inputted as a list of words, where each word contains a
        * list of ordered pairs corresponding to the coordinates of that word
        */
        int points = 0;
        for (List<List<Integer>> word: words){
            points += score(board, word);
        }
        return points;
    }

    @Override
    public int calculateUnplacedLetters(Cell[] letters){
        /* Returns the score of the unplaced letters
        * given the players hand
        */
        int points_so_far = 0;
            for (Cell letter: letters){
                points_so_far += letter.getScore();
            }
        return points_so_far;
    }
}
