package games_manager;

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
}
