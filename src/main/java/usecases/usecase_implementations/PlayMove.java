package usecases.usecase_implementations;

import entities.Game;
import entities.GameBoard;
import scrabble_controller.ScrabbleGameController;
import usecases.usecase_interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class PlayMove implements PlayMoveUsecase {

    public PlayMove(){

    }
    public void playMove(HandManager handManager, BoardManager boardManager, PlayerManager playerManager,
                         TurnManager turnManager, ScoringSystem gameScorer, Game game,
                         ScrabbleDictionary scrabbleDictionary, ScrabbleGameController gameController){
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

        ((FillHandUsecase)handManager).fillHand(game);// fill the next player's hand
    }
        else{
        ArrayList<MoveInfo> moves = boardManager.getMoves();
        gameController.resetMove();
        for(MoveInfo move : moves){
            handManager.addTile(game, move.getLetter());
        }
    }
        boardManager.clearMoves();// reset moves for next turn
    }
}
