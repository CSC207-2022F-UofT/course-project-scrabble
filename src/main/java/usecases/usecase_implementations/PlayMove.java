package usecases.usecase_implementations;

import entities.Game;
import entities.GameBoard;
import scrabble_controller.ScrabbleGameController;
import usecases.usecase_interfaces.*;

import java.util.List;


public class PlayMove implements PlayMoveUsecase {
    
    /**
     * This method plays a move during a player's turn
     * @param game The game object with the board.
     */
    @Override
    public void playMove(HandManager handManager, BoardManager boardManager, PlayerManager playerManager,
                         TurnManager turnManager, ScoringSystem gameScorer, Game game,
                         ScrabbleDictionary scrabbleDictionary, ScrabbleGameController gameController){
        GameBoard prevBoard = boardManager.getPrevBoard();
        List<List<List<Integer>>> words = ((PlaceWordUsecase) boardManager).checkWord(game, scrabbleDictionary, prevBoard);

        //boardmanager checkword returns list of coordinates and list of letters used by the player

        if(!words.isEmpty()) {
            System.out.println("valid word");
            // ScoringSystem
            int score = ((CalculateWordScoreUsecase) gameScorer).calculateMultiWordScore(game, words);
            // calculate the total score of all the words found
            ((UpdateScoreUsecase) playerManager).updateScoreForCurrentPlayer(game.getCurrentPlayer().getScore() + score, game);
            // place word usecase


            ((IncrementTurnUsecase) turnManager).incrementTurn(game);

            ((FillHandUsecase)handManager).fillHand(game);// fill the next player's hand
        }
        else {
            System.out.println("not valid");
            gameController.resetMove();
        }
        boardManager.clearMoves();// reset moves for next turn
    }
    /**
     * This function is responsible for playing a move from an assortment of tiles placed onto the board from the player
     * but is only used for testing purposes. This does not update the view / GUI as there is none available in testing.
     * @param handManager HandManager passed into the function to fill back the user's hand
     * @param boardManager BoardManager passed into the function to place the word down on the board
     * @param playerManager PlayerManager passed into the function from to update the score
     * @param turnManager TurnManager passed into the function to increment the turn
     * @param gameScorer ScoringSystem passed into the function to calculate the score of the word created
     * @param game Game instance passed into the function to update all the entities
     * @param scrabbleDictionary ScrabbleDictionary passed into the game to verify the word's validity
     * @param gameController ScrabbleGameController passed into function to reset the moves in case of an invalid word
     */
    public void playMoveTester(HandManager handManager, BoardManager boardManager, PlayerManager playerManager,
                         TurnManager turnManager, ScoringSystem gameScorer, Game game,
                         ScrabbleDictionary scrabbleDictionary, ScrabbleGameController gameController){
        GameBoard prevBoard = boardManager.getPrevBoard();
        List<List<List<Integer>>> words = ((PlaceWordUsecase) boardManager).checkWord(game, scrabbleDictionary, prevBoard);

        //boardmanager checkword returns list of coordinates and list of letters used by the player

        if(!words.isEmpty()) {
            System.out.println("valid word");
            // ScoringSystem
            int score = ((CalculateWordScoreUsecase) gameScorer).calculateMultiWordScore(game, words);
            // calculate the total score of all the words found
            ((UpdateScoreUsecase) playerManager).updateScoreForCurrentPlayer(game.getCurrentPlayer().getScore() + score, game);
            // place word usecase


            ((IncrementTurnUsecase) turnManager).incrementTurn(game);

            ((FillHandUsecase)handManager).fillHand(game);// fill the next player's hand
        }
        else {
            System.out.println("not valid");
            gameController.resetMoveTester();
        }
        boardManager.clearMoves();// reset moves for next turn
    }
}
