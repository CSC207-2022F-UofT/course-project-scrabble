package games_manager;

import entities.LetterBag;
import entities.Player;

public interface DrawTiles { // interface for the draw tile use case
    public void drawTile(Player player, LetterBag bag);
    public void swapHand(Player player, LetterBag bag);
    public void drawHand(Player player, LetterBag bag);
}
