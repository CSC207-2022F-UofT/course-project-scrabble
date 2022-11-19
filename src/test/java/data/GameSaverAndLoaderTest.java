package data;

import entities.*;
import games_manager.BoardManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class GameSaverAndLoaderTest {

    @Test
    public void saveData(){ // run this test before load test
        // creating objects to be saved
        GameSaverSystem game_saver = new GameSaverSystem();
        GameCreator gameCreator = new GameCreator();
        String[] playerInputNames = new String[]{"Billy", "Mario"};
        Game game = gameCreator.createNewGame(playerInputNames);


        Player p1 = game.getPlayers().get(0);
        Player p2 = game.getPlayers().get(1);
        GameBoard board = game.getGameBoard();
        LetterBag bag = game.getLetterBag();

        // editing some objects
        BoardManager.boardManagerSetBoardCell(0, 0, new Cell("V", 4, 2), board);
        p2.setScore(25);
        bag.putTile("A");
        bag.removeTile("C");


        // saving all objects into data.ser
        game_saver.saveGame(game);
    }

    @Test
    public void loadData(){ // checks if the objects are loaded correctly
        // loading objects from data.ser into array
        GameLoaderSystem game_loader = new GameLoaderSystem();
        Game game = game_loader.loadGame();

        // loaded objects returned in the following order: GameBoard, Player1, Player2, LetterBag
        assert game != null;
        // assigning objects the loaded values
        GameBoard board = game.getGameBoard();
        Player p1 = game.getPlayers().get(0);
        Player p2 = game.getPlayers().get(1);
        LetterBag bag = game.getLetterBag();

        // assertions checking if the updated data that was saved in the previous test
        // is within the new objects
        Assertions.assertEquals(3, board.getBoard()[0][0].getMultiplier());
        Assertions.assertEquals(0, p1.getScore());
        Assertions.assertEquals(25, p2.getScore());
        Assertions.assertEquals(10, bag.getNumTile("A"));
        Assertions.assertEquals(1, bag.getNumTile("C"));

    }


}
