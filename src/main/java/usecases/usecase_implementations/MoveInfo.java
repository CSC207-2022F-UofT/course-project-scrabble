package usecases.usecase_implementations;

/**
 * This class is responsible for storing moves made during a turn.
 * @author Davit
 */
public class MoveInfo {
    // variables for x coordinate, y coordinate and string letter of move
    private int y;
    private int x;
    private String letter;

    public MoveInfo(int[] coordinates, String letter){
        this.y = coordinates[0];
        this.x = coordinates[1];
        this.letter = letter;
    }

    public int getY() {
        return this.y; //returns the y coordinate
    }

    public int getX() {
        return this.x; //returns the x coordinate
    }

    public String getLetter() {
        return this.letter; //returns the letter value
    }
}
