package use_case_interfaces;

import entities.Cell;
import entities.Game;
/**
 * This interface is responsible for calculating scores related to a Player's hand
 * @author Umair
 */
public interface HandScoreCalculator {
    public int calculateUnplacedLetters(Game game); // returns score of unplaced letter in hand
    public void initializeCellScore(Cell letter);
}
