package games_manager;

import UsecaseInterfaces.PlaceTile;
import UsecaseInterfaces.PlaceWord;
import UsecaseInterfaces.ResetMove;
import entities.Cell;
import entities.Game;
import entities.GameBoard;
import ScrabbleGame.tile_checker.TileChecker;

import java.util.ArrayList;
import java.util.List;

public class BoardManager implements PlaceTile, PlaceWord, ResetMove {
    private ArrayList<MoveInfo> moves; // list of coordinates and letters
    private GameBoard previous_board; // saved previous board state
    public BoardManager(){
        moves = new ArrayList<>();
        previous_board = new GameBoard();
    }
    @Override
    public boolean checkLetter(int[] coordinates, String letter, Game game){
        /*
        This function return true if each individual letter placement by the player is valid and
        updates the board state. Otherwise, this function returns false and does not update board state.
         */
        TileChecker validate_move = new TileChecker();
        if (moves.size() == 0) {
            previous_board = savePreviousBoardState(game.getGameBoard()); // save the previous board state if first move
        }
        if (validate_move.isValid(coordinates[0], coordinates[1], game.getGameBoard())){
            MoveInfo move = new MoveInfo(coordinates, letter);
            moves.add(move); // adds player's move to list of moves
            updateBoardState(game.getGameBoard()); //updates board with new moves
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean checkWord(Game game){
        /*
        This function return true if the player's word is a valid english word. Otherwise, this function
        returns false and returns board state to the previous state.
         */
        ArrayList<List<Integer>> move_list = new ArrayList<List<Integer>>();
        for (MoveInfo move : moves) { // iterating through moves and placing the coordinates in arraylists.
            ArrayList<Integer> coordinates = new ArrayList<>();
            coordinates.add(move.getY());
            coordinates.add(move.getX());
            move_list.add(new ArrayList<Integer>(coordinates));
        }
        TileChecker validate_word = new TileChecker();
        if (validate_word.validateMove(move_list, game.getGameBoard())){
            moves.clear(); // clear moves for new turn
            return true; // return true if word is valid english word.
        }
        else {
            resetMoves(game); // change board back to previous state.
            moves.clear(); // clear moves to try again
            return false;
        }
    }
    @Override
    public void resetMoves(Game game){
        /*
        This function resets the moves on the board if played changes their mind.
         */
        game.getGameBoard().setBoard(previous_board.getBoard()); // change board back to previous state.
    }
    private void updateBoardState(GameBoard board){
        /*
        This function updates the board with the new moves from moves arraylist
         */
        for (MoveInfo move : moves) {
            board.getBoard()[move.getY()][move.getX()].setValue(move.getLetter());
        }
    }
    private GameBoard savePreviousBoardState(GameBoard board){
        /*
        This function saves the previous board state before a new move is played.
        Returns new GameBoard with the cells from board parameter.
         */
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
    public static void boardManagerSetCellValue(Cell letter, String value){ letter.setValue(value);}
}
