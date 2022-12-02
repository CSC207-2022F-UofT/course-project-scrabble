package usecases.usecase_implementations;
import usecases.usecase_interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;
/**
 * This class is responsible for managing the Player entity
 * @author Umair & Jazli
 */

public class PlayerManager implements UpdateScoreUsecase{
    public static void setHand(Cell[] new_hand, Player player){ player.setHand(new_hand); }

    /**
     * This method is responsible for returning the hand of a player.
     * @param player the player whose hand will be returned.
     * @return the hand of the given Player in an array
     */
    public static Cell[] getHand(Player player) { return player.getHand(); }

    /**
     * This method is responsible for updating the score of the current player.
     * @param newScore the score that needs to be updated to player's score.
     * @param game the game with the current player whose score needs to be updated
     */
    @Override
    public void updateScoreForCurrentPlayer(int newScore, Game game) {
        game.getCurrentPlayer().setScore(newScore);
    }

    public void addTile(Game game, String letter){
        Player player = game.getCurrentPlayer();
        for (int i=0; i<player.getHand().length; i++){
            Cell cell = player.getHand()[i];
            if (cell == null) {
                player.getHand()[i] = new Cell(letter, 0); // removes tile
                return;
            }
        }

    }
}


