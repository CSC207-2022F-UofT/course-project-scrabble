package games_manager;

import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerManagerTest {
    @Test
    public void drawHandTest(){
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }
        p_manager.drawHand(player, bag);
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
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        p_manager.drawHand(player, bag);
        player.getHand()[3] = null;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.drawTile(player, bag);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertNotNull(player.getHand()[3]);
        Assertions.assertEquals(bag_size_before-1, bag_size_after);
    }

    @Test
    public void swapHandTest(){
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player player = new Player("Jeff");
        LetterBag bag = new LetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        p_manager.drawHand(player, bag);
        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.swapHand(player, bag);

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before, bag_size_after); // bag should not change size when shuffled
    }

}
