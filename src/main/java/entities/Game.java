package entities;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Receives inputs from GUI
 * Sends display instructions to GUI
 * Calls GameCreator if needed
 * Holds all the instances of entities and remembers game state.
 * @author Clark & Jazli
*/

public class Game implements Serializable { 

    private final GameBoard gameBoard;
    private final List<Player> players;
    private int turn;
    private final LetterBag letterBag;

    /**
     * This method is responsible for being the constructor of the Cell class with no parameters
     */
    public Game() {
        gameBoard = new GameBoard();
        players = new ArrayList<>();
        turn = 0;
        letterBag = new LetterBag();
    }

    /**
     * This method is responsible for being the constructor of the Cell class passed with a value and multiplier
     * @param p Player object that will be added to the game.
     */

    public void addPlayer(Player p) {
        players.add(p);
    }

    /**
     * This method is responsible for adding a new player to the game.
     * @return GameBoard object that is returned.
     */

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * This method is responsible for returning the LetterBag of the game.
     * @return LetterBag object that is returned.
     */

    public LetterBag getLetterBag() {
        return letterBag;
    }

    /**
     * This method is responsible for returning the Players of the game.
     * @return List of Players that is returned.
     */
    
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * This method is responsible for returning the current turn of the game.
     * @return List of Players that is returned.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * This method is responsible for returning the current Player of the game from the turn.
     * @return Player that is returned from Players.
     */
    public Player getCurrentPlayer() {
        return players.get(turn%players.size());
    }

    /**
     * This method is responsible for increasing the turn count by one.
     */
    public void incrementTurn() {
        turn++;
    }
}
