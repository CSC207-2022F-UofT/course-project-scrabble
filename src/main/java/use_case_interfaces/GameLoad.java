package use_case_interfaces;

import java.io.File;
import entities.Game;

/**
* This interface is responsible for loading the Game instance from created file in "src/main/java/data/data.ser".
* @author Jazli
*/


public interface GameLoad {
    final static File filename = new File("src/main/java/data/data.ser");
    public Game loadGame();
}
