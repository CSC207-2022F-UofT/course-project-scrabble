/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scrabble_controller;
import data_gateways.gateways_implementation.GameSaverSystem;
import data_gateways.gateways_implementation.GameLoaderSystem;
import data_gateways.gateways_implementation.GameCreator;
import data.gateway_interfaces.GameLoadUsecase;
import data.gateway_interfaces.GameSaveUsecase;
import entities.*;
import usecases.usecase_implementations.ScoringSystem;
import entities.MoveInfo;
import usecases.usecase_implementations.BoardManager;
import usecases.usecase_implementations.TurnManager;
import usecases.usecase_implementations.PlayerManager;
import usecases.usecase_interfaces.RemoveTileUsecase;
import usecases.usecase_interfaces.SwapHandUsecase;
import usecases.usecase_interfaces.PlaceTileUsecase;
import usecases.usecase_interfaces.EndGameUsecase;
import usecases.usecase_interfaces.FillHandUsecase;
import usecases.usecase_interfaces.ResetMoveUsecase;
import usecases.usecase_interfaces.IncrementTurnUsecase;
import usecases.usecase_interfaces.CreateGameUsecase;
import usecases.usecase_implementations.HandManager;
import usecases.usecase_implementations.EndGameManager;
import usecases.usecase_implementations.PlayMove;
import java.util.ArrayList;
import gui.View;
import usecases.usecase_implementations.ScrabbleDictionary;

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
    private final HandManager handManager;
    private final EndGameManager endGameManager;
    private final PlayMove playMove;
    private Game game;
    private final ScrabbleDictionary scrabbleDictionary;
    
    
    private final View view;
    
    public ScrabbleGameController(View v) {
        boardManager = new BoardManager(); // this class implements checkword checktile
        playerManager = new PlayerManager();// this class implements updatescore, drawtiles
        handManager = new HandManager();
        gameLoader = new GameLoaderSystem();
        gameSaver = new GameSaverSystem();
        gameCreator = new GameCreator();
        turnManager = new TurnManager();
        gameScorer = new ScoringSystem();
        scrabbleDictionary = new ScrabbleDictionary();
        endGameManager = new EndGameManager();
        playMove = new PlayMove();
        view = v;
    }
    



    /**
     * This method is responsible for calling the resetMoves usecase.
     */
    public void resetMove() {
        ArrayList<MoveInfo> moveInfos = ((ResetMoveUsecase) boardManager).resetMoves(game);
        ((ResetHandUsecase) handManager).resetHand(game, moveInfos);
        view.updateView(game);
    }
    


    /**
     * This method is responsible for calling the swapHand, incrementTurn, and fillHand usecases
     * Then updates the view
     */
    public void swapTiles() {
        ((SwapHandUsecase) handManager).swapHand(game);
        ((IncrementTurnUsecase) turnManager).incrementTurn(game);
        ((FillHandUsecase)handManager).fillHand(game);// fill the next player's hand

        view.updateView(game);
    }
    
    /**
     * This method is responsible for calling the checkLetter and removeTile usecases
     * Then updates the view
     * @param coords the coordinates of the letter being placed
     * @param letter the letter being placed
     */
    public void placeTile(int[] coords, String letter) {
        boolean placeTileTrueness = ((PlaceTileUsecase) boardManager).checkLetter(coords, letter, game);
        if(placeTileTrueness){
            ((RemoveTileUsecase)handManager).removeTile(game, letter); // remove the tile
        }
        else{
            System.out.println("Invalid Move Played in placeTile");
        }
        // call boardmanager checkLetter 

        // place tile usecase 
        view.updateView(game);
    }
    

    /**
     * This method is responsible for calling the playmove usecase. 
     */
    public void playMove() {
        ((PlayMoveUsecase)playMove).playMove(handManager, boardManager, playerManager, turnManager, gameScorer, game,
                scrabbleDictionary, this);
        saveGameToFile();
        view.updateView(game);
    }


    public boolean checkFullHand(){
        return ((CheckHandUsecase)handManager).checkHand(game);
    }
    
    /**
     * This method is responsible for creating a game from the file stored locally on the users computer
     */
    public void createGameFromFile() {
        game = ((GameLoadUsecase)gameLoader).loadGame(); // loadgame usecase
        view.updateView(game);
    }
    /**
     * This method is responsible for saving the current game state to a file
     */
    public void saveGameToFile() { // make sure this is not called before a game is created
        ((GameSaveUsecase)gameSaver).saveGame(game);// savegame usecase
    }
    
    /**
     * This method is responsible for creating a new game given a list of names
     * @param names a list of the players' names
     */
    public void startGame(String[] names) { // create game usecase
        game = ((CreateGameUsecase)gameCreator).createNewGame(names);
        ((FillHandUsecase)handManager).fillHand(game);
        view.updateView(game);
    }
    
    /**
     * This method is responsible for ending the game and calculating the winner
     */
    public void endGame() { // get score
        Player[] winners = ((EndGameUsecase) endGameManager).endGame(game);
        view.updateVictoryScreen(winners);
    }   
    
    public Game getData() {
        return game;
    }
    
    
}
