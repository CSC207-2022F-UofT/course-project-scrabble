package UsecaseInterfaces;

import entities.Game;

/**
 * This interface resets the new moves on the board during player's turn.
 * @author Davit
 */
public interface ResetMove {
    // function resets the new moves on the board
    public void resetMoves(Game game);
    //function that resets the moves in MoveInfo list
    public void clearMoves();
}
