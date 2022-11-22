package games_manager;
import UsecaseInterfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;
/**
 * This class is responsible for managing the Player entity
 * @author Umair & Jazli
 */
public class PlayerManager implements FillHand, DrawHand, SwapHand, RemoveTile, UpdateScoreUsecase, EndGame{

    /**
     * This method is responsible for drawing a tile into the player's hand.
     * @param game the game with the current player who wants to draw a tile.
     * The current player must have less than 7 tiles in hand.
     */
    public void drawTile(Game game) {

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
            bag.putTile(BoardManager.boardManagerGetCellValue(tile));
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
        LetterBag bag = game.getLetterBag();
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
        for (int i=0; i<PlayerManager.getHand(player).length; i++){
            Cell cell = PlayerManager.getHand(player)[i];
            if (cell != null) {
                if (letter.equals(BoardManager.boardManagerGetCellValue(cell))) { // checks if cell's value is the same as letter
                    PlayerManager.getHand(player)[i] = null; // removes tile
                    return;
                }
            }
        }
    }

    /**
     * This method is responsible for changing the name of a player.
     * @param player the player who wants there name changed.
     * @param new_name the new name for the player
     */
    public static void setName(Player player, String new_name) {
        player.setName(new_name);
    }

    /**
     * This method is responsible for returning the name of a player.
     * @param player the player whose name will be returned.
     * @return the name of the given Player
     */
    public static String getName(Player player) {
        return player.getName();
    }

    /**
     * This method is responsible for returning the name of a player.
     * @param player the player whose score will be returned.
     * @param new_score new score of the player
     */
    public static void setScore(int new_score, Player player) {
        player.setScore(new_score);
    }

    /**
     * This method is responsible for returning the score of a player.
     * @param player the player whose score will be returned.
     * @return the score of the given Player
     */
    public static int getScore(Player player) { return player.getScore(); }

    /**
     * This method is responsible for setting the hand of a player.
     * @param player the player whose hand will be set.
     * @param new_hand the hand that will replace player's hand
     */
    public static void setHand(Cell[] new_hand, Player player){ player.setHand(new_hand); }

    /**
     * This method is responsible for returning the hand of a player.
     * @param player the player whose hand will be returned.
     * @return the hand of the given Player in an array
     */
    public static Cell[] getHand(Player player) { return player.getHand(); }

    /**
     * This method is responsible for updating the score of the current player.
     * @param newScore the score that needs to be updated to player's score.
     * @param game the game with the current player whose score needs to be updated
     */
    @Override
    public void updateScoreForCurrentPlayer(int newScore, Game game) {
        game.getCurrentPlayer().setScore(newScore);
    }

    /**
     * This method is responsible for returning an array of players that won at the end of the game.
     * @param game the game with the players of the game.
     * @return Player[] an array of all player's that won the game
     */
    @Override
    public Player[] endGame(Game game){
        int ind_max_so_far = 0;                             // index of the highest score player
        List<Player> maxPlayers = new ArrayList<>();        // list of players with the highest scores so far
        List<Player> listOfPlayers = game.getPlayers();     // list of players in the game
        for (int i = 0; i < (listOfPlayers.size()); i++) {  // loop through list of players
            Player player = listOfPlayers.get(i);           // current player that is indexed
            if(player.getScore() > listOfPlayers.get(ind_max_so_far).getScore()) {   // if new player has higher score
                ind_max_so_far = i;
                // empty the list of players that had a max score
                maxPlayers.clear();
                // add that new player this empty list of the highest scores
                maxPlayers.add(player);

            }
            else if (player.getScore() == listOfPlayers.get(ind_max_so_far).getScore()) { // if new player has equal score
                // add that the new player to the list of the highest scores so far
                maxPlayers.add(player);
            }
        }
        Player [] maxArrayPlayers = new Player[maxPlayers.size()];
        for (int i = 0; i < maxPlayers.size(); i++) {     // convert arraylist to array
            maxArrayPlayers[i] = maxPlayers.get(i);
        }
        return maxArrayPlayers;                           // returns an Array of Players that could be just one or two people


    }

    public void addTile(Game game, String letter){
        Player player = game.getCurrentPlayer();
        for (int i=0; i<PlayerManager.getHand(player).length; i++){
            Cell cell = PlayerManager.getHand(player)[i];
            if (cell == null) {
                PlayerManager.getHand(player)[i] = new Cell(letter, 0); // removes tile
                return;

            }
        }

    }

}


