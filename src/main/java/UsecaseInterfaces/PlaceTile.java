package UsecaseInterfaces;

import entities.GameBoard;

public interface PlaceTile { //interface that verifies and updates moves on the board
    //returns true if letter is valid, updates the board
    public boolean checkLetter(int[] coordinates, String letter, GameBoard board, boolean first_move);
}
