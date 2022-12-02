package usecases.usecase_interfaces;

import entities.Game;

/**
 * This interface verifies and updates new moves on the board.
 * @author Davit
 */
public interface PlaceTileUsecase {
    //returns true if letter is valid, updates the board
    public boolean checkLetter(int[] coordinates, String letter, Game game);
}
