/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usecases.usecase_interfaces;

import entities.Game;
import java.util.ArrayList;
import usecases.usecase_implementations.MoveInfo;

/**
 *
 * @author jingw
 */
public interface ResetHandUsecase {
    public void resetHand(Game game, ArrayList<MoveInfo> moves);
}
