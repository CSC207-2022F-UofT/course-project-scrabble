package UsecaseInterfaces;

import entities.Game;
import games_manager.MoveInfo;

import java.util.ArrayList;

public interface PlaceWord { //interface that verifies and updates new words on the board
    //returns true if word is valid, updates the board
    public boolean checkWord(Game game);
}
