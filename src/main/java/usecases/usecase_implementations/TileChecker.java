package usecases.usecase_implementations;

import entities.GameBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;
import usecases.usecase_interfaces.PlacementCheckerUsecase;

/**
 * This class is responsible for checking the tiles to be a valid moves in blank spots or valid words.
 * @author Claire & Francisco
 */

public class TileChecker implements PlacementCheckerUsecase {

    /**
     * This method is responsible for validating a move and returning the list of words created by the move
     * @param move nested list of coordinates corresponding to the word being placed.
     * @return ArrayList<List<List<Integer>>> the coordinates of all the words created after placing move
     */
    public ArrayList<List<List<Integer>>> validateMove(ArrayList<List<Integer>> move, GameBoard board,
                                                       ScrabbleDictionary scrabbleDictionary, GameBoard prevBoard) { //call to other functions that will validate move
        ArrayList<List<List<Integer>>> falseResult = new ArrayList<>();
        if (!isConsecutive(move, board)) { //if tiles aren't consecutive, return false
            return falseResult;
        }
        if (!prevBoard.isEmpty() && !isTouching(move, prevBoard)) { //if tiles aren't touching already played tiles, return false
            return falseResult;
        }
        if (!scrabbleDictionary.inDictionary(wordParser((wordList(move, board)), board))) {
            return falseResult;
        }
        return wordList(move, board);
    }

    /**
     * This method is responsible for returning a boolean if the tiles had been placed in a blank spot
     * @param row  Integer representing the row of the board
     * @param column  Integer representing the column of the board
     * @param board  GameBoard entity to be searched
     * @return  Boolean that returns if the tile was placed in a valid spot
     */
    @Override
    public boolean isValid(int row, int column, GameBoard board) {
        if (!Objects.equals(board.getBoardCellValue(row, column), "-")) { // checks that no letters are already in that space
            return false;
        } else {
            return row <= 15 & column <= 15; //based on the default board size, 15 can be replaced with board.size or something
        }
    }

    /**
     * Checks whether all tiles in move are placed in a row or column
     * @param move nested list of coordinates corresponding to the word being placed.
     * @return boolean whether the word is placed in a row or column
     */
    @Override
    public boolean isConsecutive(ArrayList<List<Integer>> move, GameBoard board) {
        ArrayList<Integer> row = new ArrayList<>(); // a list of all the desired row coordinates
        ArrayList<Integer> column = new ArrayList<>(); // a list of all the desired column coordinates
        for (List<Integer> tiles : move) {
            row.add(tiles.get(0)); // adds all the desired row coordinates to the list
            column.add(tiles.get(1)); // adds all the desired column coordinates to the list
        }
        if (row.stream().distinct().count() == 1) { // if the tiles are all to be placed all in the same row
            return isRow(row.get(0), column, board);
        } else if (column.stream().distinct().count() == 1) { // if the tiles are all to be placed in the same column
            return isCol(column.get(0), row, board);
        } else { // if the tiles aren't in a line at all
            return false;
        }
    }

    /**
     * Checks whether all tiles in move are placed in a row i.e. no gaps
     * @param refNum referring to the row move is placed on 0-14
     * @param movelist the x values of the move
     * @param board the game board where move will be checked on
     * @return boolean whether the word is placed in a row
     */
    private boolean isRow (int refNum, ArrayList<Integer> movelist, GameBoard board) { // determines whether or not there are any gaps
        Collections.sort(movelist);
        for (int i = 0; i < movelist.toArray().length - 1; i++) {
            if (movelist.get(i + 1) != movelist.get(i) + 1) { // checks for non-sequential numbers
                if (board.getBoardCellValue(refNum, movelist.get(i) + 1).equals("-")) { // checks whether the skipped tiles are occupied
                    return false; // if the skipped tiles are not occupied, the move is invalid
                }
            }
        }
        return true;
    }

    /**
     * Checks whether all tiles in move are placed in a column i.e. no gaps
     * @param refNum referring to the column move is placed on 0-14
     * @param movelist the y values of the move
     * @param board the game board where move will be checked on
     * @return boolean whether the word is placed in a column
     */
    private boolean isCol (int refNum, ArrayList<Integer> movelist, GameBoard board) { // determines whether or not there are any gaps
        Collections.sort(movelist);
        for (int i = 0; i < movelist.toArray().length - 1; i++) {
            if (movelist.get(i + 1) != movelist.get(i) + 1) { // checks for non-sequential numbers
                if ("-".equals(board.getBoardCellValue(movelist.get(i) + 1, refNum))) { // checks whether the skipped tiles are occupied
                    return false; // if the skipped tiles are not occupied, the move is invalid
                }
            }
        }
        return true;
    }

    /**
     * Checks whether all tiles are touching each other
     * @param move nested list of the coordinates of move
     * @param board the game board where move will be checked on
     * @return boolean whether the word is touching other tiles
     */
    @Override
    public boolean isTouching(ArrayList<List<Integer>> move, GameBoard board) { // determines whether the desired tiles touch already placed tiles
        for (List<Integer> coordinates : move) {
            if (adjacentTile(coordinates.get(0), coordinates.get(1), board)) { // calls helper function
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are adjacent tiles given the row and column a tile is placed on
     * @param row row tile to be checked is placed on 0-14
     * @param column column tile to be checked is placed on
     * @param board the game board where move will be checked on
     * @return boolean whether the tile is adjacent
     */
    private boolean adjacentTile(int row, int column, GameBoard board) { // determines the adjacency for single tiles
        if (adjacentTileLeft(row, column, board)) { // checks for a horizontally adjacent tile
            return true;
        } else if (adjacentTileRight(row, column, board)) { // checks horizontally adjacent tile
            return true;
        } else // checks vertically adjacent tile
            // if no tiles are adjacent
            if (adjacentTileTop(row, column, board)) { // checks vertically adjacent tile
                return true;
            } else return adjacentTileBottom(row, column, board);
    }

    /**
     * Checks whether the tile has a tile adjacent to it on its left
     * @param row row tile to be checked is placed on 0-14
     * @param column column tile to be checked is placed on
     * @param board the game board where move will be checked on
     * @return boolean whether the tile is adjacent
     */
    private boolean adjacentTileLeft(int row, int column, GameBoard board){
        // checks for a horizontally adjacent tile
        if (column - 1 >= 0) {
            return !Objects.equals(board.getBoardCellValue(row, column - 1), "-");
        } else {
            return false;
        }
    }

    /**
     * Checks whether the tile has a tile adjacent to it on its right
     * @param row row tile to be checked is placed on 0-14
     * @param column column tile to be checked is placed on
     * @param board the game board where move will be checked on
     * @return boolean whether the tile is adjacent
     */
    private boolean adjacentTileRight(int row, int column, GameBoard board){
        // checks for a horizontally adjacent tile
        if (column + 1 <= 14) {
            return !Objects.equals(board.getBoardCellValue(row, column + 1), "-");
        } else {
            return false;
        }
    }

    /**
     * Checks whether the tile has a tile adjacent to it on top
     * @param row row tile to be checked is placed on 0-14
     * @param column column tile to be checked is placed on
     * @param board the game board where move will be checked on
     * @return boolean whether the tile is adjacent
     */
    private boolean adjacentTileTop(int row, int column, GameBoard board){
        // checks for a vertically adjacent tile
        if (row - 1 >= 0) {
            return !Objects.equals(board.getBoardCellValue(row - 1, column), "-");
        } else {
            return false;
        }
    }

    /**
     * Checks whether the tile has a tile directly below it
     * @param row row tile to be checked is placed on 0-14
     * @param column column tile to be checked is placed on
     * @param board the game board where move will be checked on
     * @return boolean whether the tile is adjacent
     */
    private boolean adjacentTileBottom(int row, int column, GameBoard board){
        // checks for a vertically adjacent tile
        if (row + 1 <= 14) {
            return !Objects.equals(board.getBoardCellValue(row + 1, column), "-");
        } else {
            return false;
        }
    }

    /**
     * A word parser function that returns a list of words that need to be checked
     * @param newword List of coordinates corresponding to a word needed to be checked
     * @param board the game board where move will parsec
     * @return ArrayList<List<List<Integer>>> A list of possible words after placing down newword
     */
    public ArrayList<List<List<Integer>>> wordList(ArrayList<List<Integer>> newword, GameBoard board){
        //a word parser function that returns a list of words that need to be checked
        ArrayList<List<List<Integer>>> words = new ArrayList<>();

        // check for vertical words
        for (List<Integer> tile : newword) {
            List<List<Integer>> wordstring = new ArrayList<>();
            int row = tile.get(0);
            int column = tile.get(1);
            List<Integer> cur = new ArrayList<>();
            cur.add(row);
            cur.add(column);
            wordstring.add(cur);
            while (adjacentTileTop(row, column, board) && (column == tile.get(1))) {
                if (!Objects.equals(board.getBoardCellValue(row - 1, column), "-")) { // checks for a top vertically adjacent tile
                    List<Integer> cord = new ArrayList<>();
                    cord.add(row - 1);
                    cord.add(column);
                    wordstring.add(0, cord);
                    row -= 1;
                }
            }
            int row1 = tile.get(0);
            int column1 = tile.get(1);
            while (adjacentTileBottom(row1, column1, board) && (column1 == tile.get(1))) {
                if (!Objects.equals(board.getBoardCellValue(row1 + 1, column1), "-")) { // checks for a vertically adjacent tile
                    List<Integer> cord = new ArrayList<>();
                    cord.add(row1 + 1);
                    cord.add(column1);
                    wordstring.add(cord);
                    row1 += 1;
                }
            }
            if (!words.contains(wordstring) && wordstring.size() > 1) {
                words.add(wordstring);
            }
        }
        // checks for horizontal words
        for (List<Integer> tile : newword) {
            List<List<Integer>> wordstring1 = new ArrayList<>();
            int row2 = tile.get(0);
            int column2 = tile.get(1);
            List<Integer> cur1 = new ArrayList<>();
            cur1.add(row2);
            cur1.add(column2);
            wordstring1.add(cur1);
            while (adjacentTileLeft(row2, column2, board) && (row2 == tile.get(0))) {
                if (!Objects.equals(board.getBoardCellValue(row2, column2 - 1), "-")) { // checks horizontal adjacent tile
                    List<Integer> cord = new ArrayList<>();
                    cord.add(row2);
                    cord.add(column2 - 1);
                    wordstring1.add(0, cord);
                    column2 -= 1;
                }
            }
            int row3 = tile.get(0);
            int column3 = tile.get(1);
            while (adjacentTileRight(row3, column3, board) && (row3 == tile.get(0))) {
                if (!Objects.equals(board.getBoardCellValue(row3, column3 + 1), "-")) { // checks horizontal adjacent tile
                    List<Integer> cord = new ArrayList<>();
                    cord.add(row3);
                    cord.add(column3 + 1);
                    wordstring1.add(cord);
                    column3 += 1;
                }
            }
            if (!words.contains(wordstring1) && wordstring1.size() > 1) {
                words.add(wordstring1);
            }
        }
        return words;
    }

    /**
     * This method is responsible for determining the words created given the tile coordinates
     * @param move nested list of words corresponding to the coordinates of all letters.
     * @return List<String> A list of words created
     */
    private static List<String> wordParser(ArrayList<List<List<Integer>>> move, GameBoard board) { //determines words from tile coordinates
        List<String> wordlist = new ArrayList<>(); //the list of all words made from a move
        for (List<List<Integer>> word : move) { //for each separate word in the list
            StringBuilder newword = new StringBuilder();
            for (List<Integer> letter: word) { //for each letter in the word
                newword.append(board.getBoardCellValue(letter.get(0), letter.get(1))); //appends the letter to the current string
            }
            wordlist.add(newword.toString()); //adds the string to the wordlist
        }
        return wordlist;
    }


}
