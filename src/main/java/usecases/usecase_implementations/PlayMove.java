package usecases.usecase_implementations;

import entities.Game;
import entities.GameBoard;
import entities.MoveInfo;
import scrabble_controller.ScrabbleGameController;
import usecases.usecase_interfaces.*;

import java.util.List;

public class PlayMove implements PlayMoveUsecase {
    
    /**
     * This method plays a move during a player's turn
     * @param game The game object with the board.
     * @return returns a list of moveInfos which represents the moves made by the player during the turn that have been reset
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
}
