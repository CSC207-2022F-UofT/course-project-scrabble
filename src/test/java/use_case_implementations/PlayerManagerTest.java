package use_case_implementations;

import usecases.usecase_implementations.PlayerManager;
import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerManagerTest {

    /**
     * Tests updateCurrentPlayerScore by updating it with score 10 and comparing it to one another using getScore.
     */
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
