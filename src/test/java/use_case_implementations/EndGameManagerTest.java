package use_case_implementations;

import data_gateways.GameCreator;
import entities.Game;
import entities.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.EndGameManager;
import usecases.usecase_implementations.PlayerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EndGameManagerTest {

    @Test
    public void endGameTestOneWinner(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "Creator"};

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        EndGameManager em = new EndGameManager();
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
        Assertions.assertArrayEquals(playerArray, em.endGame(game));
    }

    @Test
    public void endGameTestTwoWinners(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "The", "Creator"};
        ArrayList<String> validPlayers =  new ArrayList<>(Arrays.asList("Tyler", "Creator"));

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        EndGameManager em = new EndGameManager();
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

        Assertions.assertArrayEquals(em.endGame(game), playerArray);        // assert equivalency
    }

    @Test
    public void endGameTestOneWinnerWithMultipleScores(){
        GameCreator gm = new GameCreator();
        String[] playerInputs = {"Tyler", "The", "Creator"};
        ArrayList<String> validPlayers =  new ArrayList<>(List.of("Creator"));

        Game game = gm.createNewGame(playerInputs);
        PlayerManager pm = new PlayerManager();
        EndGameManager em = new EndGameManager();
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

        Assertions.assertArrayEquals(em.endGame(game), playerArray);        // assert equivalency
    }
}
