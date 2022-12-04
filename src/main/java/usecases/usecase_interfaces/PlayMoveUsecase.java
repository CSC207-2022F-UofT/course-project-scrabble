package usecases.usecase_interfaces;

import entities.Game;
import scrabble_controller.ScrabbleGameController;
import usecases.usecase_implementations.BoardManager;
import usecases.usecase_implementations.HandManager;
import usecases.usecase_implementations.PlayerManager;
import usecases.usecase_implementations.ScoringSystem;
import usecases.usecase_implementations.ScrabbleDictionary;
import usecases.usecase_implementations.TurnManager;

public interface PlayMoveUsecase {
    public void playMove(HandManager handManager, BoardManager boardManager, PlayerManager playerManager,
                         TurnManager turnManager, ScoringSystem gameScorer, Game game,
                         ScrabbleDictionary scrabbleDictionary, ScrabbleGameController gameController);
}
