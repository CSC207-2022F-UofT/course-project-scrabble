package use_case_interfaces;

import entities.*;
import scrabble_dictionary.ScrabbleDictionary;

import java.util.List;

/**
 * This interface verifies and updates new words on the board.
 * @author Davit
 */
public interface PlaceWord { //interface that verifies and updates new words on the board
    //returns list of valid words from player's moves and updates the board
    public List<List<List<Integer>>> checkWord(Game game, ScrabbleDictionary scrabbleDictionary, GameBoard prevBoard);
}
