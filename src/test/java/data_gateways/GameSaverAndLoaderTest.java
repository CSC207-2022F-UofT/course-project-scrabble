package data_gateways;

import entities.*;
import usecases.usecase_implementations.BoardManager;
import data_gateways.gateways_implementation.*;
import org.junit.Test;
// import org.junit.jupiter.api.Assertions;
// import java.io.File;

public class GameSaverAndLoaderTest {

    /**
     * Test is responsible for accurately saving a game state to a data.ser file located in data package in main.
     */
    @Test
    public void saveDataTest(){
        // checks if the objects are loaded correctly
        // creating objects to be saved
        GameSaverSystem game_saver = new GameSaverSystem();
        GameCreator gameCreator = new GameCreator();

        String[] playerInputNames = new String[]{"Billy", "Mario", "Harry"};
        Game gameSaved = gameCreator.createNewGame(playerInputNames);

        Player p1Saved = gameSaved.getPlayers().get(0);
        Player p2Saved = gameSaved.getPlayers().get(1);
        GameBoard boardSaved = gameSaved.getGameBoard();
        LetterBag bagSaved = gameSaved.getLetterBag();

        // editing some objects

        BoardManager.SetBoardCell(0, 0, new Cell("V", 4, 2), boardSaved);
        p1Saved.setScore(2);
        p2Saved.setScore(25);
        bagSaved.putTile("A");
        bagSaved.removeTile("C");

        // saving all objects into data.ser
        game_saver.saveGame(gameSaved);

    }

//    public void saveAndLoadDataTest(){
//
//        File assertFile = new File("src/main/java/data/data.ser");
//        assert assertFile.exists();
//
//        // loading objects from data.ser into array
//        GameLoaderSystem game_loader = new GameLoaderSystem();
//        Game game = game_loader.loadGame();
//
//        // assigning objects the loaded values
//        GameBoard board = game.getGameBoard();
//        Player p1 = game.getPlayers().get(0);
//        Player p2 = game.getPlayers().get(1);
//        Player p3 = game.getPlayers().get(2);
//        LetterBag bag = game.getLetterBag();
//
//        // assertions checking if the updated data that was saved in the previous test
//        // is within the new objects
//        Assertions.assertEquals(3, board.getBoard()[0][0].getMultiplier());
//        Assertions.assertEquals(3, board.getBoard()[14][14].getMultiplier());
//        Assertions.assertEquals(2, p1.getScore());
//        Assertions.assertEquals(25, p2.getScore());
//        Assertions.assertEquals(0, p3.getScore());
//        Assertions.assertEquals(10, bag.getNumTile("A"));
//        Assertions.assertEquals(1, bag.getNumTile("C"));
//
//    }


}
