package data;

import entities.GameBoard;
import entities.LetterBag;
import entities.Player;

public class GameCreator {
    public static void newGame(String name1, String name2){
        // method to initialize all variables needed to play a new game
        GameBoard board = new GameBoard();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        LetterBag letterBag = new LetterBag();

    }
    public static void loadGame(){
        // method to initialize all variables needed to play game from data
        Object[] objects = GameLoader.load();
        GameBoard board = (GameBoard) objects[0];
        Player player1 = (Player) objects[1];
        Player player2 = (Player) objects[2];
        LetterBag letterBag = (LetterBag) objects[3];
    }
}
