package games_manager;
import UsecaseInterfaces.DrawTiles;
import UsecaseInterfaces.UpdateScoreUsecase;
import java.util.Random;

import entities.*;

public class PlayerManager implements DrawTiles, UpdateScoreUsecase{

    @Override
    public void drawTile(Game game) {
        /* Precondition: Player has less than 7 tiles in hand
           Draws a tile to the players hand
         */

        LetterBag bag = game.getLetterBag();
        Player player = game.getCurrentPlayer();
        ScoringSystem scorer = new ScoringSystem();
        Random rand = new Random();
        Cell letter = new Cell();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int int_random;
        String character;

        do {
            int_random = rand.nextInt(26); // get a random number from 0-25
            character = alphabet[int_random]; // use that number to get the associated letter
        } while (bag.getValue(character) == 0); // check if that letter still has tiles in the bag

        bag.removeTile(character); // remove that tile from the bag
        BoardManager.boardManagerSetCellValue(letter, character); // update the cell to have the random value
        int i = 0;
        while (player.getHand()[i] != null) { // loop to find index of hand that is null
            i++;
        }
        scorer.initializeCellScore(letter); // assigns the correct score to the cell
        player.getHand()[i] = letter; // assign the null space the value of the new hand
    }

    @Override
    public void swapHand(Game game){
        // Precondition: players hand is full i.e. has no null within it
        // Returns all tiles in players hand back to the bag and draws 7 new tiles from the bag

        // add all tiles in hand back to bag
        LetterBag bag = game.getLetterBag();
        Player player = game.getCurrentPlayer();
        for (Cell tile: player.getHand()){
            bag.putTile(BoardManager.boardManagerGetCellValue(tile));
        }
        // clear player hand
        Cell[] null_array = new Cell[player.getHand().length];
        player.setHand(null_array);

        // draw new tiles
        this.drawHand(game);
    }

    @Override
    public void drawHand(Game game){
        // Precondition: Player's hand is empty i.e. is filled with null
        // Gives the player 7 new tiles
        LetterBag bag = game.getLetterBag();
        Player player = game.getCurrentPlayer();
        for (int i=0; i<player.getHand().length; i++) {
            this.drawTile(game);
        }
    }

    public static void setName(Player player, String new_name) {
        player.setName(new_name);
    }

    public static String getName(Player player) {
        return player.getName();
    }

    public static void setScore(int new_score, Player player) {
        player.setScore(new_score);
    }

    public static int getScore(Player player) { return player.getScore(); }

    public static void setHand(Cell[] new_hand, Player player){ player.setHand(new_hand); }

    public static Cell[] getHand(Player player) { return player.getHand(); }

    @Override
    public void updateScoreForCurrentPlayer(int newScore, Game game) {
        game.getCurrentPlayer().setScore(newScore);
    }
    


}


