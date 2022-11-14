/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerManager;
import entities.*;
import UsecaseInterfaces.UpdateScoreUsecase;
/**
 *
 * @author jingw
 */
public class PlayerManager implements UpdateScoreUsecase{
    
    
    
    
    
    @Override
    public void updateScoreForCurrentPlayer(int newScore) {
        Game.getInstance().getCurrentPlayer().setScore(newScore);
    }
    
    
}
