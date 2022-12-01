package Usecases.usecase_interfaces;
import entities.Game;
import java.util.List;

/**
 * This interface is responsible for calculating scores of words
 * @author Umair
 */
public interface CalculateWordScoreUsecase { // interface for word score

    public int calculateMultiWordScore(Game game, List<List<List<Integer>>> words);
    //changed this interfact to score multiple words
    
}
