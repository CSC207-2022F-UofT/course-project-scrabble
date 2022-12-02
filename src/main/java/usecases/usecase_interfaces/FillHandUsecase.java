package usecases.usecase_interfaces;

import entities.Game;
/**
 * This interface is responsible for filling a hand for a Player
 * @author Umair
 */
public interface FillHandUsecase { // interface for the draw tile use case
    public void fillHand(Game game);
}
