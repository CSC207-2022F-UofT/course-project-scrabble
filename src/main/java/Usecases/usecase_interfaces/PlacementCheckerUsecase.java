package Usecases.usecase_interfaces;

import entities.GameBoard;
import java.util.ArrayList;
import java.util.List;

public interface PlacementCheckerUsecase { //interface that checks whether individual tiles are in valid locations
    boolean isValid(int row, int column, GameBoard board); //checks whether individual tiles are valid
    boolean isConsecutive(ArrayList<List<Integer>> move, GameBoard board); //checks if all tiles are played in the same word
    boolean isTouching(ArrayList<List<Integer>> move, GameBoard board); //checks if the new word is touching the previous tiles
}

