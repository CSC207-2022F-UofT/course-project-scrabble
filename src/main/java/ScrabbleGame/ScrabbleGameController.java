/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ScrabbleGame;
import entities.Game;
import data.*;
import UsecaseInterfaces.*;
import games_manager.*;
import java.util.List;
import java.util.ArrayList;
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
    private GameCreator gameCreator;
    private TurnManager turnManager;
    private Game game;
    
    
    public ScrabbleGameController() {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
        gameCreator = new GameCreator();
        turnManager = new TurnManager();
    }
    
    public void resetMove() {
        ((ResetMove) boardManager).resetMoves(game);
    }
    
    public void swapTiles() {
        ((SwapHand) playerManager).swapHand(game);
    }
    
    public void placeTile(int[] coords, String letter) {
        ((PlaceTile) boardManager).checkLetter(coords, letter, game);
        // call boardmanager checkLetter 
        
        // place tile usecase 
    }
    
    public void playMove() {
        
        List<List<List<Integer>>> words = new ArrayList<>();  
        //= ((PlaceWord) boardManager).checkWord(game); // wait for fix
        
        //boardmanager checkword returns list of list of coordinates and list of letters used by the player
        
        // ScoringSystem 
        int score = ((WordScoreCalculator) gameScorer).calculateMultiWordScore(game, words);
        // calculate the total score of all the words found
        
        
        ((UpdateScoreUsecase) playerManager).updateScoreForCurrentPlayer(game.getCurrentPlayer().getScore() + score, game);
        // place word usecase 
        
        ((IncrementTurnUsecase) turnManager).incrementTurn(game);
    }   
    
    
    public void createGameFromFile() {
        game = ((GameLoad)gameLoader).loadGame(); // loadgame usecase
    }
    
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSave)gameSaver).saveGame(game);// savegame usecase
    }
    
    public void startGame(String[] names) { // create game usecase
        ((CreateGame)gameCreator).createNewGame(names);
    }
    
    public void endGame() { // get score
        
    }
    
    public Game getData() {
        return game;
    }
    
    
}
