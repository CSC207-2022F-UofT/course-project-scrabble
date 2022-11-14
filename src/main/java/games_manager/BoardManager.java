package games_manager;

import entities.Cell;
import entities.GameBoard;
import tile_checker.TileChecker;

import java.util.ArrayList;
import java.util.List;

public class BoardManager implements BoardManagement{
    // list of coordinates and letters
    private ArrayList<MoveInfo> moves;
    private GameBoard previous_board;
    public BoardManager(){
        moves = new ArrayList<>();
        previous_board = new GameBoard();
    }
    // function checks if individual letter placement is valid
    // returns boolean value
    @Override
    public boolean checkLetter(int[] coordinates, String letter, GameBoard board, boolean first_move){
        TileChecker validate_move = new TileChecker();
        if (first_move) {
            previous_board = savePreviousBoardState(board);
        }
        if (validate_move.isValid(coordinates[0], coordinates[1], board)){
            MoveInfo move = new MoveInfo(coordinates, letter);
            moves.add(move);
            updateBoardState(board);
            return true;
        }
        else {
            return false;
        }
    }
    // function checks if word is valid english word
    // returns boolean value
    @Override
    public boolean checkWord(ArrayList<MoveInfo> moves, GameBoard board){
        ArrayList<List<Integer>> move_list = new ArrayList<List<Integer>>();
        for (MoveInfo move : moves) {
            ArrayList<Integer> coordinates = new ArrayList<>();
            coordinates.add(move.getY());
            coordinates.add(move.getX());
            move_list.add(new ArrayList<Integer>(coordinates));
        }
        TileChecker validate_word = new TileChecker();
        if (validate_word.validateMove(move_list, board)){
            return true;
        }
        else {
            board.setBoard(previous_board.getBoard());
            return false;
        }
    }
    // update the board with the new moves from moves arraylist
    @Override
    public void updateBoardState(GameBoard board){
        for (MoveInfo move : moves) {
            board.getBoard()[move.getY()][move.getX()].setValue(move.getLetter());
        }
        moves.clear();
    }
    @Override
    public GameBoard savePreviousBoardState(GameBoard board){
        Cell[][] all_cells = board.getBoard();
        return new GameBoard(all_cells);
    }

    public static Cell boardManagerGetCell(int row, int column, GameBoard board) {
        return board.getBoard()[row][column];
    }
    public static String boardManagerGetCellValue(int row, int column, GameBoard board) {
        return board.getBoard()[row][column].getValue();
    }
    public static String boardManagerGetCellValue(Cell letter) {
        return letter.getValue();
    }
    public static int boardManagerGetCellScore(int row, int column, GameBoard board) {
        return board.getBoard()[row][column].getScore();
    }
    public static int boardManagerGetCellScore(Cell cell) {
        return cell.getScore();
    }
    public static int boardManagerGetCellMultiplier(int row, int column, GameBoard board) {
        return board.getBoard()[row][column].getMultiplier();
    }
    public static int boardManagerGetCellMultiplier(Cell cell) {
        return cell.getMultiplier();
    }

    public static Cell[][] boardManagerGetBoard(GameBoard board) {
        return board.getBoard();
    }
    public static void boardManagerSetBoardCell(int row, int column, Cell letter, GameBoard board){
        int multiplier = board.getBoard()[row][column].getMultiplier();
        letter.setMultiplier(multiplier); // The letter cell takes on the multiplier value of the board space
        board.getBoard()[row][column] = letter; // Set the space on the board to the letter cell
    }

    public static void boardManagerSetCellScore(Cell letter, int score) {
        letter.setScore(score);
    }
}
