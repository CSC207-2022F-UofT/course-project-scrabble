package data;

import entities.Cell;
import entities.Player;
import entities.GameBoard;
import entities.LetterBag;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
public class GameCreatorTest {
    @Test
    public void bagAndBoardTest(){
        // test to check whether all values are default for bag and board
        Object[] objects = GameCreator.newGame("Rachel", "Charlie");
        GameBoard board = (GameBoard) objects[0];
        LetterBag bag = (LetterBag) objects[3];

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

    @Test
    public void playerTest(){
        Object[] objects = GameCreator.newGame("Rachel", "Charlie");
        Player player1 = (Player) objects[1];
        Player player2 = (Player) objects[2];

        Assertions.assertEquals("Rachel", player1.getName());
        Assertions.assertEquals(0, player1.getScore());

        Assertions.assertEquals("Charlie", player2.getName());
        Assertions.assertEquals(0, player2.getScore());

        for (int i=0; i<7; i++){
            Assertions.assertNull(player1.getHand()[i]); // checks if hand is null
            Assertions.assertNull(player2.getHand()[i]);
        }
    }
}
