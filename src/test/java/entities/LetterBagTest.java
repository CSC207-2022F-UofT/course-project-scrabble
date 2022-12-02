package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LetterBagTest {
    @Test
    public void putTileGetTileTest(){
        LetterBag bag = new LetterBag();
        bag.putTile("A");
        Assertions.assertEquals(10, bag.getNumTile("A"));
    }

    @Test
    public void removeTileTest(){
        LetterBag bag = new LetterBag();
        bag.removeTile("A");
        Assertions.assertEquals(8, bag.getNumTile("A"));
    }
}
