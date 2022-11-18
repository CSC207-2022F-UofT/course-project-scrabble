/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScrabbleGame;
import entities.Game;
import entities.Player;
import UsecaseInterfaces.*;
import games_manager.*;
/**
 *
 * @author jingw
 */
public class ScrabbleGameController{
    
    private BoardManager boardManager;
    private PlayerManager playerManager;
    private Game game;
    
    
    public ScrabbleGameController(String[] names) {
        boardManager = new BoardManager();
        playerManager = new PlayerManager();
        game = new Game();
        for(String str: names) {
            game.addPlayer(new Player(str));
        }
    }
    
    public void placeTile() {
        
    }
    
    public void playMove() {
        
    }   
    
    public void createGame() {
        
    }
    
    public void startGame() {
        
    }
    
    public void saveGame() {
        
    }
    
    public void endGame() {
        
    }
    
}
