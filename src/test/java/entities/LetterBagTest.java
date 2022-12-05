package entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LetterBagTest {
    /**
     * Tests puleTileGetTileTest by comparing a bag that used bag.putTile("A") and bag.getNumTile("A")
     */
    @Test
    public void putTileGetTileTest(){
        LetterBag bag = new LetterBag();
        bag.putTile("A");
        Assertions.assertEquals(10, bag.getNumTile("A"));
    }

    /**
     * Tests removeTileTest by comparing a bag that used bag.removeTile("A") and bag.getNumTile("A")
     */
    @Test
    public void removeTileTest(){
        LetterBag bag = new LetterBag();
        bag.removeTile("A");
        Assertions.assertEquals(8, bag.getNumTile("A"));
    }
}
