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
    private final String player1Name;
    private final String player2Name;
    public int player1Score;
    public int player2Score;
    public GamePage(String player1Name, String player2Name, boolean newGame){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        if(newGame){
            initializeScore();
        }
    }
    public void initializeScore(){
        this.player1Score = 0;
        this.player2Score = 0;
    }
    public void setScore(int player1Score, int player2Score){
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    DialogueBox dialogueBox;
    Label gamePageLabel, gamePageTitle, player1Label, player2Label;
    TextField letterPlayed;
    final static String[] STARTING_LETTERS = new String[]{"A", "C", "H", "I", "E", "V", "E"};
    private String[] currentLetters;
    int boundX, boundY;

    ArrayList<JButton> holderButtons = new ArrayList<>();
//    Button[] oldHolderButtons = new Button[7]; // save the older copy of the holder buttons
    private String clickedValue;

    Button createGameButton, endGameButton, swapHands, recallTiles;
    final int BOARD_DIM = 450; // dimension of the board (can be changed)
    final int BOARD_ROWS = 15; // same as columns
    final int WIDTH = 1000; // width of the frame
    final int HEIGHT = 700; // height of the frame

//    private ArrayList<String> letters = new ArrayList<String>();
//    private ArrayList<int[]> coordinates = new ArrayList<int[]>();
    public ArrayList<String> letters = new ArrayList<>();
    public ArrayList<int[]> coordinates = new ArrayList<>();

    public ArrayList<int[]> getCoordinates(){
        return coordinates;
    }
    public ArrayList<String> getLetters(){
        return letters;
    }

    public void createGame() {
        //create the new game object
        //create the new game page
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
        gamePageLabel.createLabel(16, 10, 100, WIDTH / 4, 20, dialogueBox.f, "Welcome to scrabble!", Color.BLACK);
        gamePageLabel.setCentreAlignment();

        // add label for player 1
        player1Label = new Label();
        player1Label.createLabel(16, 10, 160, WIDTH / 4, 20, dialogueBox.f, player1Name + "\'s Score: " + player1Score, Color.BLACK);
        player1Label.setCentreAlignment();

        // add label for player 1
        player2Label = new Label();
        player2Label.createLabel(16, 10, 200, WIDTH / 4, 20, dialogueBox.f, player2Name + "\'s Score: " + player2Score, Color.BLACK);
        player2Label.setCentreAlignment();


        // letterPlayed = new TextField();
        // letterPlayed.createTextField(10, 120, WIDTH / 4, 20, dialogueBox.f, "A");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.f, "Play Move", WIDTH - 300, HEIGHT - 100, 100, 30, null);
        createGameButton.getButton().addActionListener(this);

        recallTiles = new Button();
        recallTiles.createButton(dialogueBox.f, "Recall Tiles", WIDTH - 450, HEIGHT - 100, 100, 30, null);
        recallTiles.getButton().addActionListener(this);

        endGameButton = new Button();
        endGameButton.createButton(dialogueBox.f, "End Game", WIDTH - 150, HEIGHT - 100, 100, 30, null);
        endGameButton.getButton().addActionListener(this);

        swapHands = new Button();
        swapHands.createButton(dialogueBox.f, "Swap Hands", WIDTH - 625, HEIGHT - 100, 120, 30, null);
        swapHands.getButton().addActionListener(this);

        currentLetters = STARTING_LETTERS; // assign the current letters to the starting letters at the start

        boundX = 300; // set the x and y bounds at the start for the scrabble board
        boundY = 50;
        createInitialBoard(); // create the starting board

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
            System.out.println("successful path: " + path);
        } else {
            System.out.println("unsuccessful path: " + path);
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
     */
    public void createInitialBoard() {
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

        Button holderButton = new Button();
        // create holders for buttons
        int yBound = boundY + BOARD_DIM + 50;
        // create a holder for the tiles to start
        for(int i = 0; i < 7; i++){
            int xBound = boundX + BOARD_DIM/4 + BOARD_DIM/BOARD_ROWS * i;
            icon = createImageIcon(currentLetters[i] + ".jpg");
            holderButton.createButtonWithID(dialogueBox.f, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "holder " + i + " " + currentLetters[i]);
            holderButton.getButton().addActionListener(this);
        }
    }

    /**
     * Resets the tiles to the original state
     *
     */
    public void resetHolder() {
        // collect the components from the dialogue box's content pane
        Component[] components = dialogueBox.f.getContentPane().getComponents();
        System.out.println("num of components: " + components.length);
        for (Component component : components){ // iterate through each component in the frame
            // check if the component is a button, whether it has a name, and whether it starts with holder
            if(component instanceof JButton && component.getName()!= null && component.getName().startsWith("holder")){
                System.out.println(component.getName());
                // we want to make the button back visible for the user
                component.setVisible(true);
            }
            // checks if the holderButtons arraylist contains the button. We want to reset it by reverting the button to  the original state
            if(holderButtons.contains(component)){
                System.out.println("NEED TO REVERT");
                System.out.println(component.getName());
                JButton b = (JButton) component; // cast the button to a JButton.
                b.setIcon(createIcon("wood")); // set the icon back to the original empty state
                b.setVisible(true); // set the visibility back to true for viewing
                holderButtons.remove(b);
            }
        }
        // remove the letters and coordinates from the list of words
        letters.removeAll(letters); // remove the current move on the docket.
        coordinates.removeAll(coordinates); // remove all current coordinates on the docket

        // reset current moves played
        printLettersAndCoordinates(); // check if updated

        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);
    }

    /**
     * Plays the specified move and updates the button
     *
     * @param value the letter that we want played
     * @param coord the [y, x] coords of the letter
     */
    // helper method to update the game when a letter has been played by a player
    public void playLetter(String value, int[] coord, JButton button) {
        holderButtons.add(button);

        button.setIcon(createIcon(value)); // set the button to the letter's icon

        letters.add(value);
        coordinates.add(coord);

        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);
    }

    /**
     * @return an ImageIcon file and returns the resized icon version.
     * @param value is the name of the file
     */
    public ImageIcon createIcon(String value){
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
        return icon; // return the icon
    }

    /**
     * Prints the letter and its coordinates
     */
    public void printLettersAndCoordinates() {
        if (letters.size() == 0){
            System.out.println("No letters");
        }
        for (int i = 0; i < letters.size(); i++) {
            System.out.println("Letter " + letters.get(i) + " played at coordinate: " + Arrays.toString(coordinates.get(i)));
        }
    }
    
    @Override
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
        else if (s.equals("Recall Tiles")){
            System.out.println("recall tiles button pressed");
            resetHolder();
        }
        else if (s.equals("Swap Hands")) {
            System.out.println("swap hands button pressed");
        }
        // if it is neither starting or ending, check to see if it's a move played
        else if (actionSource instanceof JButton) {
            JButton source = (JButton) e.getSource(); // cast button to a button

            String buttonClick = source.getName();

            // if the button was not clicked and it starts with holder
            if(buttonClick.startsWith("holder") && clickedValue == null){
                System.out.println("holder pressed");
                String[] holderLetter = buttonClick.split(" ");
                clickedValue = holderLetter[2];
                // source.setIcon(createImageIcon("wood.jpg"));
                // source.setName("empty"); // we set the button name to empty to prevent additional presses
                source.setVisible(false);
            }

            else {
                // if the button was not clicked and it doesn't start with holder
                if(clickedValue != null && !buttonClick.startsWith("holder")){
//                    if (!source.getName().equals("empty")){
                        // System.out.println(location); // print out location of button
                    String[] yxLoc = buttonClick.split(" ");
                    int yLoc = Integer.parseInt(yxLoc[0]); // determine the y location
                    int xLoc = Integer.parseInt(yxLoc[1]); // determine the x location
                    System.out.println("" + yLoc + " " + xLoc); // print out location

                    // create an array consisting of yLoc and xLoc
                    int[] coord = new int[]{yLoc, xLoc};
                    playLetter(clickedValue, coord, source);

                    printLettersAndCoordinates(); // print out the moves that were played
                    clickedValue = null;

                }
            }
        }
    }
}


