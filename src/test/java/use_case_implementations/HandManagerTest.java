package use_case_implementations;

import entities.Cell;
import entities.Game;
import entities.LetterBag;
import entities.Player;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import usecases.usecase_implementations.HandManager;
import usecases.usecase_implementations.PlayerManager;

public class HandManagerTest {
    /**
     * Tests drawHand function to see if it accurately changed the players hand from null to real letters and also if
     * the letter bag was smaller than before.
     */
    @Test
    public void drawHandTest(){
        Game game = new Game();
        HandManager h_manager = new HandManager();
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
        h_manager.drawHand(game);
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
    /**
     * Tests drawTile test if it worked by seeing if it accurately drew all the tiles and asserted if the tile bag size
     * was edited.
     */
    @Test
    public void drawTileTest(){
        Game game = new Game();
        HandManager h_manager = new HandManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player player = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        h_manager.drawHand(game);
        player.getHand()[3] = null;

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        h_manager.drawTile(game);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertNotNull(player.getHand()[3]);
        Assertions.assertEquals(bag_size_before-1, bag_size_after);
    }

    /**
     * Tests function drawTile to draw a tile when the hand is full which means that the function does not operate.
     * Asserted that the letter bag did not change because no tiles were drawn.
     */
    @Test
    public void drawTileFullHandTest() { // unhappy flow test
        Game game = new Game();
        HandManager h_manager = new HandManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0;
        int bag_size_after = 0;
        h_manager.drawHand(game);

        for (int i=0; i<26; i++) {
            // getting the size of bag before changes
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        h_manager.drawTile(game);

        for (int i=0; i<26; i++) {
            // getting the size of bag after changes
            bag_size_after += bag.getNumTile(alphabet[i]);
        }

        Assertions.assertEquals(bag_size_before, bag_size_after);
    }

    /**
     * Tests swapHand function if it accurately swapped hands if the size of the tile bag did not change because
     * an equal number of tiles were shuffled back in to the bag.
     */
    @Test
    public void swapHandTest(){
        Game game = new Game();
        HandManager h_manager = new HandManager();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        h_manager.drawHand(game);
        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        h_manager.swapHand(game);

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before, bag_size_after); // bag should not change size when shuffled
    }

    /**
     * Tested fillHand function if it accurately filled the player's hand when not full as asserted letter bag size
     * was smaller than before.
     */
    @Test
    public void fillHandTest(){
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Game game = new Game();
        HandManager h_manager = new HandManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player p = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        h_manager.drawHand(game);

        PlayerManager.getHand(p)[0] = null;
        PlayerManager.getHand(p)[4] = null;
        PlayerManager.getHand(p)[6] = null;

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        h_manager.fillHand(game);

        for (int i=0; i<7; i++){
            // checking if players hand is not null
            Assertions.assertNotNull(p.getHand()[i]);
        }

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before-3, bag_size_after); // bag should not change size when shuffled

    }

    /**
     * Tests fillHand test to see if it accurately did not fill hand if one's hand was full as the tile bag should not
     * change size
     */
    @Test
    public void fillHandFullHandTest() { // unhappy flow
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Game game = new Game();
        HandManager h_manager = new HandManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        Player p = game.getCurrentPlayer();
        LetterBag bag = game.getLetterBag();
        int bag_size_before = 0 ;
        int bag_size_after = 0 ;
        h_manager.drawHand(game);

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_before += bag.getNumTile(alphabet[i]);
        }

        h_manager.fillHand(game);

        for (int i=0; i<7; i++){
            // checking if players hand is not null
            Assertions.assertNotNull(p.getHand()[i]);
        }

        for (int i=0; i<26; i++){
            // getting the size of bag after swap
            bag_size_after += bag.getNumTile(alphabet[i]);
        }
        Assertions.assertEquals(bag_size_before, bag_size_after); // bag should not change size when shuffled
    }

    /**
     * Tests removeTile Test accurately removed one tile from full hand as it changed sizes
     */
    @Test
    public void removeTileTestOneOccurrence(){
        Game game = new Game();
        HandManager h_manager = new HandManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        PlayerManager.getHand(p1)[1] = new Cell("C", 3, 1);
        PlayerManager.getHand(p1)[4] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[5] = new Cell ("R", 1, 1);

        h_manager.removeTile(game, "A");
        Cell[] hand = PlayerManager.getHand(p1);
        Assertions.assertNull(hand[4]);
    }
    /**
     * Tests removeTile Test accurately removed one tile from full hand as it changed sizes but instead this would be
     * multiple times
     */
    @Test
    public void removeTileTestMultiOccurrence(){
        Game game = new Game();
        HandManager h_manager = new HandManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        PlayerManager.getHand(p1)[1] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[4] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[5] = new Cell ("A", 1, 1);

        h_manager.removeTile(game, "A");
        Cell[] hand = PlayerManager.getHand(p1);
        Assertions.assertNull(hand[1]);
        Assertions.assertEquals("A", hand[4].getValue());
        Assertions.assertEquals("A", hand[5].getValue());
    }
    /**
     * Tests removeTile test accurately removes nothing when the value does not exist.
     */
    @Test
    public void removeTileNoOccurrenceTest() { // unhappy flow
        Game game = new Game();
        HandManager h_manager = new HandManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        PlayerManager.getHand(p1)[0] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[1] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[2] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[3] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[4] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[5] = new Cell ("A", 1, 1);
        PlayerManager.getHand(p1)[6] = new Cell ("A", 1, 1);

        h_manager.removeTile(game, "B");
        Cell[] hand = PlayerManager.getHand(p1);
        Assertions.assertEquals("A", hand[0].getValue());
        Assertions.assertEquals("A", hand[1].getValue());
        Assertions.assertEquals("A", hand[2].getValue());
        Assertions.assertEquals("A", hand[3].getValue());
        Assertions.assertEquals("A", hand[4].getValue());
        Assertions.assertEquals("A", hand[5].getValue());
        Assertions.assertEquals("A", hand[6].getValue()); // no change


    }
}
