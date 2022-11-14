package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePage implements ActionListener {
    DialogueBox dialogueBox;
    Label gamePageLabel, gamePageTitle;
    TextField letterPlayed;
    final static String[] STARTING_LETTERS = new String[]{"A", "C", "H", "I", "E", "V", "E"};

    Button createGameButton, endGameButton;
    final int BOARD_DIM = 450; // dimension of the board (can be changed)
    final int BOARD_ROWS = 15; // same as columns
    final int WIDTH = 1000; // width of the frame
    final int HEIGHT = 700; // height of the frame

    public ArrayList<String> letters = new ArrayList<String>();
    public ArrayList<int[]> coordinates = new ArrayList<int[]>();

    public void createGame() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Game Page", WIDTH, HEIGHT, false);
        dialogueBox.f.setVisible(true);
        // we want to ignore the exit when we close only the rules page
        dialogueBox.f.setResizable(false);
        Color col = new Color(255, 230, 230);
        dialogueBox.f.getContentPane().setBackground(col);

        // add title label for rules box
        gamePageTitle = new Label();
        gamePageTitle.createLabel(30, 10, 40, WIDTH - 100, 40, dialogueBox.f, "Play Scrabble", Color.BLACK);
        gamePageTitle.setCentreAlignment();

        // add title label for rules box
        gamePageLabel = new Label();
        gamePageLabel.createLabel(16, 10, 100, WIDTH / 4, 20, dialogueBox.f, "Indicate which letter you want to play and its location: ", Color.BLACK);
        gamePageLabel.setCentreAlignment();

        letterPlayed = new TextField();
        letterPlayed.createTextField(10, 120, WIDTH / 4, 20, dialogueBox.f, "A");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.f, "Play Move", WIDTH - 300, HEIGHT - 100, 100, 30, null);
        createGameButton.getButton().addActionListener(this);

        endGameButton = new Button();
        endGameButton.createButton(dialogueBox.f, "End Game", WIDTH - 150, HEIGHT - 100, 100, 30, null);
        endGameButton.getButton().addActionListener(this);

        createInitialBoard(300, 50); // create the starting board

        // refresh the page to allow the board to be visible
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);

    }

    /**
     * Creates an imageIcon based on the file name
     *
     * @param filename the file name that we want to create
     */
    public ImageIcon createImageIcon(String filename){
        // determine whether the path is set correctly
        String path = "src/main/java/gui/resources/letters/" + filename;
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            System.out.println("successful path");
        } else {
            System.out.println("unsuccessful path");
        }

        // create an ImageIcon to display as the button image
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage(); // scale image to fit the board size
        // make sure that the image is the same size as the button
        Image newImg = image.getScaledInstance(BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, Image.SCALE_SMOOTH);
        // replace old imageIcon with the new one
        icon = new ImageIcon(newImg);
        return icon;
    }

    /**
     * Creates an initial board on the frame
     *
     * @param boundX bounds of the x coords
     * @param boundY bounds of the y coords
     */
    public void createInitialBoard(int boundX, int boundY) {
        Button letter = new Button();

        ImageIcon icon = createImageIcon("wood.jpg");

        // make entire board full of buttons 15x15 buttons
        for (int i = 0; i < BOARD_ROWS; i++) { // start with the buttons on the y axis
            int yBound = boundY + BOARD_DIM / BOARD_ROWS * i;
            for (int j = 0; j < BOARD_ROWS; j++) {
                int xBound = boundX + BOARD_DIM / BOARD_ROWS * j; // buttons on the x axis
                // System.out.println("" + xBound + " " + yBound); // debugging code to allow for printing values
                letter.createButtonWithID(dialogueBox.f, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "" + i + " " + j);
                letter.getButton().addActionListener(this); // add listener to the button to see when it gets pressed
            }
        }

        int yBound = boundY + BOARD_DIM + 50;
        // create a holder for the tiles to start
        for(int i = 0; i < 7; i++){
            int xBound = boundX + BOARD_DIM/4 + BOARD_DIM/BOARD_ROWS * i;
            icon = createImageIcon(STARTING_LETTERS[i] + ".jpg");
            letter.createButtonWithID(dialogueBox.f, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "holder" + i);
            letter.getButton().addActionListener(this);
        }
    }

    /**
     * Plays the specified move and updates the button
     *
     * @param value the letter that we want played
     * @param coord the [y, x] coords of the letter
     */
    // helper method to update the game when a letter has been played by a player
    public void playLetter(String value, int[] coord, JButton button) {
        // convert value to the path
        String path = "src/main/java/gui/resources/letters/" + value + ".jpg"; // indicates which image to select from
        System.out.println("path: " + path);
        // create an ImageIcon to display as the button image
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage(); // scale image to fit the board size
        // make sure that the image is the same size as the button
        Image newImg = image.getScaledInstance(BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, Image.SCALE_SMOOTH);
        // replace old imageIcon with the new one
        icon = new ImageIcon(newImg);
        button.setIcon(icon);

        letters.add(value);
        coordinates.add(coord);

        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);
    }

    /**
     * Prints the letter and its coordinates
     */
    public void printLettersAndCoordinates() {
        for (int i = 0; i < letters.size(); i++) {
            System.out.println("Letter " + letters.get(i) + " played at coordinate: " + Arrays.toString(coordinates.get(i)));
        }
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // check if button has been pressed
        Object actionSource = e.getSource();

        // check if we need to start a new game
        if (s.equals("Play Move")) {
            System.out.println("play move button pressed");
            // TODO: what to do after play move is submitted
        } else if (s.equals("End Game")) {
            // end game
            // TODO: add action after ending game
            System.out.println("end game button pressed");
            dialogueBox.f.dispose(); // close dialogue box permanently
        }
        // if it is neither starting or ending, check to see if it's a move played
        else if (actionSource instanceof JButton) {
            JButton source = (JButton) e.getSource(); // cast button to a button

            String buttonClick = source.getName();

            if(buttonClick.startsWith("holder")){
                System.out.println("holder pressed");
            }
            else {
                // System.out.println(location); // print out location of button
                String[] yxLoc = buttonClick.split(" ");
                int yLoc = Integer.parseInt(yxLoc[0]); // determine the y location
                int xLoc = Integer.parseInt(yxLoc[1]); // determine the x location
                System.out.println("" + yLoc + " " + xLoc); // print out location

                String s1 = letterPlayed.textField.getText(); // get the letter value

                // create an array consisting of yLoc and xLoc
                int[] coord = new int[]{yLoc, xLoc};
                playLetter(s1, coord, source);

                printLettersAndCoordinates(); // print out the moves that were played
            }
        }
    }
}


