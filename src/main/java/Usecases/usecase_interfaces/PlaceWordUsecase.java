package Usecases.usecase_interfaces;

import entities.*;
import Usecases.usecase_implementations.MoveInfo;
import scrabble_dictionary.ScrabbleDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface verifies and updates new words on the board.
 * @author Davit
 */
public interface PlaceWordUsecase { //interface that verifies and updates new words on the board
    //returns list of valid words from player's moves and updates the board
    public List<List<List<Integer>>> checkWord(Game game, ScrabbleDictionary scrabbleDictionary, GameBoard prevBoard);
}
