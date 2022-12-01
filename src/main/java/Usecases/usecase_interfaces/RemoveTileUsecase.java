package Usecases.usecase_interfaces;

import entities.Game;
/**
 * This interface is responsible for removing a tile from a Player's hand
 * @author Umair
 */
public interface RemoveTileUsecase {
    public void removeTile(Game game, String letter);
}
