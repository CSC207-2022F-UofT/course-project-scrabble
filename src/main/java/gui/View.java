/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gui;
import entities.Game;
import entities.Player;
/**
 *
 * @author jingw
 */
public interface View {
    public void updateView(Game game); // updates all components of the view
    //public void updateHolder(Game game); // updates just the tile holder
    //public void updateBoard(Game game);// updates just the game board
    public void updateVictoryScreen(Player[] winners);
}
