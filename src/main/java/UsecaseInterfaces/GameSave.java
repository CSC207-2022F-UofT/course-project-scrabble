package UsecaseInterfaces;

import entities.*;

import java.io.File;

public interface GameSave {
    final static File filename = new File("src/main/java/data/data.ser");

    public void saveGame(Game game);

}