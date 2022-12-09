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
 * @author Francisco and Claire
 */
public class TileCheckerTest {
    TileChecker checker = new TileChecker(); //initialize TileChecker here as it should be the same throughout
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
    /**
     * Test isValid for happy flow when there are no tiles in the way
     * using isValid method, asserts true for a valid tile placement
     */
    @Test
    public void isValidYes() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cell
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letter
        BoardManager.SetBoardCell(7, 4, c0, board);

        // check if tileChecker knows those tiles are empty
        Assertions.assertTrue(checker.isValid(2, 5, board));
    }
    /**
     * Test isValid for unhappy flow when there is a tile in the way
     * using isValid method, asserts false for an invalid tile placement
     */
    @Test
    public void isValidNo() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // check if tileChecker knows those tiles are occupied
        Assertions.assertFalse(checker.isValid(7, 4, board));
    }
    /**
     * Test isConsecutive for happy flow when all the tiles are placed in a row
     * using isConsecutive method, asserts true for a valid move placement
     */
    @Test
    public void isConsecutiveYes() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(7);
        coordinatesA.add(5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(7);
        coordinatesB.add(6);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(7);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for happy flow when all the tiles are placed in a column
     * using isConsecutive method, asserts true for a valid move placement
     */
    @Test
    public void isConsecutiveColYes() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(7);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(7);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(7);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for happy flow when all the tiles are placed in a row with a filled gap
     * using isConsecutive method, asserts true for a valid move placement
     */
    @Test
    public void isConsecutiveGap() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(7);
        coordinatesA.add(3);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(7);
        coordinatesB.add(5);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(6);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for happy flow when all the tiles are placed in a column with a filled gap
     * using isConsecutive method, asserts true for a valid move placement
     */
    @Test
    public void isConsecutiveColGap() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(4);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(4);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(8);
        coordinatesC.add(4);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for unhappy flow when all the tiles are not placed in a row
     * using isConsecutive method, asserts false for an invalid move placement
     */
    @Test
    public void isConsecutiveNo() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(7);
        coordinatesA.add(3);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(8);
        coordinatesB.add(5);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(9);
        coordinatesC.add(6);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertFalse(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for unhappy flow when all the tiles are placed in a row with an unfilled gap
     * using isConsecutive method, asserts false for an invalid move placement
     */
    @Test
    public void isConsecutiveGapNo() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(7);
        coordinatesA.add(3);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(7);
        coordinatesB.add(5);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(6);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertFalse(checker.isConsecutive(move, board));
    }
    /**
     * Test isConsecutive for unhappy flow when all the tiles are placed in a column with an unfilled gap
     * using isConsecutive method, asserts false for an invalid move placement
     */
    @Test
    public void isConsecutiveColGapNo() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(4);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(4);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(8);
        coordinatesC.add(4);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertFalse(checker.isConsecutive(move, board));
    }
    /**
     * Test isTouching for happy flow when the tiles are placed to the left of a tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingLeft() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(3);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(3);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(3);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for happy flow when the tiles are placed to the right of a tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingRight() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(5);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(5);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(5);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for happy flow when the tiles are placed above a tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingUp() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(6);
        coordinatesA.add(2);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(3);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(6);
        coordinatesC.add(4);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for happy flow when the tiles are placed below a tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingDown() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(8);
        coordinatesA.add(2);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(8);
        coordinatesB.add(3);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(8);
        coordinatesC.add(4);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for happy flow when all the tiles are placed in a column around another tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingAroundCol() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(4);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(4);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(8);
        coordinatesC.add(4);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for happy flow when all the tiles are placed in a row around another tile
     * using isTouching method, asserts true for a valid move placement
     */
    @Test
    public void isTouchingAround() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(7);
        coordinatesA.add(3);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(7);
        coordinatesB.add(5);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(6);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertTrue(checker.isTouching(move, board));
    }
    /**
     * Test isTouching for unhappy flow when the tiles are not touching already placed tiles
     * using isTouching method, asserts false for an invalid move placement
     */
    @Test
    public void isTouchingNo() {
        // Create a new game and new board
        Game game = new Game();
        GameBoard board = game.getGameBoard();

        // initialize new Cells
        Cell c0 = new Cell("C", 3, 1);

        // initializing board state and adding letters
        BoardManager.SetBoardCell(7, 4, c0, board);

        // Initialize new move
        ArrayList<List<Integer>> move = new ArrayList<List<Integer>>();

        // Construct coordinates
        ArrayList<Integer> coordinatesA = new ArrayList<>();
        coordinatesA.add(5);
        coordinatesA.add(2);
        ArrayList<Integer> coordinatesB = new ArrayList<>();
        coordinatesB.add(6);
        coordinatesB.add(2);
        ArrayList<Integer> coordinatesC = new ArrayList<>();
        coordinatesC.add(7);
        coordinatesC.add(2);

        // Add coordinates to move
        move.add(coordinatesA);
        move.add(coordinatesB);
        move.add(coordinatesC);

        Assertions.assertFalse(checker.isTouching(move, board));
    }



}
