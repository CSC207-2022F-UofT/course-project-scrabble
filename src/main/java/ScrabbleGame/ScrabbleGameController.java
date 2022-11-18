/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScrabbleGame;
import entities.Game;
import entities.Player;
import data.*;
import UsecaseInterfaces.*;
import games_manager.*;
/**
 *
 * @author jingw
 */
public class ScrabbleGameController{
    
    private BoardManager boardManager;
    private PlayerManager playerManager;
    private GameLoaderSystem  gameLoader;
    private GameSaverSystem gameSaver;
    private Game game;
    
    
    public ScrabbleGameController() {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
    }
    
    public void placeTile(int[] coords, String letter) {
        ((BoardManagement) boardManager).checkLetter(coords, letter, game.getGameBoard(), true);
        // need to fix the first_move parameter
    }
    
    public void playMove() {
        
    }   
    
    public void createGameFromFile() {
        game = ((GameLoad)gameLoader).loadGame();
    }
    
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSave)gameSaver).saveGame(game);
    }
    
    public void startGame(String[] names) {
        game = new Game();
        for(String str: names) {
            game.addPlayer(new Player(str));
        }
    }
    
    public void endGame() {
        
    }
    
    public Game getData() {
        return game;
    }
    
    
}
