package games_manager;

import entities.GameBoard;

import java.util.ArrayList;

public interface BoardManagement { //interface that verifies and updates moves on the board
    public boolean checkLetter(int[] coordinates, String letter, GameBoard board); //returns true if letter is valid
    public boolean checkWord(ArrayList<MoveInfo> moves, GameBoard board); //returns true if word is valid
    public void updateBoardState(GameBoard board); //updates board after valid turn
}
