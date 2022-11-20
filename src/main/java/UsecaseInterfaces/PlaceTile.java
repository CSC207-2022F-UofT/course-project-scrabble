package UsecaseInterfaces;

import entities.Game;

/**
 * This interface verifies and updates new moves on the board.
 * @author Davit
 */
public interface PlaceTile {
    //returns true if letter is valid, updates the board
    public boolean checkLetter(int[] coordinates, String letter, Game game);
}
