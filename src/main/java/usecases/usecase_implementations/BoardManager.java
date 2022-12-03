package usecases.usecase_implementations;

import entities.Cell;
import entities.Game;
import entities.GameBoard;

import java.util.ArrayList;
import java.util.List;
import usecases.usecase_interfaces.PlaceTileUsecase;
import usecases.usecase_interfaces.PlaceWordUsecase;
import usecases.usecase_interfaces.ResetMoveUsecase;

/**
 * This class is responsible for managing the GameBoard entity
 * @author Davit
 */
public class BoardManager implements PlaceTileUsecase, PlaceWordUsecase, ResetMoveUsecase {
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
        if (moves.isEmpty()) {
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
    public List<List<List<Integer>>> checkWord(Game game, ScrabbleDictionary scrabbleDictionary, GameBoard prevBoard){
        ArrayList<List<Integer>> move_list = new ArrayList<>();
        createListOfCoordinates(move_list);
        TileChecker validate_word = new TileChecker();
        if (prevBoard.isEmpty()) { // check if it's first turn of thr game
            if (checkFirstTurnCondition()) { // check if the word is on center of board
                ArrayList<List<List<Integer>>> first_word_list = validate_word.validateMove(move_list, game.getGameBoard(), scrabbleDictionary, prevBoard);
                if (first_word_list.isEmpty()) {
                    resetMoves(game); // change board back to previous state if no valid words.
                }
                return first_word_list; // return list of coordinates of new word on board
            }
            else {
                return new ArrayList<>(); // return empty ArrayList if word not on the center
            }
        }
        else {
            ArrayList<List<List<Integer>>> word_list = validate_word.validateMove(move_list, game.getGameBoard(), scrabbleDictionary, prevBoard);
            if (word_list.isEmpty()) {
                resetMoves(game); // change board back to previous state if no valid words.
            }
            return word_list; // return list of valid words that can be made from the moves
        }
    }

    /**
     * This method resets the moves placed on the board during the turn.
     * @param game The game object with the board.
     */
    @Override
    public void resetMoves(Game game){
        game.getGameBoard().setBoard(previous_board.getBoard()); // change board back to previous state.

        game.getGameBoard().printBoard();
    }

    @Override
    public void clearMoves(){
        moves.clear(); //clears moves in the moves list
    }

    /**
     * This helper method of BoardManager updates the board with the new moves.
     * @param board The board object.
     */
    private void updateBoardState(GameBoard board){
        for (MoveInfo move : moves) { // iterate through moves list and change the values on the board.
            board.getBoard()[move.getY()][move.getX()].setValue(move.getLetter());
        }
    }

    public GameBoard getPrevBoard(){
        return this.previous_board;
    }

    /**
     * This helper method of BoardManager saves the cells of the board in a new board object.
     * @param board The board object.
     * @return a board object with all the cells of the board parameter.
     */
    private GameBoard savePreviousBoardState(GameBoard board){
        GameBoard newBoard = new GameBoard();
        for (int i=0; i < board.getBoard().length; i++) {
            for (int j=0; j < board.getBoard().length; j++) {
                newBoard.getBoard()[i][j].setValue(board.getBoardCellValue(i, j));
            }
        }

        return newBoard; // return new board with cells from board input.
    }

    /**
     * This helper method of BoardManager verifies the first turn condition.
     * @return true if it's the first move and word is on center cell, if not on center cell return false.
     */
    private boolean checkFirstTurnCondition(){
        // if it's the first turn check if the word is on the center cell
        ArrayList<Boolean> verifier_array = new ArrayList<>();
        for (MoveInfo move : moves) { // iterate through new moves and check if one of the coordinates are in the center.
            if (move.getX() == 7 & move.getY() == 7){
                verifier_array.add(true); // add true to list if move is in the center
            }
            else {
                verifier_array.add(false); // add false to list if move is not in the center
            }
        }
        return verifier_array.contains(true); // return true if there is a true value in the list, otherwise false
    }

    /**
     * This helper method of BoardManager creates a two-dimensional ArrayList of the coordinates from the moves List.
     * @param move_list a two-dimensional ArrayList of coordinates.
     */
    private void createListOfCoordinates(ArrayList<List<Integer>> move_list){
        for (MoveInfo move : moves) { // iterate through moves objects and add coordinates to new list move_list
            ArrayList<Integer> coordinates = new ArrayList<>();
            coordinates.add(move.getY());
            coordinates.add(move.getX());
            move_list.add(new ArrayList<>(coordinates));
        }
    }

    public static Cell GetCell(int row, int column, GameBoard board) {
        return board.getBoard()[row][column];
    }
    public static String GetCellValue(Cell letter) {
        return letter.getValue();
    }

    public static int GetCellScore(Cell cell) {
        return cell.getScore();
    }

    public static int GetCellMultiplier(Cell cell) {
        return cell.getMultiplier();
    }

    public static void SetBoardCell(int row, int column, Cell letter, GameBoard board){
        int multiplier = board.getBoard()[row][column].getMultiplier();
        letter.setMultiplier(multiplier); // The letter cell takes on the multiplier value of the board space
        board.getBoard()[row][column] = letter; // Set the space on the board to the letter cell
    }
    public static void SetCellScore(Cell letter, int score) {
        letter.setScore(score);
    }

    public ArrayList<MoveInfo> getMoves(){
        return this.moves;
    }
}
