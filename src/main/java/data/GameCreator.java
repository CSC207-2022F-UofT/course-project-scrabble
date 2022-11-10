package data;

import entities.*;

public class GameCreator extends GameLoader{
    public static Object[] newGame(String name1, String name2){
        // method to initialize all variables needed to play a new game and returned as an array of objects
        GameBoard board = new GameBoard();
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        LetterBag letterBag = new LetterBag();
        return new Object[]{board, player1 ,player2, letterBag};
    }
}
