package UsecaseInterfaces;

import entities.Cell;
import entities.Game;
import entities.GameBoard;

import java.util.List;

public interface WordScoreCalculator { // interface for word score

    public int calculateMultiWordScore(Game game, List<List<List<Integer>>> words);
    //changed this interfact to score multiple words
    
}
