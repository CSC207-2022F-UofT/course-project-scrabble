package entities;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/*
Receives inputs from GUI
Sends display instructions to GUI
Calls GameCreator if neeeded
Holds all the instances of entitis and remembers gamestate.
*/

public class Game implements Serializable { 

    private final GameBoard gameBoard;
    private final List<Player> players;
    private int turn;
    private final LetterBag letterBag;
    
    public Game() {
        gameBoard = new GameBoard();
        players = new ArrayList<>();
        turn = 0;
        letterBag = new LetterBag();
    }
    
    public void addPlayer(Player p) {
        players.add(p);
    }
    
    public GameBoard getGameBoard() {
        return gameBoard;
    }
    
    public LetterBag getLetterBag() {
        return letterBag;
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public Player getCurrentPlayer() {
        return players.get(turn%players.size());
    }
    
    public void incrementTurn() {
        turn++;
    }
}
