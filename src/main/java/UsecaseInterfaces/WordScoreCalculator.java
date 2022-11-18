package UsecaseInterfaces;

import entities.Cell;
import entities.Game;
import entities.GameBoard;

import java.util.List;

public interface WordScoreCalculator { // interface for word score

    public int calculateWordScore(Game game, List<List<Integer>> word); // returns score of word
}
