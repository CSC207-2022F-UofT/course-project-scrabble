package UsecaseInterfaces;

import entities.Game;

public interface ResetMove { //interface that resets the board when player changes their mind
    // function resets the moves on the board
    public void resetMoves(Game game);
}
