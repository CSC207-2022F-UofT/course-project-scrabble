package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.BoardManager;

public class GameBoardTest {
    private static final int[][] TILE_MULTIPLIERS = new int[][]
    {{3,1,1,2,1,1,1,3,1,1,1,2,1,1,3},
        {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
        {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
        {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
        {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
        {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
        {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
        {3,1,1,2,1,1,1,1,1,1,1,2,1,1,3},
        {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
        {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
        {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
        {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
        {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
        {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
        {3,1,1,2,1,1,1,3,1,1,1,2,1,1,3}};

    /**
     * Tests setBoard by comparing setBoard with a cells with letter "A" in row 0, 0
     * and also a GameBoard cell with letter "A" into row column 0, 0 directly inserted.
     */
    @Test
    public void setBoardTest(){
        GameBoard gb1 = new GameBoard();
        Cell cell = new Cell("A", 4, 3);
        BoardManager.SetBoardCell(0, 0, cell, gb1);

        GameBoard gb2 = new GameBoard();
        Cell[][] cells = new Cell[15][15];
        for (int i=0; i < 15; i++) {
            for (int j=0; j < 15; j++) {
                cells[i][j] = new Cell ("-", TILE_MULTIPLIERS[i][j]);
            }
        }
        cells[0][0] = cell;
        gb2.setBoard(cells);

        Assertions.assertEquals(gb1.getBoardCellValue(0, 0), gb2.getBoardCellValue(0, 0));
    }


    /**
     * Tests getBoardCellValue by comparing with a String value of "A"
     */
    @Test
    public void getBoardCellValueTest(){
        GameBoard gb = new GameBoard();
        Cell cell = new Cell("A", 4, 3);
        BoardManager.SetBoardCell(0, 0, cell, gb);

        Assertions.assertEquals(gb.getBoardCellValue(0, 0), "A");

    }
    /**
     * Tests getBoardCell by comparing with a Cell value
     */
    @Test
    public void getBoardCellTest(){
        GameBoard gb = new GameBoard();
        Cell cell = new Cell("A", 4, 3);
        BoardManager.SetBoardCell(0, 0, cell, gb);

        Assertions.assertEquals(gb.getBoardCell(0, 0), cell);

    }

    /**
     * Tests isEmpty by asserting that GameBoard gb.isEmpty() is true.
     */
    @Test
    public void isEmptyTest(){
        GameBoard gb = new GameBoard();
        Assertions.assertTrue(gb.isEmpty());

    }
}
