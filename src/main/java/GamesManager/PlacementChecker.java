package GamesManager;

import entities.GameBoard;

public interface PlacementChecker { //interface that checks whether individual tiles are valid
    boolean isValid(int row, int column, GameBoard board);

}

