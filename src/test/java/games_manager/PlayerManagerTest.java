package games_manager;

import data.GameCreator;
import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class PlayerManagerTest {
    @Test
    public void drawHandTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0;
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player player = game.getCurrentPlayer();

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }
        p_manager.drawHand(game);
        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        for (int i=0; i<7; i++){
            // checking if players hand is not null
            Assertions.assertNotNull(player.getHand()[i]);
        }
        Assertions.assertEquals(bag_size_before-7, bag_size_after);

    }

    @Test
    public void drawTileTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player player = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        p_manager.drawHand(game);
        player.getHand()[3] = null;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.drawTile(game);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertNotNull(player.getHand()[3]);
        Assertions.assertEquals(bag_size_before-1, bag_size_after);
    }

    @Test
    public void swapHandTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        p_manager.drawHand(game);
        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.swapHand(game);

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before, bag_size_after); // bag should not change size when shuffled
    }

    @Test
    public void fillHandTest(){
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player p = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        p_manager.drawHand(game);

        PlayerManager.getHand(p)[0] = null;
        PlayerManager.getHand(p)[4] = null;
        PlayerManager.getHand(p)[6] = null;

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.fillHand(game);

        for (int i=0; i<7; i++){
            // checking if players hand is not null
            Assertions.assertNotNull(p.getHand()[i]);
        }

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before-3, bag_size_after); // bag should not change size when shuffled

    }

    @Test
    public void removeTileTestOneOccurence(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        PlayerManager.getHand(p1)[1] = new Cell ("C", 3, 1);
        PlayerManager.getHand(p1)[4] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[5] = new Cell ("R", 1, 1);

        p_manager.removeTile(game, "A");
        Cell[] hand = PlayerManager.getHand(p1);
        Assertions.assertNull(hand[4]);
    }

    @Test
    public void removeTileTestMultiOccurence(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        PlayerManager.getHand(p1)[1] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[4] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[5] = new Cell ("A", 1, 1);

        p_manager.removeTile(game, "A");
        Cell[] hand = PlayerManager.getHand(p1);
        Assertions.assertNull(hand[1]);
        Assertions.assertEquals("A", hand[4].getValue());
        Assertions.assertEquals("A", hand[5].getValue());
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
        pm.updateScoreForCurrentPlayer(30, game);       // add additional score to "Creator" player

        Assertions.assertArrayEquals(pm.endGame(game), playerArray);        // assert equivalency
    }



}
