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

/**
 * This class is responsible for managing the GameBoard entity
 * @author Davit
 */
public class BoardManager implements PlaceTile, PlaceWord, ResetMove {
    private ArrayList<MoveInfo> moves; // list of coordinates and letters
    private GameBoard previous_board; // saved previous board state
    public BoardManager(){
        moves = new ArrayList<>();
        previous_board = new GameBoard();
    }

    /**
     * This method is responsible for verifying a letter that has been placed on the board.
     * @param coordinates the int array of coordinates for the new letter.
     * @param letter the string value of the letter.
     * @param game the game object with the board.
     * @return true if letter can be placed and false if it can't.
     */
    @Override
    public boolean checkLetter(int[] coordinates, String letter, Game game){
        TileChecker validate_move = new TileChecker();
        if (moves.size() == 0) {
            previous_board = savePreviousBoardState(game.getGameBoard()); // save the previous board state if first move
        }
        if (validate_move.isValid(coordinates[0], coordinates[1], game.getGameBoard())){ // check if move is valid
            MoveInfo move = new MoveInfo(coordinates, letter);
            moves.add(move); // adds player's move to list of moves
            updateBoardState(game.getGameBoard()); // updates board with new moves
            return true;
        }
        else { // if invalid move return false
            return false;
        }
    }

    /**
     * This method is responsible for verifying a word that has been placed on the board.
     * @param game The game object with the board.
     * @return the list of valid words that could be made from the player's moves.
     */
    @Override
    public ArrayList<List<List<Integer>>> checkWord(Game game){
        if (checkFirstTurnCondition(game)){ // checks if one of the letters are on the center cell for the first word
            ArrayList<List<Integer>> move_list = new ArrayList<List<Integer>>();
            createListOfCoordinates(move_list);
            TileChecker validate_word = new TileChecker();
            ArrayList<List<List<Integer>>> word_list = validate_word.validateMove(move_list, game.getGameBoard());
            if (word_list.size() == 0) {
                resetMoves(game); // change board back to previous state if no valid words.
            }
            moves.clear(); // clear moves for new turn
            return word_list; // return list of valid words that can be made from the moves
        }
        else {
            return new ArrayList<>(); // return empty List if first turn condition fails
        }
    }

    /**
     * This method resets the moves placed on the board during the turn.
     * @param game The game object with the board.
     */
    @Override
    public void resetMoves(Game game){
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
    private boolean checkFirstTurnCondition(Game game){
        /*
        This function returns a boolean value of true if the ArrayList of moves contains the coordinate [7,7]
        and it returns false if t does not.
         */
        // turn counter shows it's the first turn then check if the word is on center.
        if (game.getTurn() == 0){
            ArrayList<Boolean> verifier_array = new ArrayList<Boolean>();
            for (MoveInfo move : moves) {
                if (move.getX() == 7 & move.getY() == 7){
                    verifier_array.add(true);
                }
                else {
                    verifier_array.add(false);
                }
            }
            return verifier_array.contains(true);
        }
        else {
            return true;
        }
    }
    private void createListOfCoordinates(ArrayList<List<Integer>> move_list){
        /*
        This function iterates through moves and adds the coordinates to the arraylist input.
         */
        for (MoveInfo move : moves) {
            ArrayList<Integer> coordinates = new ArrayList<>();
            coordinates.add(move.getY());
            coordinates.add(move.getX());
            move_list.add(new ArrayList<Integer>(coordinates));
        }
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
