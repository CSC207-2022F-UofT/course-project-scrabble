package use_case_implementations;

import usecases.usecase_implementations.BoardManager;
import entities.Game;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.ScrabbleDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests the BoardManager class.
 * @author Davit
 */
public class BoardManagerTest {
    /**
     * Tests checkLetter for happy flow for when the player places a tile on the board. Using the getBoardCellValue
     * method of BoardManager to test if the letter placed is equal to an "A".
     */
    @Test
    public void checkLetterTestValid(){
        // initialize game and board manager
        Game game = new Game();
        BoardManager b_manager = new BoardManager();

        // create coordinates and letter for move
        int[] coordinates = new int[]{7,3};
        String letter = "A";

        // add letter to board using checkLetter method
        b_manager.checkLetter(coordinates, letter, game);

        // check if value of cell on the board has updated with new move
        Assertions.assertEquals("A", game.getGameBoard().getBoardCellValue(7,3));
    }

    /**
     * Test checkLetter for unhappy flow when the player places a letter on the board on top of a previously placed letter.
     * Using checkLetter method, asserts false for the coordinates of the two letters.
     */
    @Test
    public void checkLetterTestOverlap(){
        // initialize game and board manager
        Game game = new Game();
        BoardManager b_manager = new BoardManager();

        // create coordinates and letter for move
        int[] coordinates = new int[]{7,3};
        String letter1 = "A";

        // create letter for another move using same coordinates
        String letter2 = "B";

        // add letter to board using checkLetter method
        b_manager.checkLetter(coordinates, letter1, game);

        // check if new move with identical coordinates will return false when added to the board using checkLetter method
        Assertions.assertFalse(b_manager.checkLetter(coordinates, letter2, game));
    }

    /**
     * Tests checkWord for happy flow when the player places the word HELLO on the board. Using checkWord, the return
     * list of words is compared to the actual word using assertEquals.
     */
    @Test
    public void checkWordTestHappy(){
        // initialize game and board manager
        Game game = new Game();
        BoardManager b_manager = new BoardManager();

        // create coordinates for five moves
        int[] coordinates1 = new int[]{7,5};
        int[] coordinates2 = new int[]{7,6};
        int[] coordinates3 = new int[]{7,7};
        int[] coordinates4 = new int[]{7,8};
        int[] coordinates5 = new int[]{7,9};

        // add same coordinates to arrayLists
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(0,7);
        coordinatesA.add(1,5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(0,7);
        coordinatesB.add(1,6);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(0,7);
        coordinatesC.add(1,7);
        ArrayList<Integer> coordinatesD = new ArrayList<>();
        coordinatesD.add(0,7);
        coordinatesD.add(1,8);
        ArrayList<Integer> coordinatesE = new ArrayList<>();
        coordinatesE.add(0,7);
        coordinatesE.add(1,9);

        // create letters for five moves forming the word "HELLO"
        String letter1 = "H";
        String letter2 = "E";
        String letter3 = "L";
        String letter4 = "L";
        String letter5 = "O";

        // add five letters to board using checkLetter method
        b_manager.checkLetter(coordinates1, letter1, game);
        b_manager.checkLetter(coordinates2, letter2, game);
        b_manager.checkLetter(coordinates3, letter3, game);
        b_manager.checkLetter(coordinates4, letter4, game);
        b_manager.checkLetter(coordinates5, letter5, game);

        // create list of words from the same coordinates
        ArrayList<List<List<Integer>>> list_of_words = new ArrayList<>();
        list_of_words.add(List.of(new ArrayList[]{coordinatesA, coordinatesB, coordinatesC, coordinatesD, coordinatesE}));

        // check if the list of correct words returned by checkWord method is the same as the actual list of words
        // the only valid word should be "HELLO"
        Assertions.assertEquals(list_of_words, b_manager.checkWord(game, new ScrabbleDictionary(), b_manager.getPrevBoard()));
    }


    /**
     * Tests checkWord for unhappy flow when the player places the letters "H","L","L","O" on the board. Using checkWord,
     * the length of the return list of words is compared to the int value 0 since there should be no valid words using these letters.
     */
    @Test
    public void checkWordTestUnhappy(){
        // initialize game and board manager
        Game game = new Game();
        BoardManager b_manager = new BoardManager();

        // create coordinates for four moves
        int[] coordinates1 = new int[]{7,5};
        int[] coordinates2 = new int[]{7,6};
        int[] coordinates3 = new int[]{7,7};
        int[] coordinates4 = new int[]{7,8};

        // create letters for four moves forming am invalid word
        String letter1 = "H";
        String letter2 = "L";
        String letter3 = "L";
        String letter4 = "O";

        // add four letters to board using checkLetter method
        b_manager.checkLetter(coordinates1, letter1, game);
        b_manager.checkLetter(coordinates2, letter2, game);
        b_manager.checkLetter(coordinates3, letter3, game);
        b_manager.checkLetter(coordinates4, letter4, game);

        // check if the size of the list of correct words returned by checkWord method is 0 since the given moves don't
        // form any valid English words.
        Assertions.assertEquals(0, b_manager.checkWord(game, new ScrabbleDictionary(), b_manager.getPrevBoard()).size());
    }



    /**
     * Tests resetMoves to see if the values on the board from the moves have been reset to their default values.
     */
    @Test
    public void resetMovesTest(){
        // initialize game and board manager
        Game game = new Game();
        BoardManager b_manager = new BoardManager();

        // create coordinates for five moves
        int[] coordinates1 = new int[]{7,5};
        int[] coordinates2 = new int[]{7,6};
        int[] coordinates3 = new int[]{7,7};
        int[] coordinates4 = new int[]{7,8};
        int[] coordinates5 = new int[]{7,9};

        // create letters for five moves forming the word "HELLO"
        String letter1 = "H";
        String letter2 = "E";
        String letter3 = "L";
        String letter4 = "L";
        String letter5 = "O";

        // add five letters to board using checkLetter method
        b_manager.checkLetter(coordinates1, letter1, game);
        b_manager.checkLetter(coordinates2, letter2, game);
        b_manager.checkLetter(coordinates3, letter3, game);
        b_manager.checkLetter(coordinates4, letter4, game);
        b_manager.checkLetter(coordinates5, letter5, game);

        // reset the moves on the board using resetMoves method
        b_manager.resetMoves(game);

        // check if each of the cells on the board that were changed by the moves have been reset
        Assertions.assertEquals("-", game.getGameBoard().getBoard()[7][5].getValue());
        Assertions.assertEquals("-", game.getGameBoard().getBoard()[7][6].getValue());
        Assertions.assertEquals("-", game.getGameBoard().getBoard()[7][7].getValue());
        Assertions.assertEquals("-", game.getGameBoard().getBoard()[7][8].getValue());
        Assertions.assertEquals("-", game.getGameBoard().getBoard()[7][9].getValue());
    }
}
