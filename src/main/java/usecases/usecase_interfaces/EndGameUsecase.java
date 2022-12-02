package usecases.usecase_interfaces;

import entities.Game;
import entities.Player;
/**
 * This interface is responsible for returning an array of players that won
 * @author Jazli
 */
public interface EndGameUsecase {
    Player[] endGame(Game game);
}
