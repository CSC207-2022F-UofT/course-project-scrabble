package TileChecker;

import entities.GameBoard;
import java.util.Objects;

public class TileChecker implements PlacementChecker {

    @Override
    public boolean isValid(int row, int column, GameBoard board) {
        if (!Objects.equals(board.getBoardCellValue(row, column), "-")) { // checks that no letters are already in that space
            return false;
        } else { // need board size to make this better
            return row <= 15 & column <= 15; //based on the default board size, 15 can be replaced with board.size or something
        }
    }
}
