package games_manager;

import entities.Cell;
import entities.GameBoard;

import java.util.ArrayList;

public class BoardManager implements BoardManagement{
    // list of coordinates and letters
    private ArrayList<MoveInfo> moves;

    public BoardManager(){
        moves = new ArrayList<>();
    }
    // function checks if individual letter placement is valid
    // returns boolean value
    @Override
    public boolean checkLetter(int[] coordinates, String letter, GameBoard board){
        // access tile check method to check if the move is valid
        // if the move is valid
        MoveInfo move = new MoveInfo(coordinates, letter);
        // update board state
        moves.add(move);
        return true;
        // else
        // return false
    }
    // function checks if word is valid english word
    // returns boolean value
    @Override
    public boolean checkWord(ArrayList<MoveInfo> moves, GameBoard board){
        // call word and tile check functions to verify the new word
        // if true update board state and
        return true;
        // else
        // return false
    }
    // update the board with the new moves from moves arraylist
    @Override
    public void updateBoardState(GameBoard board){
        for (MoveInfo move : moves) {
            board.getBoard()[move.getY()][move.getX()].setValue(move.getLetter());
        }
        moves.clear();
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

    public static void boardManagerSetCellValue(Cell letter, String value){letter.setValue(value);}

    public static void boardManagerSetCellScore(Cell letter, int score) {
        letter.setScore(score);
    }
}
