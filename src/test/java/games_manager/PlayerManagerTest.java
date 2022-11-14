package games_manager;

import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerManagerTest {
    @Test
    public void drawHandTest(){
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        PlayerManager.drawHand(player, bag);
        for (int i=0; i<7; i++){
            Assertions.assertNotNull(player.getHand()[i]);
        }
    }

    @Test
    public void drawTileTest(){
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        PlayerManager.drawHand(player, bag);
        player.getHand()[3] = null;
        PlayerManager.drawTile(player, bag);
        Assertions.assertNotNull(player.getHand()[3]);
    }

    @Test
    public void swapHandTest(){
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        PlayerManager.drawHand(player, bag);
        LetterBag bag1 = new LetterBag();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        // TODO finish test
        for (int i=0; i<26; i++){
            // check if letter bag has been changed
            // Assertions.assertEquals(bag1.getNumTile(alphabet[i]), bag.getNumTile(alphabet[i]));
        }
    }

}
