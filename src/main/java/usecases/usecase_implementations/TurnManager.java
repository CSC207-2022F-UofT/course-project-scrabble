/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usecases.usecase_implementations;

import usecases.usecase_interfaces.IncrementTurnUsecase;
import entities.Game;
/**
 * This class is responsible for updating the turn of the game by incrementing it by 1.
 * @author jingw
 */


public class TurnManager implements IncrementTurnUsecase{
    
    
    /**
     * This method is responsible for updating the turn counter of a specific game
     * @param game The game entity to be updated
     */
    @Override
    public void incrementTurn(Game game) {
        game.incrementTurn();
    }
}
