package games_manager;

import entities.Cell;

public interface HandScoreCalculator {
    public int calculateUnplacedLetters(Cell[] letters); // returns score of unplaced letter in hand
    public void initializeCellScore(Cell letter);
}
