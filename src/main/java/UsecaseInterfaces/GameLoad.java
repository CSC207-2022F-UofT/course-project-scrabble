package UsecaseInterfaces;

import java.io.File;
import entities.Game;

public interface GameLoad {
    final static File filename = new File("src/main/java/data/data.ser");
    public Game loadGame();
}
