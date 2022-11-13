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
    TextField letterPlayed, coordinate;

    Button createGameButton, endGameButton;
    final int BOARD_DIM = 450; // dimension of the board (can be changed)
    final int BOARD_ROWS = 15; // same as columns
    final int WIDTH = 1000; // width of the frame
    final int HEIGHT = 700; // height of the frame

    public ArrayList<String> letters;
    public ArrayList<int[]> coordinates;

    public void createGame() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Game Page", WIDTH, HEIGHT, false);
        dialogueBox.f.setVisible(true);
        // we want to ignore the exit when we close only the rules page
        dialogueBox.f.setResizable(false);
        Color col = new Color(255,230,230);
        dialogueBox.f.getContentPane().setBackground(col);

        // add title label for rules box
        gamePageTitle = new Label();
        gamePageTitle.createLabel(30,10, 40,WIDTH-100,40, dialogueBox.f, "Play Scrabble", Color.BLACK);
        gamePageTitle.setCentreAlignment();

        // add title label for rules box
        gamePageLabel = new Label();
        gamePageLabel.createLabel(16,10, 100,WIDTH/4,20, dialogueBox.f, "Indicate where you want to play a tile: ", Color.BLACK);
        gamePageLabel.setCentreAlignment();

        letterPlayed = new TextField();
        letterPlayed.createTextField(10, 120, WIDTH/4,20, dialogueBox.f, "letter");
        coordinate = new TextField();
        coordinate.createTextField(10, 140, WIDTH/4,20, dialogueBox.f, "coordinate in x, y");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.f, "Play Move", 10, 180, 100,30, null);
        createGameButton.getButton().addActionListener(this);

        endGameButton = new Button();
        endGameButton.createButton(dialogueBox.f, "End Game", WIDTH-150, HEIGHT-100, 100,30, null);
        endGameButton.getButton().addActionListener(this);
    }

    /**
     * Creates an initial board on the frame
     * @param boundX bounds of the x coords
     * @param boundY bounds of the y coords
     */
    public void createInitialBoard(int boundX, int boundY) {
        Button letter = new Button();

        // determine whether the path is set correctly
        String path = "src/main/java/gui/resources/letters/wood.jpg";
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
    }

    // helper method to update the game when a letter has been played by a player
    public void playLetter(String value, int[] coord, JButton button){
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

//        letters.add(value);
//        coordinates.add(coord);

        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();

        // check if button has been pressed
        Object actionSource = e.getSource();

        // check if we need to start a new game
        if(s.equals("Play Move")){
            System.out.println("new start game button pressed");
            // get text field information
            String s1 = letterPlayed.textField.getText();
            String s2 = coordinate.textField.getText();
            System.out.println(s1); //prints into console the letter played
            System.out.println(s2); //prints into console the text played

            createInitialBoard(300,100); // create the starting board

            // refresh the page to allow the board to be visible
            dialogueBox.f.setVisible(true);
            dialogueBox.f.setResizable(false);

        }
        else if(s.equals("End Game")){
            // end game
            // TODO: add action after ending game
            System.out.println("end game button pressed");
            dialogueBox.f.dispose(); // close dialogue box permanently
        }
        // if it is neither starting or ending, check to see if it's a move played
        else if(actionSource instanceof JButton) {
            JButton source = (JButton) e.getSource(); // cast button to a button

            String location = source.getName();
            // System.out.println(location); // print out location of button
            String[] yxLoc = location.split(" ");
            int yLoc = Integer.parseInt(yxLoc[0]); // determine the y location
            int xLoc = Integer.parseInt(yxLoc[1]); // determine the x location
            System.out.println("" + yLoc + " " + xLoc); // print out location

            String s1 = letterPlayed.textField.getText(); // get the letter value

            // create an array consisting of yLoc and xLoc
            int[] coord = new int[]{yLoc, xLoc};
            playLetter(s1, coord, source);
//            System.out.println("letters: " + Arrays.toString(letters));
        }
    }
}


