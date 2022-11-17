package games_manager;

import entities.Cell;
import entities.GameBoard;

import java.util.List;

public interface WordScoreCalculator { // interface for word score

    public int calculateWordScore(GameBoard board, List<List<Integer>> word); // returns score of word
}
