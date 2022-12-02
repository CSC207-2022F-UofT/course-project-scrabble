package games_manager;
import UsecaseInterfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;
/**
 * This class is responsible for managing the Player entity
 * @author Umair & Jazli
 */

public class PlayerManager implements UpdateScoreUsecase{




    /**
     * This method is responsible for changing the name of a player.
     * @param player the player who wants there name changed.
     * @param new_name the new name for the player
     */
    public static void setName(Player player, String new_name) {
        player.setName(new_name);
    }

    /**
     * This method is responsible for returning the name of a player.
     * @param player the player whose name will be returned.
     * @return the name of the given Player
     */
    public static String getName(Player player) {
        return player.getName();
    }

    /**
     * This method is responsible for returning the name of a player.
     * @param player the player whose score will be returned.
     * @param new_score new score of the player
     */
    public static void setScore(int new_score, Player player) {
        player.setScore(new_score);
    }

    /**
     * This method is responsible for returning the score of a player.
     * @param player the player whose score will be returned.
     * @return the score of the given Player
     */
    public static int getScore(Player player) { return player.getScore(); }

    /**
     * This method is responsible for setting the hand of a player.
     * @param player the player whose hand will be set.
     * @param new_hand the hand that will replace player's hand
     */
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


    }

}


