package GamesManager;

import java.util.ArrayList;

public class BoardManager {
    // list of coordinates and letters
    private ArrayList<MoveInfo> moves;

    public BoardManager(){
        moves = new ArrayList<>();
    }
    // function checks if individual letter placement is valid
    // returns boolean value
    public boolean checkLetter(int[] coordinates, String letter){
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
    public boolean checkWord(ArrayList<MoveInfo> moves){
        // call word and tile check functions to verify the new word
        // if true update board state and
        return true;
        // else
        // return false
    }
}
