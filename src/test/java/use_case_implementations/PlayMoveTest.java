
package use_case_implementations;

import entities.Game;
import entities.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import scrabble_controller.ScrabbleGameController;
import usecases.usecase_implementations.*;


public class PlayMoveTest {

    /**
     * Tests the playMove function to test if it accurately placed down a valid word and updated all the scores.
     * Places valid word "BAD"
     */

    @Test
    public void playMoveGoodMoveTest(){
        PlayMove pm = new PlayMove();
        HandManager hm = new HandManager();
        PlayerManager plm = new PlayerManager();
        TurnManager tm = new TurnManager();
        ScoringSystem gs = new ScoringSystem();
        ScrabbleDictionary sb = new ScrabbleDictionary();
        ScrabbleGameController gc = new ScrabbleGameController();

        int[] cords1 = {7, 6};
        int[] cords2 = {7, 7};
        int[] cords3 = {7, 8};

        Player p1 = new Player("Jake");
        Player p2 = new Player("Paul");

        Game game = gc.getData();

        game.addPlayer(p1);
        game.addPlayer(p2);

        gc.placeTileTester(cords1, "B");
        gc.placeTileTester(cords2, "A");
        gc.placeTileTester(cords3, "D");

        BoardManager bm = gc.getBoardManager();

        pm.playMoveTester(hm, bm, plm, tm, gs, game, sb, gc);

        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(7, 6), "B");
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(7, 7), "A");
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(7, 8), "D");

        Assertions.assertEquals(game.getPlayers().get(0).getScore(), 6);
        Assertions.assertEquals(game.getPlayers().get(1).getScore(), 0);


    }

    /**
     * Tests the playMove function to test if it accurately did not place down an invalid word and did not update
     * the scores. Will place an invalid word "BRUH"
     */

    @Test
    public void playMoveBadMoveTest(){
        PlayMove pm = new PlayMove();
        HandManager hm = new HandManager();
        PlayerManager plm = new PlayerManager();
        TurnManager tm = new TurnManager();
        ScoringSystem gs = new ScoringSystem();
        ScrabbleDictionary sb = new ScrabbleDictionary();
        ScrabbleGameController gc = new ScrabbleGameController();


        Player p1 = new Player("Jake");
        Player p2 = new Player("Paul");

        Game game = gc.getData();

        game.addPlayer(p1);
        game.addPlayer(p2);
        int[] cords1 = {7, 6};
        int[] cords2 = {7, 7};
        int[] cords3 = {7, 8};
        int[] cords4 = {7, 9};

        gc.placeTileTester(cords1, "B");
        gc.placeTileTester(cords2, "R");
        gc.placeTileTester(cords3, "U");
        gc.placeTileTester(cords4, "H");

        pm.playMoveTester(hm, gc.getBoardManager(), plm, tm, gs, game, sb, gc);


        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(8, 6), "-");
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(8, 7), "-");
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(8, 8), "-");
        Assertions.assertEquals(game.getGameBoard().getBoardCellValue(8, 9), "-");


        Assertions.assertEquals(game.getPlayers().get(0).getScore(), 0);
        Assertions.assertEquals(game.getPlayers().get(1).getScore(), 0);
    }

}
