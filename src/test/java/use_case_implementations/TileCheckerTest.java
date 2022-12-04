package use_case_implementations;

import entities.Cell;
import usecases.usecase_implementations.BoardManager;
import entities.Game;
import entities.GameBoard;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.TileChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests the TileChecker class.
 * @author Francisco
 */
public class TileCheckerTest {
    /**
     * Test wordList for happy flow when there is only one word that is placed down adjacent to an existing tile.
     * Using wordList method, asserts true for size of list = 1 when the coordinates are adjacent.
     */
    @Test
    public void checkAdjacentWord(){

        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize a new Cell
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        ArrayList<List<Integer>> listA = new ArrayList<>();

        // add coordinates to arrayLists
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(0,7);
        coordinatesA.add(1,5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(0,7);
        coordinatesB.add(1,6);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(0,7);
        coordinatesC.add(1,7);

        // initialize Tilechecker
        TileChecker checker = new TileChecker();

        // Add coordinates to Arraylist
        listA.add(coordinatesA);
        listA.add(coordinatesB);
        listA.add(coordinatesC);

        // check if the new word is generated for checking in dictionary for validity
        Assertions.assertEquals(checker.wordList(listA, board).size(), 1);
    }
    /**
     *  Test wordList for unhappy flow when there is only one word that is placed down not adjacent to an existing tile.
     *  Using wordList method, asserts true for size of list = 0 when the coordinates are not adjacent.
     */
    @Test
    public void checkNonAdjacentWord(){

        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize a new Cell
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 9, c0, board);

        ArrayList<List<Integer>> listA = new ArrayList<>();

        // add coordinates to arrayLists
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(0,7);
        coordinatesA.add(1,5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(0,7);
        coordinatesB.add(1,6);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(0,7);
        coordinatesC.add(1,7);

        // initialize Tilechecker
        TileChecker checker = new TileChecker();

        // Add coordinates to Arraylist
        listA.add(coordinatesA);
        listA.add(coordinatesB);
        listA.add(coordinatesC);

        // check if the new word is generated for checking in dictionary for validity
        Assertions.assertEquals(checker.wordList(listA, board).size(), 0);
    }
    /**
     *  Test wordList for happy flow when there is only one word that is placed down adjacent to two existing tile.
     *  Using wordList method, asserts true for size of list = 2 when the coordinates are adjacent.
     */
    @Test
    public void checkTwoAdjacentWord(){

        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);
        Cell c1 = new Cell("B", 2, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);
        BoardManager.SetBoardCell(6, 7, c1, board);

        ArrayList<List<Integer>> listA = new ArrayList<>();

        // add coordinates to arrayLists
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(0,7);
        coordinatesA.add(1,5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(0,7);
        coordinatesB.add(1,6);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(0,7);
        coordinatesC.add(1,7);

        // initialize Tilechecker
        TileChecker checker = new TileChecker();

        // Add coordinates to Arraylist
        listA.add(coordinatesA);
        listA.add(coordinatesB);
        listA.add(coordinatesC);

        // check if the new word is generated for checking in dictionary for validity
        Assertions.assertEquals(checker.wordList(listA, board).size(), 2);
    }

}
