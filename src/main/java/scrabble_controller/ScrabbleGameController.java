/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scrabble_controller;
import data_gateways.GameSaverSystem;
import data_gateways.GameLoaderSystem;
import data_gateways.GameCreator;
import Usecases.usecase_implementations.ScoringSystem;
import Usecases.usecase_implementations.MoveInfo;
import Usecases.usecase_implementations.BoardManager;
import Usecases.usecase_implementations.TurnManager;
import Usecases.usecase_implementations.PlayerManager;
import Usecases.usecase_interfaces.RemoveTileUsecase;
import Usecases.usecase_interfaces.GameLoadUsecase;
import Usecases.usecase_interfaces.SwapHandUsecase;
import Usecases.usecase_interfaces.PlaceWordUsecase;
import Usecases.usecase_interfaces.PlaceTileUsecase;
import Usecases.usecase_interfaces.EndGameUsecase;
import Usecases.usecase_interfaces.UpdateScoreUsecase;
import Usecases.usecase_interfaces.FillHandUsecase;
import Usecases.usecase_interfaces.GameSaveUsecase;
import Usecases.usecase_interfaces.ResetMoveUsecase;
import Usecases.usecase_interfaces.IncrementTurnUsecase;
import Usecases.usecase_interfaces.CreateGameUsecase;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import gui.View;
import Usecases.usecase_implementations.ScrabbleDictionary;
import Usecases.usecase_interfaces.CalculateWordScoreUsecase;

/**
 *
 * @author jingw
 */
public class ScrabbleGameController{
    
    private final BoardManager boardManager;
    private final PlayerManager playerManager;
    private final GameLoaderSystem  gameLoader;
    private final GameSaverSystem gameSaver;
    private final ScoringSystem gameScorer;
    private final GameCreator gameCreator;
    private final TurnManager turnManager;
    private Game game;
    private final ScrabbleDictionary scrabbleDictionary;
    
    
    private final View view; 
    
    public ScrabbleGameController(View v) {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
        gameCreator = new GameCreator();
        turnManager = new TurnManager();
        gameScorer = new ScoringSystem();
        scrabbleDictionary = new ScrabbleDictionary();
        view = v;
    }
    
    public void resetMove() {
        System.out.println("RESET MOVE");
        ((ResetMoveUsecase) boardManager).resetMoves(game);
        ArrayList<MoveInfo> moveInfos = boardManager.getMoves();

        for(MoveInfo move : moveInfos){
            playerManager.addTile(game, move.getLetter());
            System.out.println("Letters");
            System.out.println(move.getLetter());
        }
        boardManager.clearMoves();
        view.updateView(game);
    }
    
    public void swapTiles() {
        ((SwapHandUsecase) playerManager).swapHand(game);
        ((IncrementTurnUsecase) turnManager).incrementTurn(game);
        ((FillHandUsecase)playerManager).fillHand(game);// fill the next player's hand

        view.updateView(game);
    }
    
    public void placeTile(int[] coords, String letter) {
        boolean placeTileTrueness = ((PlaceTileUsecase) boardManager).checkLetter(coords, letter, game);
        if(placeTileTrueness){
            ((RemoveTileUsecase)playerManager).removeTile(game, letter); // remove the tile
        }
        else{
            System.out.println("Invalid Move Played in placeTile");
        }
        // call boardmanager checkLetter 

        // place tile usecase 
        view.updateView(game);
    }
    
    public void playMove() {

        GameBoard prevBoard = boardManager.getPrevBoard();
        List<List<List<Integer>>> words = ((PlaceWordUsecase) boardManager).checkWord(game, scrabbleDictionary, prevBoard);
        
        //boardmanager checkword returns list of coordinates and list of letters used by the player
        
        if(!words.isEmpty())
        {
            // ScoringSystem 
            int score = ((CalculateWordScoreUsecase) gameScorer).calculateMultiWordScore(game, words);
            // calculate the total score of all the words found
            ((UpdateScoreUsecase) playerManager).updateScoreForCurrentPlayer(game.getCurrentPlayer().getScore() + score, game);
            // place word usecase
            System.out.println(game.getCurrentPlayer().getScore());

            ((IncrementTurnUsecase) turnManager).incrementTurn(game);

            ((FillHandUsecase)playerManager).fillHand(game);// fill the next player's hand
        }
        else{
            ArrayList<MoveInfo> moves = boardManager.getMoves();

            for(MoveInfo move : moves){
                playerManager.addTile(game, move.getLetter());
            }
        }
        boardManager.clearMoves();// reset moves for next turn
        System.out.println("DONE PLAY MOVE");
        saveGameToFile();
        view.updateView(game);
    }
    
    
    public void createGameFromFile() {
        game = ((GameLoadUsecase)gameLoader).loadGame(); // loadgame usecase
        view.updateView(game);
    }
    
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSaveUsecase)gameSaver).saveGame(game);// savegame usecase
    }
    
    public void startGame(String[] names) { // create game usecase
        game = ((CreateGameUsecase)gameCreator).createNewGame(names);
        ((FillHandUsecase)playerManager).fillHand(game);
        view.updateView(game);
    }
    
    public void endGame() { // get score
        Player[] winners = ((EndGameUsecase) playerManager).endGame(game);
        view.updateVictoryScreen(winners);
    }
    
    public Game getData() {
        return game;
    }
    
    
}
