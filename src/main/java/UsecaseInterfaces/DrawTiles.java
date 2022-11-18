package UsecaseInterfaces;

import entities.Game;

public interface DrawTiles { // interface for the draw tile use case
    public void drawTile(Game game);
    public void swapHand(Game game);
    public void drawHand(Game game);
}
