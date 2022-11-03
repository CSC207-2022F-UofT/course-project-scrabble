package GamesManager;
import entities.*;
public class ScoringSystem {

    // returns the score of the move given the word's coordinates and current board state
    // word formatted as: [[2, 3], [4, 1], ...]
    public int score(GameBoard board, int[][] word) {
        int points_so_far = 0; // variable to store points of word
        for (int[] coordinates: word){ // loops over coordinates
            Cell letter = board.getBoardCell(coordinates[0], coordinates[1]); // saves the cell representing the letter in letter
            points_so_far = letter.getScore()*letter.getMultiplier(); // multiplies the score of the cell by the multiplier
        }
        return points_so_far;
    }
}
