package games_manager;
import UsecaseInterfaces.WordScoreCalculator;
import UsecaseInterfaces.HandScoreCalculator;
import entities.*;

import java.util.HashMap;
import java.util.List;
/**
 * This class is responsible for scoring words and tiles
 * @author Umair
 */


public class ScoringSystem implements WordScoreCalculator, HandScoreCalculator {
    final int[] LETTER_SCORE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3,
            1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private final HashMap<String, Integer> letter_to_score = new HashMap<>();
    public ScoringSystem() {
        for(int i = 0; i<LETTERS.length; i++)
            letter_to_score.put(LETTERS[i], LETTER_SCORE[i]);
    }

    /**
     * This method is responsible for scoring a word on the game board
     * @param game The game with the move on its board.
     * @param word A nested list with coordinates of the word. Given in (y, x) format
     * @return the score of the placed word
     */
    public int calculateWordScore(Game game, List<List<Integer>> word) {
        GameBoard board = game.getGameBoard();
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

    /**
     * This method is responsible for scoring a player's hand
     * @param game The game with the current player's hand to be scored
     * @return the score of the unplaced letters in the current player's hand
     */
    @Override
    public int calculateUnplacedLetters(Game game) // returns score of unplaced letter in hand
    {
        /* Returns the score of the unplaced letters
         * given the players hand
         */
        Player p = game.getCurrentPlayer();
        Cell[] letters = PlayerManager.getHand(p);
        int points_so_far = 0;
        for (Cell letter: letters){
            if (letter != null) {
                points_so_far += BoardManager.boardManagerGetCellScore(letter);
            }
        }
        return points_so_far;
    }

    /**
     * This method is responsible for assigning the correct score to the given Cell
     * @param letter The Cell to be initialized
     * letter's value must be a capital letter from A-Z
     */
    @Override
    public void initializeCellScore(Cell letter){
        // Precondition: The cell's value is a capital letter from A-Z
        // Given a cell the function will assign the correct score to that cell

        String value = BoardManager.boardManagerGetCellValue(letter); // gets the letter represented by the cell
        int score = this.letter_to_score.get(value); // gets the score of the letter
        BoardManager.boardManagerSetCellScore(letter, score); // changes the cell's score to that of the letter it represents
    }

    /**
     * This method is responsible for scoring word(s) on the gameboard
     * @param game The game with the move on its board.
     * @param words A triple nested list with coordinates of each word. Given in (y, x) format.
     * @return the combined score of all the words inputted into the method
     */
    @Override
    public int calculateMultiWordScore(Game game, List<List<List<Integer>>> words) // returns score of multiple words
    {
        /* Calculates the score of multiple words given the board state
         * words are inputted as a list of words, where each word contains a
         * list of ordered pairs corresponding to the coordinates of that word
         */
        int points = 0;
        for (List<List<Integer>> word: words){
            points += calculateWordScore(game, word);
        }
        return points;
    }
}
