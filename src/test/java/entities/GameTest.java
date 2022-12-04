package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {

    /**
     * Tests the addPlayer function within Game by adding a player and getting the players
     */
    @Test
    public void addPlayerTest(){
        Game game = new Game();
        Player p = new Player("Aubrey");
        game.addPlayer(p);
        Assertions.assertEquals(1, game.getPlayers().size());
        Assertions.assertEquals(p, game.getPlayers().get(0));
    }

    /**
     * Tests the getGameBoard function within Game by mutating the board of Game and retrieving it
     * to check if the mutations match up
     */
    @Test
    public void getGameBoardTest(){
        Game game = new Game();
        Cell cell = new Cell("H", 1, 1);
        game.getGameBoard().getBoard()[0][0] = cell;
        Assertions.assertEquals(cell, game.getGameBoard().getBoard()[0][0]);
    }

    /**
     * Tests the getLetterBag function within Game by mutating the letter bag of Game and retrieving it
     * to check if the mutations match up
     */
    @Test
    public void getLetterBagTest(){
        Game game = new Game();
        game.getLetterBag().putTile("A");
        Assertions.assertEquals(10, game.getLetterBag().getNumTile("A"));
    }

    /**
     * Tests the getTurn method by calling it and checking if the value is the default value
     */
    @Test
    public void getTurnTest(){
        Game game = new Game();
        Assertions.assertEquals(0, game.getTurn());
    }

    /**
     * Tests the getCurrentPlayer method by adding two players and determining whose turn it should be on turn 0.
     * Using that information create an assertion
     */
    @Test
    public void getCurrentPlayerTest(){
        Game game = new Game();
        Player p1 = new Player("Navraj");
        Player p2 = new Player("Singh");
        game.addPlayer(p1);
        game.addPlayer(p2);

        Assertions.assertEquals(p1, game.getCurrentPlayer());
    }

    /**
     * Tests the incrementTurn method by incrementing the turn in game and checking whether the turn is 1
     */
    @Test
    public void incrementTurnTest(){
        Game game = new Game();
        game.incrementTurn();
        Assertions.assertEquals(1, game.getTurn());
    }

    /**
     * Tests the getCurrentPlayer method by adding two players and determining whose turn it should be on turn 1.
     * Using that information create an assertion
     */
    @Test
    public void getCurrentPlayerTurnTwoTest(){
        Game game = new Game();
        Player p1 = new Player("Navraj");
        Player p2 = new Player("Singh");
        game.incrementTurn();
        game.addPlayer(p1);
        game.addPlayer(p2);

        Assertions.assertEquals(p2, game.getCurrentPlayer());
    }

}
