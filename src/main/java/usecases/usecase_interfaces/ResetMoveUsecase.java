package usecases.usecase_interfaces;

import entities.Game;
import java.util.ArrayList;
import usecases.usecase_implementations.MoveInfo;

/**
 * This interface resets the new moves on the board during player's turn.
 * @author Davit
 */
public interface ResetMoveUsecase {
    // function resets the new moves on the board
    public ArrayList<MoveInfo> resetMoves(Game game);
    //function that resets the moves in MoveInfo list
    public void clearMoves();
}
