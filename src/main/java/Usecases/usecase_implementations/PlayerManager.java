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
public class PlayerManager implements UpdateScoreUsecase, EndGame{



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

    /**
     * This method is responsible for returning an array of players that won at the end of the game.
     * @param game the game with the players of the game.
     * @return Player[] an array of all player's that won the game
     */
    @Override
    public Player[] endGame(Game game){
        int ind_max_so_far = 0;                             // index of the highest score player
        List<Player> maxPlayers = new ArrayList<>();        // list of players with the highest scores so far
        List<Player> listOfPlayers = game.getPlayers();     // list of players in the game
        for (int i = 0; i < (listOfPlayers.size()); i++) {  // loop through list of players
            Player player = listOfPlayers.get(i);           // current player that is indexed
            if(player.getScore() > listOfPlayers.get(ind_max_so_far).getScore()) {   // if new player has higher score
                ind_max_so_far = i;
                // empty the list of players that had a max score
                maxPlayers.clear();
                // add that new player this empty list of the highest scores
                maxPlayers.add(player);

            }
            else if (player.getScore() == listOfPlayers.get(ind_max_so_far).getScore()) { // if new player has equal score
                // add that the new player to the list of the highest scores so far
                maxPlayers.add(player);
            }
        }
        Player [] maxArrayPlayers = new Player[maxPlayers.size()];
        for (int i = 0; i < maxPlayers.size(); i++) {     // convert arraylist to array
            maxArrayPlayers[i] = maxPlayers.get(i);
        }
        return maxArrayPlayers;                           // returns an Array of Players that could be just one or two people


    }

}


