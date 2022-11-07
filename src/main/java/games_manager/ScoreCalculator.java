package games_manager;

import entities.Cell;
import entities.GameBoard;

import java.util.ArrayList;
import java.util.List;

public interface ScoreCalculator { //interface that calculates scores of words and hands
    public int score(GameBoard board, List<List<Integer>> word); // returns score of word
    public int multiScore(GameBoard board, List<List<List<Integer>>> word); // returns score of multiple words
    public int calculateUnplacedLetters(Cell[] letters); // returns score of unplaced letter in hand
}
