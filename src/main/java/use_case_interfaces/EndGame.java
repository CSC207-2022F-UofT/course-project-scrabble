package use_case_interfaces;

import entities.Game;
import entities.Player;
/**
 * This interface is responsible for returning an array of players that won
 * @author Jazli
 */
public interface EndGame {
    Player[] endGame(Game game);
}
