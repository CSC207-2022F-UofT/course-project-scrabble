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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import gui.View;
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
    
    
    private View view; 
    
    public ScrabbleGameController(View v) {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
        gameCreator = new GameCreator();
        turnManager = new TurnManager();
        gameScorer = new ScoringSystem();
        view = v;
    }
    
    public void resetMove() {
        System.out.println("RESET MOVE");
        ((ResetMove) boardManager).resetMoves(game);
        ArrayList<MoveInfo> moveInfos = boardManager.getMoves();

        for(MoveInfo move : moveInfos){
            playerManager.addTile(game, move.getLetter());
            System.out.println("Letters");
            System.out.println(move.getLetter());
        }
        boardManager.clearMoves(game);
        view.updateView(game);
    }
    
    public void swapTiles() {
        ((SwapHand) playerManager).swapHand(game);
        view.updateView(game);
    }
    
    public void placeTile(int[] coords, String letter) {
        boolean placeTileTrueness = ((PlaceTile) boardManager).checkLetter(coords, letter, game);
        if(placeTileTrueness){
            ((RemoveTile)playerManager).removeTile(game, letter); // remove the tile
        }
        else{
            System.out.println("Invalid Move Played in placeTile");
        }
        // call boardmanager checkLetter 

        // place tile usecase 
        view.updateView(game);
    }
    
    public void playMove() {
        
        List<List<List<Integer>>> words = ((PlaceWord) boardManager).checkWord(game);
        
        //boardmanager checkword returns list of coordinates and list of letters used by the player
        
        if(!words.isEmpty())
        {
            // ScoringSystem 
            int score = ((WordScoreCalculator) gameScorer).calculateMultiWordScore(game, words);
            // calculate the total score of all the words found
            ((UpdateScoreUsecase) playerManager).updateScoreForCurrentPlayer(game.getCurrentPlayer().getScore() + score, game);
            // place word usecase
            System.out.println(game.getCurrentPlayer().getScore());

            ((IncrementTurnUsecase) turnManager).incrementTurn(game);

            ((FillHand)playerManager).fillHand(game);// fill the next player's hand
        }
        else{
            ArrayList<MoveInfo> moves = boardManager.getMoves();

            for(MoveInfo move : moves){
                playerManager.addTile(game, move.getLetter());
            }
        }
        boardManager.clearMoves(game);// reset moves for next turn
        System.out.println("DONE PLAY MOVE");
        view.updateView(game);
    }   
    
    
    public void createGameFromFile() {
        game = ((GameLoad)gameLoader).loadGame(); // loadgame usecase
        view.updateView(game);
    }
    
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSave)gameSaver).saveGame(game);// savegame usecase
    }
    
    public void startGame(String[] names) { // create game usecase
        game = ((CreateGame)gameCreator).createNewGame(names);
        ((FillHand)playerManager).fillHand(game);
        view.updateView(game);
    }
    
    public void endGame() { // get score
        Player[] winners = ((EndGame) playerManager).endGame(game);
        view.updateVictoryScreen(winners);
    }
    
    public Game getData() {
        return game;
    }
    
    
}
