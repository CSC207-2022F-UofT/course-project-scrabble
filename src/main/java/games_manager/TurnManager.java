/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games_manager;

import use_case_interfaces.IncrementTurnUsecase;
import entities.Game;
/**
 *
 * @author jingw
 */
public class TurnManager implements IncrementTurnUsecase{
    @Override
    public void incrementTurn(Game game) {
        game.incrementTurn();
    }
}
