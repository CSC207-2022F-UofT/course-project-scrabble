package games_manager;
import entities.*;

import java.util.HashMap;


public class ScoringSystem implements ScoreCalculator{

    public static void initializeHandScore(Cell[] tiles, Player player){
        // assigns scores to the cells in players hands
        // reassigns players hands to the hand with scores
        final int[] letter_scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3,
                1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        final HashMap<String, Integer> letter_to_score = new HashMap<>();

        for (Cell letter: tiles){
            String value = BoardManager.boardManagerGetCellValue(letter); // gets the letter represented by the cell
            int score = letter_to_score.get(value); // gets the score of the letter
            BoardManager.boardManagerSetCellScore(letter, score); // changes the cell's score to that of the letter it represents
        }

    }
}
