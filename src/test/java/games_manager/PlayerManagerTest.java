package games_manager;

import Usecases.usecase_implementations.PlayerManager;
import data_gateways.GameCreator;
import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class PlayerManagerTest {
    
    @Test
    public void updateCurrentPlayerScoreTest() {
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        p_manager.updateScoreForCurrentPlayer(10, game);
        Assertions.assertEquals(10, game.getPlayers().get(0).getScore());
    }

    @Test
    public void endGameTestOneWinner(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "Creator"};

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        String p1 = "Tyler";
        Player playerReturn = null;
        for (Player player : game.getPlayers()){        // loop to find player in list of players
            if (p1.equals(player.getName())){
                playerReturn = player;
            }
        }
        Player[] playerArray = new Player[1];
        playerArray[0] = playerReturn;
        pm.updateScoreForCurrentPlayer(20, game);
        Assertions.assertArrayEquals(playerArray, pm.endGame(game));
    }

    @Test
    public void endGameTestTwoWinners(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "The", "Creator"};
        ArrayList<String> validPlayers =  new ArrayList<>(Arrays.asList("Tyler", "Creator"));

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        List<Player> playerArrayList = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++){        // manual loop to find valid Players
            if (validPlayers.contains(game.getPlayers().get(i).getName())){
                playerArrayList.add(game.getPlayers().get(i));
            }
        }
        Player[] playerArray = new Player[playerArrayList.size()];
        for (int i = 0; i < playerArrayList.size(); i++) {     // convert arraylist to array
            playerArray[i] = playerArrayList.get(i);
        }

        pm.updateScoreForCurrentPlayer(20, game);       // add score to "Tyler" Player
        game.incrementTurn();
        game.incrementTurn();
        pm.updateScoreForCurrentPlayer(20, game);       // add score to "Creator" Player

        Assertions.assertArrayEquals(pm.endGame(game), playerArray);        // assert equivalency
    }

    @Test
    public void endGameTestOneWinnerWithMultipleScores(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "The", "Creator"};
        ArrayList<String> validPlayers =  new ArrayList<>(List.of("Creator"));

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        List<Player> playerArrayList = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++){        // manual loop to find valid Players
            if (validPlayers.contains(game.getPlayers().get(i).getName())){
                playerArrayList.add(game.getPlayers().get(i));
            }
        }
        Player[] playerArray = new Player[playerArrayList.size()];
        for (int i = 0; i < playerArrayList.size(); i++) {     // convert arraylist to array
            playerArray[i] = playerArrayList.get(i);
        }

        pm.updateScoreForCurrentPlayer(20, game);       // add score to "Tyler" Player
        game.incrementTurn();
        game.incrementTurn();
        pm.updateScoreForCurrentPlayer(20, game);       // add score to "Creator" Player
        pm.updateScoreForCurrentPlayer(40, game);       // add additional score to "Creator" player

        Assertions.assertArrayEquals(pm.endGame(game), playerArray);        // assert equivalency
    }

}
