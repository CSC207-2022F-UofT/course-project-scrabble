package entities;



public class GameBoard {
    private final int DEFAULT_SIZE = 15;
    private final int[][] TILE_MULTIPLIERS = new int[0][0]; 
    
    private Cell[][] board;
    
    public GameBoard() {
        board = new Cell[DEFAULT_SIZE][DEFAULT_SIZE];
        
        for (int i=0; i < DEFAULT_SIZE; i++) {
            for (int j=0; j < DEFAULT_SIZE; j++) {
                board[i][j] = new Cell ("-", 1); //TODO add multipliers
            }
        }
    }  
        
    public GameBoard(Cell[][] loaded_cells) {
        board = loaded_cells;
    }
    
    
    
    
    
    public Cell getBoardCell(int row, int column) {
        return this.board[row][column];
    }
    public String getBoardCellValue(int row, int column) {
        return this.board[row][column].getValue();
    }
    public Cell[][] getBoard() {
        return board;
    }
    public void setBoardCell(int row, int column, Cell letter){
        int multiplier = this.board[row][column].getMultiplier();
        letter.setMultiplier(multiplier); // The letter cell takes on the multiplier value of the board space
        this.board[row][column] = letter; // Set the space on the board to the letter cell
    }
        
        
        
        
}
    
    
