package usecases.usecase_interfaces;

import entities.Game;

/**
* This interface is responsible for saving the Game instance to the created file in "src/main/java/data/data.ser".
* @author Jazli
*/

public interface GameSaveUsecase {
    String filename = "src/main/java/data/data.ser";

    void saveGame(Game game);

}
