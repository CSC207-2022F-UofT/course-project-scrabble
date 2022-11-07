package games_manager;

import entities.Cell;
import entities.GameBoard;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ScoringSystemTest {

    @Test
    public void noMultipliers (){
        // creating letter cells
        Cell c0 = new Cell("C", 3, 1);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("R", 1, 1);
        Cell c3 = new Cell("E", 1, 1);

        // initializing board state and adding letters
        GameBoard board = new GameBoard();
        board.setBoardCell(0, 0, c0);
        board.setBoardCell(0, 1, c1);
        board.setBoardCell(0, 2, c2);
        board.setBoardCell(0, 3, c3);


        ScoringSystem scorer = new ScoringSystem();
        int[][] pos = {{0,0},{0,1},{0,2},{0,3}}; // creating 2d position array of new word
        Assertions.assertEquals(6, scorer.score(board, pos));

    }

    @Test
    public void withMultipliers (){
        // creating letter cells
        Cell c0 = new Cell("V", 4, 3);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("L", 1, 1);
        Cell c3 = new Cell("U", 1, 1);
        Cell c4 = new Cell("E", 1, 2);

        // initializing board state and adding letters
        GameBoard board = new GameBoard();
        board.getBoard()[0][0] = new Cell("", 3); // triple score
        board.getBoard()[0][4] = new Cell("", 2); // double score

        board.setBoardCell(0, 0, c0);
        board.setBoardCell(0, 1, c1);
        board.setBoardCell(0, 2, c2);
        board.setBoardCell(0, 3, c3);
        board.setBoardCell(0, 4, c4);


        ScoringSystem scorer = new ScoringSystem();
        int[][] pos = {{0,0},{0,1},{0,2},{0,3},{0,4}}; // creating 2d position array of new word
        Assertions.assertEquals(17, scorer.score(board, pos));

    }

}
