/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import entities.*;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author jingw
 */
public class GameView { //outputs the current state to the command line
    public void printState() {
        // print the game board
        printBoard();
        //print the players hands
        printPlayer();
    }
    
    private void printBoard() {
        Cell[][] board = Game.getInstance().getGameBoard().getBoard();
        for (Cell[] cellRow: board) {
            for (Cell cell: cellRow) {
                System.out.print(cell.getValue());
            }
            System.out.println();
        }
    }
    
    
    private void printPlayer() {
        List<Player> players = Game.getInstance().getPlayers();
        for(Player p: players) {
            System.out.println(p.getName()+": "+Arrays.toString(p.getHand()));
        }
    }
}
