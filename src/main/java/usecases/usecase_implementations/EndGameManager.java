package usecases.usecase_implementations;

import usecases.usecase_interfaces.EndGameUsecase;
import entities.Game;
import entities.Player;

import java.util.ArrayList;
import java.util.List;

public class EndGameManager implements EndGameUsecase {
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
