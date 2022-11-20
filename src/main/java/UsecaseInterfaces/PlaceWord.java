package UsecaseInterfaces;

import entities.Game;
import games_manager.MoveInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface verifies and updates new words on the board.
 * @author Davit
 */
public interface PlaceWord {
    //returns list of valid words from player's moves and updates the board
    public ArrayList<List<List<Integer>>> checkWord(Game game);
}
