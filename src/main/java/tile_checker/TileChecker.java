package tile_checker;

import entities.GameBoard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class TileChecker implements PlacementChecker {

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
    
    public ArrayList<String> wordList(){
        //a word parser function that returns a list of words that need to be checked
        ArrayList<String> words = new ArrayList<String>();
        
        for (// list of tiles that the players has played){
            wordstring = ""
            row = // tile.row
            column = // tile.colum
            while (adjacentTile(int row, int column, GameBoard board)){
                if (board.getBoardCellValue(row + 1, column) != "-") { // checks for a horizontally adjacent tile
                    wordstring += board.getBoardCellValue(row + 1, column);
                } else if (board.getBoardCellValue(row - 1, column) != "-") { // checks horizontally adjacent tile
                    wordstring = board.getBoardCellValue(row - 1, column) + wordstring;
                } else if (board.getBoardCellValue(row, column + 1) != "-") { // checks vertically adjacent tile
                    wordstring += board.getBoardCellValue(row, column + 1);
                } else if (board.getBoardCellValue(row, column - 1) != "-") { // checks vertically adjacent tile
                    wordstring = board.getBoardCellValue(row, column - 1) + wordstring;
                } ;
            }
                
                }
            
   
    //TODO: Write the final TileChecker function that calls all of these functions to return true or false.
}
