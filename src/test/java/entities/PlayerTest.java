package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTest {

    @Test
    public void getNameTest(){
        Player p = new Player("Abel");
        Assertions.assertEquals("Abel", p.getName());

    }

    @Test
    public void setAndGetScoreTest(){
        Player p = new Player("Abel");
        p.setScore(90210);
        Assertions.assertEquals(90210, p.getScore());
    }

    @Test
    public void setAndGetHandTest(){
        Player p = new Player("Abel");

        Cell c0 = new Cell("V", 4, 3);
        Cell c1 = new Cell("A", 1, 1);
        Cell c2 = new Cell("L", 1, 1);
        Cell c3 = new Cell("U", 1, 1);
        Cell c4 = new Cell("E", 1, 2);
        Cell c5 = new Cell("F", 1, 2);
        Cell c6 = new Cell("U", 1, 2);

        Cell[] hand = {c0, c1, c2, c3, c4, c5, c6};
        p.setHand(hand);
        Assertions.assertEquals(hand, p.getHand());
    }

}
