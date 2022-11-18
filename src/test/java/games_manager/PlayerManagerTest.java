package games_manager;

import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerManagerTest {
    @Test
    public void drawHandTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0;
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player player = game.getCurrentPlayer();

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }
        p_manager.drawHand(game);
        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        for (int i=0; i<7; i++){
            // checking if players hand is not null
            Assertions.assertNotNull(player.getHand()[i]);
        }
        Assertions.assertEquals(bag_size_before-7, bag_size_after);

    }

    @Test
    public void drawTileTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player player = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        p_manager.drawHand(game);
        player.getHand()[3] = null;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.drawTile(game);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertNotNull(player.getHand()[3]);
        Assertions.assertEquals(bag_size_before-1, bag_size_after);
    }

    @Test
    public void swapHandTest(){
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        p_manager.drawHand(game);
        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        p_manager.swapHand(game);

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before, bag_size_after); // bag should not change size when shuffled
    }

}
