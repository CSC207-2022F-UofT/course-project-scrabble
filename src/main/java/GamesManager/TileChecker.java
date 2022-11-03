package GamesManager;

import entities.GameBoard;

import java.util.Objects;

public class TileChecker implements PlacementChecker {

    private boolean collisionChecker(int row, int column, GameBoard board) {
        return Objects.equals(board.getBoardCellValue(row, column), "-");
    }

    private boolean inBoundary(int row, int column, GameBoard board) { // need board size to make this better
        return row <= 15 & column <= 15; //based on the default board size, 15 can be replaced with board.size or something
    }
    @Override
    public boolean isValid(int row, int column, GameBoard board) {
        return collisionChecker(row, column, board) & inBoundary(row, column, board);
    }
}
