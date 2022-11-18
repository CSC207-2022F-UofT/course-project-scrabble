package UsecaseInterfaces;

import entities.Cell;
import entities.Game;

public interface HandScoreCalculator {
    public int calculateUnplacedLetters(Game game); // returns score of unplaced letter in hand
    public void initializeCellScore(Cell letter);
}
