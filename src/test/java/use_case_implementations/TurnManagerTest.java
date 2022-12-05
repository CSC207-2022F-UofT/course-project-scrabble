/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package use_case_implementations;

import entities.Game;
import org.junit.Test;
import usecases.usecase_implementations.TurnManager;


/**
 *
 * @author jingw
 */
public class TurnManagerTest {
    /**
     * Tests whether the incrementTurn function increments the turn counter of the game
     */
    @Test 
    public void incrementTurnTest() {
        Game game = new Game();
        TurnManager tm = new TurnManager();
        tm.incrementTurn(game);
        assert game.getTurn() == 1;
    }
    
}
