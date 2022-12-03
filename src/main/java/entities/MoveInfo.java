package entities;

/**
 * This class is responsible for storing moves made during a turn.
 * @author Davit
 */
public class MoveInfo {
    // variables for x coordinate, y coordinate and string letter of move
    private int y;
    private int x;
    private String letter;

    /**
     * This method is responsible for being the constructor of the MoveInfo class given coordinates and a letter.
     * @param coordinates int array that represents the x and y coordinates of a move.
     * @param letter String value representing the letter of the move.
     */
    public MoveInfo(int[] coordinates, String letter){
        this.y = coordinates[0];
        this.x = coordinates[1];
        this.letter = letter;
    }

    /**
     * This method is responsible for retuning the y coordinate of the move.
     * @return int y value representing the y coordinate.
     */
    public int getY() {
        return this.y; //returns the y coordinate
    }

    /**
     * This method is responsible for retuning the x coordinate of the move.
     * @return int x value representing the x coordinate.
     */
    public int getX() {
        return this.x; //returns the x coordinate
    }

    /**
     * This method is responsible for retuning the letter value of the move.
     * @return String letter value representing the letter of the move.
     */
    public String getLetter() {
        return this.letter; //returns the letter value
    }
}
