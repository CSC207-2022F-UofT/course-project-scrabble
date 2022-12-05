package entities;


import java.io.Serializable;

/**
 * This class represents the GameBoard entity and is responsible for handling GameBoard actions, where each holds value,
 * score and multiplier.
 * @author Jazli & Umair & Davit
 */

public class GameBoard implements Serializable {
    private final int DEFAULT_SIZE = 15;
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
            {3,1,1,2,1,1,1,3,1,1,1,2,1,1,3}}; // two-dimensional array of multiplier values for the board
    
    private Cell[][] board; // two-dimensional array of cells for the board

    /**
     * This method is responsible for being the constructor of the GameBoard class with no parameters
     */
    public GameBoard() {
        board = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];

        for (int i=0; i < DEFAULT_SIZE; i++) {
            for (int j=0; j < DEFAULT_SIZE; j++) {
                board[i][j] = new Cell ("-", TILE_MULTIPLIERS[i][j]);
            }
        }

    }

    /**
     * This method is responsible for being the constructor of the Cell class passed with previous cells
     */
    public GameBoard(Cell[][] loaded_cells) {
        board = loaded_cells;
    }


    /**
     * This method is responsible for returning the cell from the board
     * @param row This is an integer representing the row
     * @param column This is an integer representing the column
     * @return Returns the cell itself from the board.
     */
    public Cell getBoardCell(int row, int column) {
        return this.board[row][column];
    }

    /**
     * This method is responsible for returning the cell value from the board
     * @param row This is an integer representing the row
     * @param column This is an integer representing the column
     * @return Return the cell value of the cell of the board.
     */
    public String getBoardCellValue(int row, int column) {
        return this.board[row][column].getValue();
    }
    /**
     * This method is responsible for returning the board itself.
     * @return A GameBoard entity that is returned
     */
    public Cell[][] getBoard() {
        return board;
    }

    /**
     * This method is responsible setting the current GameBoard to the passed board.
     * @param board An array of cells representing the board.
     */
    public void setBoard(Cell[][] board){ // set board with a given array of cells
        for (int i=0; i < DEFAULT_SIZE; i++) {
            for (int j=0; j < DEFAULT_SIZE; j++) {
                this.board[i][j].setValue(board[i][j].getValue());
            }
        }
    }

    /**
     * This method is responsible for printing the board values in the console.
     */
    public void printBoard() {
        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j].getValue()+" ");
            }
            System.out.println();
        }
    }
    /**
     * This method is responsible for returning a boolean to check if the current board has all empty cells
     * with no values.
     * @return Return a boolean representing if the board was empty or not.
     */
    public boolean isEmpty() {
        for (int i=0; i < DEFAULT_SIZE; i++) {
            for (int j=0; j < DEFAULT_SIZE; j++) {
                String value = this.board[i][j].getValue();
                if (!value.equals("-")){
                    return false;
                }
            }
        }
        return true;
    }


}
    
    
