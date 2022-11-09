package data;

import entities.Cell;
import entities.Player;
import entities.GameBoard;
import entities.LetterBag;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameSaverAndLoaderTest {

    @Test
    public void saveData(){ // run this test before load test
        // creating objects to be saved
        GameBoard board = new GameBoard();
        Player p1 = new Player("Steve");
        Player p2 = new Player("Bob");
        LetterBag bag = new LetterBag();

        // editing some objects
        board.getBoard()[0][0] = new Cell("V", 4, 2);
        p2.setScore(25);
        bag.putTile("A");
        bag.removeTile("C");


        // saving all objects into data.ser
        GameSaver.saveGame(board, p1, p2, bag);
    }

    @Test
    public void loadData(){ // checks if the objects are loaded correctly
        // loading objects from data.ser into array
        Object[] objects = GameLoader.loadGame();

        // loaded objects returned in the following order: GameBoard, Player1, Player2, LetterBag
        assert objects != null;
        // assigning objects the loaded values
        GameBoard board = (GameBoard) objects[0];
        Player p1 = (Player) objects[1];
        Player p2 = (Player) objects[2];
        LetterBag bag = (LetterBag) objects[3];

        // assertions checking if the updated data that was saved in the previous test
        // is within the new objects
        Assertions.assertEquals(2, board.getBoard()[0][0].getMultiplier());
        Assertions.assertEquals(0, p1.getScore());
        Assertions.assertEquals(25, p2.getScore());
        Assertions.assertEquals(10, bag.getNumTile("A"));
        Assertions.assertEquals(1, bag.getNumTile("C"));

    }


}
