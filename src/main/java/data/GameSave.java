package data;

import entities.GameBoard;
import entities.LetterBag;
import entities.Player;

import java.io.File;

public interface GameSave {
    final static File filename = new File("src/main/java/data/data.ser");

    public void saveGame(GameBoard board, Player p1, Player p2, LetterBag bag);

}