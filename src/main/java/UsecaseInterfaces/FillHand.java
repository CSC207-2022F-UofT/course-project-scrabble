package UsecaseInterfaces;

import entities.Game;
/**
 * This interface is responsible for filling a hand for a Player
 * @author Umair
 */
public interface FillHand { // interface for the draw tile use case
    public void fillHand(Game game);
}
