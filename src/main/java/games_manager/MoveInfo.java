package GamesManager;
// helper class used in BoardManager functions
public class MoveInfo {
    private int y;
    private int x;
    private String letter;

    public MoveInfo(int[] coordinates, String letter){
        this.y = coordinates[0];
        this.x = coordinates[1];
        this.letter = letter;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public String getXLetter() {
        return this.letter;
    }
}
