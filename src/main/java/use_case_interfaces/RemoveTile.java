package use_case_interfaces;

import entities.Game;
/**
 * This interface is responsible for removing a tile from a Player's hand
 * @author Umair
 */
public interface RemoveTile {
    public void removeTile(Game game, String letter);
}
