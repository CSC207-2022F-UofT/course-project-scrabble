package games_manager;

import entities.Cell;
import entities.GameBoard;
import games_manager.BoardManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ScoreCalculator { //interface that calculates scores of words and hands

    public static int score(GameBoard board, List<List<Integer>> word) // returns score of word
    {
        /* returns the score of the move given the new word's coordinates and current board state
         * word formatted as: [[2, 3], [4, 1], ...]
         */
        int points_so_far = 0; // variable to store points of word
        for (List<Integer> coordinates: word){ // loops over coordinates
            Cell letter = BoardManager.boardManagerGetCell(coordinates.get(0), coordinates.get(1), board); // saves the cell representing the letter in letter
            points_so_far += BoardManager.boardManagerGetCellScore(letter)
                    *BoardManager.boardManagerGetCellMultiplier(letter); // multiplies the score of the cell by the multiplier
        }
        if (word.size() == 7) { // If all words in hand are used then add 50 points to turn
            points_so_far += 50;
        }
        return points_so_far;
    }

    public static int multiScore(GameBoard board, List<List<List<Integer>>> words) // returns score of multiple words
    {
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

    public static int calculateUnplacedLetters(Cell[] letters) // returns score of unplaced letter in hand
    {
        /* Returns the score of the unplaced letters
         * given the players hand
         */
        int points_so_far = 0;
        for (Cell letter: letters){
            points_so_far += BoardManager.boardManagerGetCellScore(letter);
        }
        return points_so_far;
    }
}
