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
        return this.board[column][row];
    }
    public String getBoardCellValue(int row, int column) {
        return this.board[column][row].getValue();
    }
    public Cell[][] getBoard() {
        return board;
    }
    public void setBoardCell(int row, int column, String value){
        this.board[column][row].setValue(value);
    }
        
        
        
        
}
    
    
