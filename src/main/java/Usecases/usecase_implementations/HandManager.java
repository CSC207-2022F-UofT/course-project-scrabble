package games_manager;

import UsecaseInterfaces.*;
import entities.Cell;
import entities.Game;
import entities.LetterBag;
import entities.Player;

import java.util.Random;

public class HandManager implements FillHand, DrawHand, SwapHand, RemoveTile{
    /**
     * This method is responsible for drawing a tile into the player's hand.
     * @param game the game with the current player who wants to draw a tile.
     * The current player must have less than 7 tiles in hand.
     */
    public void drawTile(Game game) {

        LetterBag bag = game.getLetterBag();
        Player player = game.getCurrentPlayer();
        Random rand = new Random();
        Cell letter = new Cell();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int int_random;
        String character;

        do {
            int_random = rand.nextInt(26); // get a random number from 0-25
            character = alphabet[int_random]; // use that number to get the associated letter
        } while (bag.getValue(character) == 0); // check if that letter still has tiles in the bag

        letter.setValue(character); // update the cell to have the random value
        for (int i=0; i<7; i++) { // loop to find index of hand that is null
            Cell cell = player.getHand()[i];
            if (cell == null){
                bag.removeTile(character); // remove that tile from the bag
                player.getHand()[i] = letter; // assign the null space the value of the new hand
                break;
            }
        }
    }

    /**
     * This method is responsible for drawing a tile into the player's hand until their hand is filled with tiles.
     * @param game the game with the current player who wants to fill hand.
     */
    @Override
    public void fillHand(Game game){
        Player player = game.getCurrentPlayer();
        for (Cell letter: player.getHand()){ // loop over player hand
            if (letter == null) {
                this.drawTile(game); // if space in hand is empty draw tile
            }
        }
    }

    /**
     * This method is responsible for swapping a player's hand.
     * This is done by returning all tiles in player's hand back to the letter bag and draw 7 new tiles.
     * @param game the game with the current player who wants to swap hand.
     * The current player's hand must be filled with tiles.
     */
    @Override
    public void swapHand(Game game){

        // add all tiles in hand back to bag
        LetterBag bag = game.getLetterBag();
        Player player = game.getCurrentPlayer();
        for (Cell tile: player.getHand()){
            bag.putTile(tile.getValue());
        }
        // clear player hand
        Cell[] null_array = new Cell[player.getHand().length];
        player.setHand(null_array);

        // draw new tiles
        this.drawHand(game);
    }

    /**
     * This method is responsible for drawing 7 tiles to the player's hand.
     * @param game the game with the current player who wants to draw hand.
     * The current player's hand must be empty.
     */
    @Override
    public void drawHand(Game game){
        Player player = game.getCurrentPlayer();
        for (int i=0; i<player.getHand().length; i++) {
            this.drawTile(game);
        }
    }

    /**
     * This method is responsible for removing the first occurrence of a tile with value
     * letter from the player's hand.
     * @param game the game with the current player who wants to remove a tile hand.
     * @param letter the Tile's value which needs to be removed from player's hand
     */
    @Override
    public void removeTile(Game game, String letter){
        Player player = game.getCurrentPlayer();
        for (int i=0; i<player.getHand().length; i++){
            Cell cell = player.getHand()[i];
            if (cell != null) {
                if (letter.equals(cell.getValue())){ // checks if cell's value is the same as letter
                    player.getHand()[i] = null; // removes tile
                    return;
                }
            }
        }
    }

    public boolean checkHand(Game game){
        Cell[] hand = game.getCurrentPlayer().getHand();
        for (Cell tile : hand){
            if (tile == null){
                return false;
            }
        }
        return true;
    }

    public void addTile(Game game, String letter){
        Player player = game.getCurrentPlayer();
        for (int i=0; i<player.getHand().length; i++){
            Cell cell = player.getHand()[i];
            if (cell == null) {
                player.getHand()[i] = new Cell(letter, 0); // removes tile
                return;
            }
        }

    }
}
