package data;

import data_gateways.GameCreator;
import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class GameCreatorTest {
    /**
     * Tests whether the GameCreator has actually created a game that has been modified. Used names "First" and "Second"
     * while changing the scores, while asserting that the number of tiles in the game = the original bag tiles
     */
    @Test
    public void bagAndBoardTest(){
        // test to check whether all values are default for bag and board
        GameCreator gameCreator = new GameCreator();
        String[] names = {"First", "Second"};
        Game game = gameCreator.createNewGame(names);
        GameBoard board = game.getGameBoard();
        LetterBag bag = game.getLetterBag();

        Assertions.assertEquals(0, board.getBoard()[4][6].getScore());
        for (int i=0; i<15; i++){
            for (int j=0; j<15; j++){
                Assertions.assertEquals("-", board.getBoardCell(i, j).getValue()); // checks if all spaces are blank
            }
        }

        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] num_letters = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 2, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 2};

        for (int i=0; i<26; i++){
            Assertions.assertEquals(num_letters[i], bag.getNumTile(letters[i])); // checks if hashmap is default
        }
    }

    /**
     * This is a test that is responsible players to see if the Game accurately filled their hands and each Player's
     * names and scores are accurate.
     */
    @Test
    public void playerTest(){
        GameCreator gameCreator = new GameCreator();
        String[] names = {"First", "Second"};
        Game game = gameCreator.createNewGame(names);
        List<Player> playerList = game.getPlayers();
        Player p1 = playerList.get(0);
        Player p2 = playerList.get(1);

        Assertions.assertEquals("First", p1.getName());
        Assertions.assertEquals(0, p1.getScore());

        Assertions.assertEquals("Second", p2.getName());
        Assertions.assertEquals(0, p2.getScore());

        for (int i=0; i<7; i++){
            Assertions.assertNull(p1.getHand()[i]); // checks if hand is null
            Assertions.assertNull(p2.getHand()[i]);
        }
    }
}
