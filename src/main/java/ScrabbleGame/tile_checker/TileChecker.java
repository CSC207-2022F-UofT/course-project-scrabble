package ScrabbleGame.tile_checker;

import UsecaseInterfaces.PlacementChecker;
import entities.GameBoard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import static scrabble_dictionary.ScrabbleDictionary.inDictionary;

public class TileChecker implements PlacementChecker {
    
    public ArrayList<List<List<Integer>>> validateMove(ArrayList<List<Integer>> move, GameBoard board) { //call to other functions that will validate move
        ArrayList<List<List<Integer>>> falseResult = new ArrayList<List<List<Integer>>>();
        if (!isConsecutive(move, board)) { //if tiles aren't consecutive, return false
            return falseResult;
        }
        if (!isTouching(move, board)) { //if tiles aren't touching already played tiles, return false
            return falseResult;
        }
        //else { //wordList must be changed to implement this
            //return wordList(move, board);
        //}
        return falseResult; //temporary, once wordlist is changed we can change this
    }
    @Override
    public boolean isValid(int row, int column, GameBoard board) {
        if (!Objects.equals(board.getBoardCellValue(row, column), "-")) { // checks that no letters are already in that space
            return false;
        } else { // need board size to make this better
            return row <= 15 & column <= 15; //based on the default board size, 15 can be replaced with board.size or something
        }
    }
    @Override
    public boolean isConsecutive(ArrayList<List<Integer>> move, GameBoard board) { //hopefully a list of ordered row/column pairs.
        ArrayList<Integer> row = new ArrayList<>(); // a list of all the desired row coordinates
        ArrayList<Integer> column = new ArrayList<>(); // a list of all the desired column coordinates
        for (List<Integer> tiles : move) {
            row.add(tiles.get(0)); // adds all the desired row coordinates to the list
            column.add(tiles.get(1)); // adds all the desired column coordinates to the list
        }
        if (row.stream().distinct().count() == 1) { // if the tiles are all to be placed all in the same row
            return isLine(row.get(0), column, board);
        } else if (column.stream().distinct().count() == 1) { // if the tiles are all to be placed in the same column
            return isLine(column.get(0), row, board);
        } else { // if the tiles aren't in a line at all
            return false;
        }
    }
    private boolean isLine (int refNum, ArrayList<Integer> movelist, GameBoard board) { // determines whether or not there are any gaps
        // TODO: sort the moveList
        for (int i = 0; i < movelist.toArray().length - 1; i++) {
            if (movelist.get(i + 1) != movelist.get(i) + 1) { // checks for non-sequential numbers
                if (board.getBoardCellValue(refNum, i + 1) == "-") { // checks whether the skipped tiles are occupied
                    return false; // if the skipped tiles are not occupied, the move is invalid
                }
            }
        }
        return true;
    }
    @Override
    public boolean isTouching(ArrayList<List<Integer>> move, GameBoard board) { // determines whether the desired tiles touch already placed tiles
        // TODO: add something here to tell whether or not it's the first move
        for (List<Integer> coordinates : move) {
            if (adjacentTile(coordinates.get(0), coordinates.get(1), board)) { // calls helper function
                return true;
            }
        }
        return false;
    }

    private boolean adjacentTile(int row, int column, GameBoard board) { // determines the adjacency for single tiles
        // TODO: somehow determine whether tile is on the edge of the board
        if (board.getBoardCellValue(row + 1, column) != "-") { // checks for a horizontally adjacent tile
            return true;
        } else if (board.getBoardCellValue(row - 1, column) != "-") { // checks horizontally adjacent tile
            return true;
        } else if (board.getBoardCellValue(row, column + 1) != "-") { // checks vertically adjacent tile
            return true;
        } else if (board.getBoardCellValue(row, column - 1) != "-") { // checks vertically adjacent tile
            return true;
        } else { // if no tiles are adjacent
            return false;
        }
    }

    private boolean adjacentTileLeft(int row, int column, GameBoard board){
        // checks for a horizontally adjacent tile
        return !Objects.equals(board.getBoardCellValue(row, column - 1), "-");
    }
    private boolean adjacentTileRight(int row, int column, GameBoard board){
        // checks for a horizontally adjacent tile
        return !Objects.equals(board.getBoardCellValue(row, column + 1), "-");
    }
    private boolean adjacentTileTop(int row, int column, GameBoard board){
        // checks for a vertically adjacent tile
        return !Objects.equals(board.getBoardCellValue(row - 1, column), "-");
    }
    private boolean adjacentTileBottom(int row, int column, GameBoard board){
        // checks for a vertically adjacent tile
        return !Objects.equals(board.getBoardCellValue(row + 1, column), "-");
    }

    public ArrayList<String> wordList(ArrayList<List<Integer>> newword, GameBoard board){
        //a word parser function that returns a list of words that need to be checked
        ArrayList<String> words = new ArrayList<String>();

        // check for vertical words
        for (List<Integer> tile : newword) {
            StringBuilder wordstring = new StringBuilder();
            int row = tile.get(0);
            int column = tile.get(1);
            while (adjacentTileTop(row, column, board) && (column == tile.get(1))) {
                if (!Objects.equals(board.getBoardCellValue(row - 1, column), "-")) { // checks for a top vertically adjacent tile
                    wordstring.insert(0, board.getBoardCellValue(row - 1, column));
                    row -= 1;
                }
            }
            int row1 = tile.get(0);
            int column1 = tile.get(1);
            while (adjacentTileBottom(row1, column, board) && (column1 == tile.get(1))) {
                if (!Objects.equals(board.getBoardCellValue(row1 + 1, column1), "-")) { // checks for a vertically adjacent tile
                    wordstring.append(board.getBoardCellValue(row1 + 1, column1));
                    row += 1;
                }
            }
            if (!words.contains(wordstring.toString())) {
                words.add(wordstring.toString());
            }
        }
        // checks for horizontal words
        for (List<Integer> tile : newword) {
            StringBuilder wordstring = new StringBuilder();
            int row = tile.get(0);
            int column = tile.get(1);
            while (adjacentTileLeft(row, column, board) && (row == tile.get(0))) {
                if (!Objects.equals(board.getBoardCellValue(row, column - 1), "-")) { // checks horizontal adjacent tile
                    wordstring.append(board.getBoardCellValue(row, column - 1));
                    column -= 1;
                }
            }
            int row1 = tile.get(0);
            int column1 = tile.get(1);
            while (adjacentTileRight(row1, column, board) && (row1 == tile.get(1))) {
                if (!Objects.equals(board.getBoardCellValue(row1, column1 + 1), "-")) { // checks horizontal adjacent tile
                    wordstring.insert(0, board.getBoardCellValue(row1, column1 + 1));
                    column += 1;
                }
            }
            if (!words.contains(wordstring.toString())) {
                words.add(wordstring.toString());
            }
        }
        return words;
    }
}
