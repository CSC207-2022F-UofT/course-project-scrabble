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
    private ScoringSystem gameScorer;
    private Game game;
    
    
    public ScrabbleGameController() {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
    }
    
    public void resetWord() {
        
    }
    
    public void swapTiles() {
        
    }
    
    public void placeTile(int[] coords, String letter) {
        ((PlaceTile) boardManager).checkLetter(coords, letter, game);
        // call boardmanager checkLetter 
        
        // call playermanager removeTile
        
        // place tile usecase 
        // need to fix the first_move parameter
    }
    
    public void playMove() {
        
        //boardmanager checkword returns list of list of coordinates and list of letters used by the player
        
        // ScoringSystem 
        
        
        // place word usecase 
    }   
    
    public void createGameFromFile() {
        game = ((GameLoad)gameLoader).loadGame(); // loadgame usecase
    }
    
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSave)gameSaver).saveGame(game);// savegame usecase
    }
    
    public void startGame(String[] names) {
        
    }
    
    public void endGame() { // get score
        
    }
    
    public Game getData() {
        return game;
    }
    
    
}
