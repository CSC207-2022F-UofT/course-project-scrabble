package games_manager;

import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerManagerTest {
    @Test
    public void drawHandTest(){
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }
        PlayerManager.drawHand(player, bag);
        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        for (int i=0; i<7; i++){
            Assertions.assertNotNull(player.getHand()[i]);
        }
        Assertions.assertEquals(bag_size_before-7, bag_size_after);

    }

    @Test
    public void drawTileTest(){
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        PlayerManager.drawHand(player, bag);
        player.getHand()[3] = null;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        PlayerManager.drawTile(player, bag);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertNotNull(player.getHand()[3]);
        Assertions.assertEquals(bag_size_before-1, bag_size_after);
    }

    @Test
    public void swapHandTest(){
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        LetterBag bag1 = new LetterBag();
        PlayerManager.drawHand(player, bag);
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int bag_size = 0 ;
        int bag1_size = 0;
        for (int i=0; i<26; i++){
            // getting the size of both bags
            bag_size += bag.getNumTile(alphabet[i]);
            bag1_size += bag1.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag1_size, bag_size); // bag should not change size when shuffled
    }

}
