package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    @Test
    public void addPlayerTest(){
        Game game = new Game();
        Player p = new Player("Aubrey");
        game.addPlayer(p);
        Assertions.assertEquals(1, game.getPlayers().size());
        Assertions.assertEquals(p, game.getPlayers().get(0));
    }

    @Test
    public void getGameBoardTest(){
        Game game = new Game();
        Cell cell = new Cell("H", 1, 1);
        game.getGameBoard().getBoard()[0][0] = cell;
        Assertions.assertEquals(cell, game.getGameBoard().getBoard()[0][0]);
    }

    @Test
    public void getLetterBagTest(){
        Game game = new Game();
        game.getLetterBag().putTile("A");
        Assertions.assertEquals(10, game.getLetterBag().getNumTile("A"));
    }

    @Test
    public void getTurnTest(){
        Game game = new Game();
        Assertions.assertEquals(0, game.getTurn());
    }

    @Test
    public void getCurrentPlayerTest(){
        Game game = new Game();
        Player p1 = new Player("Navraj");
        Player p2 = new Player("Singh");
        game.addPlayer(p1);
        game.addPlayer(p2);

        Assertions.assertEquals(p1, game.getCurrentPlayer());
    }

    @Test
    public void incrementTurnTest(){
        Game game = new Game();
        game.incrementTurn();
        Assertions.assertEquals(1, game.getTurn());
    }

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
