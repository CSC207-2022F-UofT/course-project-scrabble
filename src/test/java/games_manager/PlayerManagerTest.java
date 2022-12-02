package games_manager;

import Usecases.usecase_implementations.PlayerManager;
import data_gateways.GameCreator;
import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class PlayerManagerTest {
    
    @Test
    public void updateCurrentPlayerScoreTest() {
        Game game = new Game();
        PlayerManager p_manager = new PlayerManager();
        Player p1 = new Player("Jeff");
        game.addPlayer(p1);
        p_manager.updateScoreForCurrentPlayer(10, game);
        Assertions.assertEquals(10, game.getPlayers().get(0).getScore());
    }

}
