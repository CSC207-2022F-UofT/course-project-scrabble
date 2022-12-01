package Usecases.usecase_interfaces;

import entities.Game;
import java.io.File;

/**
* This interface is responsible for saving the Game instance to the created file in "src/main/java/data/data.ser".
* @author Jazli
*/

public interface GameSaveUsecase {
    final static String filename = "src/main/java/data/data.ser";

    public void saveGame(Game game);

}
