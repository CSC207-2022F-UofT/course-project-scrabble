package UsecaseInterfaces;
import entities.Game;
import java.util.List;

/**
 * This interface is responsible for calculating scores of words
 * @author Umair
 */
public interface WordScoreCalculator { // interface for word score

    public int calculateWordScore(Game game, List<List<Integer>> word); // returns score of word
}
