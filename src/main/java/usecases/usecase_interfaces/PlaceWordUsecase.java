package usecases.usecase_interfaces;

import entities.*;
import usecases.usecase_implementations.ScrabbleDictionary;

import java.util.List;

/**
 * This interface verifies and updates new words on the board.
 * @author Davit
 */
public interface PlaceWordUsecase { //interface that verifies and updates new words on the board
    //returns list of valid words from player's moves and updates the board
    public List<List<List<Integer>>> checkWord(Game game, ScrabbleDictionary scrabbleDictionary, GameBoard prevBoard);
}
