package gui.pages;

import entities.*;

import gui.components.DialogueBox;
import gui.components.Label;
import gui.components.Button;
import gui.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import ScrabbleGame.ScrabbleGameController;

public class GamePage implements ActionListener, View {
    private String player1Name;
    private String player2Name;
    public int player1Score;
    public int player2Score;

    private static int[][] TILE_MULTIPLIERS = new int[][]
            {{3,1,1,2,1,1,1,3,1,1,1,2,1,1,3},
                    {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
                    {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                    {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
                    {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
                    {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                    {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                    {3,1,1,2,1,1,1,1,1,1,1,2,1,1,3},
                    {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                    {1,3,1,1,1,3,1,1,1,3,1,1,1,3,1},
                    {1,1,1,1,2,1,1,1,1,1,2,1,1,1,1},
                    {2,1,1,2,1,1,1,2,1,1,1,2,1,1,2},
                    {1,1,2,1,1,1,2,1,2,1,1,1,2,1,1},
                    {1,2,1,1,1,3,1,1,1,3,1,1,1,2,1},
                    {3,1,1,2,1,1,1,3,1,1,1,2,1,1,3}};

    private ScrabbleGameController controller;
    
    public GamePage(String player1Name, String player2Name, boolean newGame){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        if(newGame){
            this.player1Score = 0;
            this.player2Score = 0;
        }
        controller = new ScrabbleGameController(this);
    }

    DialogueBox dialogueBox;
    Label gamePageLabel, gamePageTitle, player1Label, player2Label, turnLabel;
    final static String[] STARTING_LETTERS = new String[]{"A", "C", "H", "I", "E", "V", "E"};
    private String[] currentLetters;
    int boundX, boundY;

    ArrayList<JButton> playedButtons = new ArrayList<>();
    ArrayList<JButton> holderButtons = new ArrayList<>();
    private String clickedValue;

    Button createGameButton, endGameButton, swapHands, recallTiles, shuffleHand;
    final int BOARD_DIM = 600; // dimension of the board (can be changed)
    final int BOARD_ROWS = 15; // same as columns
    final int WIDTH = 1280; // width of the frame
    final int HEIGHT = 865; // height of the frame

    public ArrayList<String> letters = new ArrayList<>();
    public ArrayList<int[]> coordinates = new ArrayList<>();

    public ArrayList<int[]> getCoordinates(){
        return coordinates;
    }
    public ArrayList<String> getLetters(){
        return letters;
    }

    public void createGame(boolean fromFile) {
        //create the new game object
        //create the new game page
        dialogueBox = new DialogueBox();
        
        System.out.println("dialoguebox created");
        
        
        dialogueBox.createDialogueBox("Scrabble Game Page", WIDTH, HEIGHT, false);
        dialogueBox.frame.setVisible(true);
        // we want to ignore the exit when we close only the rules page
        dialogueBox.frame.setResizable(false);
        Color col = new Color(255, 230, 230);
        dialogueBox.frame.getContentPane().setBackground(col);

        // add title label for rules box
        gamePageTitle = new Label();
        gamePageTitle.createLabel(30, 10, 40, WIDTH - 100, 40, dialogueBox.frame, "Play Scrabble", Color.BLACK);
        gamePageTitle.setCentreAlignment();

        // add title label for rules box
        gamePageLabel = new Label();

        gamePageLabel.createLabel(16, 10, 100, WIDTH / 4, 20, dialogueBox.frame, "Welcome to Scrabble!", Color.BLACK);
		
        gamePageLabel.setCentreAlignment();

        // add label for player 1
        player1Label = new Label();
        player1Label.createLabel(16, 10, 160, WIDTH / 4, 20, dialogueBox.frame, player1Name + "\'s Score: " + player1Score, Color.BLACK);
        player1Label.setCentreAlignment();

        // add label for player 2
        player2Label = new Label();
        player2Label.createLabel(16, 10, 200, WIDTH / 4, 20, dialogueBox.frame, player2Name + "\'s Score: " + player2Score, Color.BLACK);
        player2Label.setCentreAlignment();

        // add label for who's turn it is
        turnLabel = new Label();
        // init with Player 1 Name
        turnLabel.createLabel(16, 10, 240, WIDTH / 4, 20, dialogueBox.frame, "It is " + player1Name + "'s turn!", Color.BLACK);
        turnLabel.setCentreAlignment();

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.frame, "Play Move", WIDTH - 300, HEIGHT - 100, 100, 30, null);
        createGameButton.getButton().addActionListener(this);

        recallTiles = new Button();
        recallTiles.createButton(dialogueBox.frame, "Recall Tiles", WIDTH - 450, HEIGHT - 100, 100, 30, null);
        recallTiles.getButton().addActionListener(this);

        endGameButton = new Button();
        endGameButton.createButton(dialogueBox.frame, "End Game", WIDTH - 150, HEIGHT - 100, 100, 30, null);
        endGameButton.getButton().addActionListener(this);

        swapHands = new Button();
        swapHands.createButton(dialogueBox.frame, "Swap Hands", WIDTH - 625, HEIGHT - 100, 120, 30, null);
        swapHands.getButton().addActionListener(this);

        shuffleHand = new Button();
        shuffleHand.createButton(dialogueBox.frame, "Shuffle Hand", WIDTH - 800, HEIGHT - 100, 120, 30, null);
        shuffleHand.getButton().addActionListener(this);

        //currentLetters = STARTING_LETTERS; // assign the current letters to the starting letters at the start

        boundX = 300; // set the x and y bounds at the start for the scrabble board
        boundY = 50;
        //createInitialBoard(); // create the starting board
        //createLetterHolder(); // create the initial letter holder at the bottom of the board

        // refresh the page to allow the board to be visible
        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
        
        // create the game
        String[] names = new String[]{player1Name, player2Name};
        if(fromFile){
            controller.createGameFromFile();
        }
        else{
            controller.startGame(names);
        }
    }

    /**
     * Creates an imageIcon based on the file name
     *
     * @param filename the file name that we want to create
     */
    public ImageIcon createImageIcon(String filename){
        // determine whether the path is set correctly
        String path = "src/main/java/gui/resources/letters/" + filename;
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
     * Creates a letter holder at the bottom of the board with all regular tiles
     */
    public void updateLetterHolder(){
        Button holderButton = new Button();
        // create holders for buttons
        int yBound = boundY + BOARD_DIM + 50;
        ImageIcon icon;

        // create a holder for the tiles to start
        for(int i = 0; i < currentLetters.length; i++){
            // create initial starting position with an increment for each tile
            int xBound = boundX + BOARD_DIM / 4 + BOARD_DIM / BOARD_ROWS * i;

            // for empty holders
            if(currentLetters[i].equals("-")){
                icon = createImageIcon("wood.jpg");
                holderButton.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "holder " + i + " -");
            }
            else {
                icon = createImageIcon(currentLetters[i] + ".jpg");
                holderButton.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "holder " + i + " " + currentLetters[i]);
            }


            holderButton.getButton().addActionListener(this);
            holderButtons.add(holderButton.button);
        }
        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
    }
    /**
     * Scuffles the current hand
     */
    public void shuffleHand(){
        // shuffle the current letters hand
        System.out.println("letters before and after");
        System.out.println(Arrays.toString(currentLetters));
        List<String> strList = Arrays.asList(currentLetters); // change array to list
        Collections.shuffle(strList);
        strList.toArray(this.currentLetters);
        System.out.println(Arrays.toString(currentLetters));

//        resetHolder(); // reset the holder in the view

        // initialize a counter to change the index to find the button
        int holderIndex = 0;
        // get the components and update the icons and names
        Component[] components = dialogueBox.frame.getContentPane().getComponents();
        for (Component component : components){ // iterate through each component in the frame
            // check if the component is a button, whether it has a name, and whether it starts with holder
            if(holderButtons.contains(component)){
                JButton b = (JButton) component; // cast the button to a JButton.
                if(currentLetters[holderIndex].equals("-")){
                    b.setIcon(createImageIcon("wood.jpg")); // set the icon back to the original empty state
                }
                else{
                    b.setIcon(createImageIcon(currentLetters[holderIndex] + ".jpg")); // set the icon back to the original empty state
                }
                String currentName = b.getName(); // get the current name of the button
                b.setName(currentName.substring(0,currentName.length() - 1) + currentLetters[holderIndex]); // set new name
                holderIndex += 1; // increase the holder index by 1

                b.setVisible(true); // set the visibility back to true for viewing
            }
        }

        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
    }
    /**
     * Deletes all the current buttons on the board and the holder
     */
    public void deleteBoard() {
        Component[] components = dialogueBox.frame.getContentPane().getComponents();
        for (Component component : components) { // iterate through each component in the frame
            // check if the component is a button, whether it has a name, and whether it starts with holder
            if (component instanceof JButton) {
                String name = component.getName();
                if (name != null){
                    // delete button
                    // length of a button index is less than 6
//                    System.out.println("Button: " + name + " " + name.length());
                    if(name.startsWith("holder") || name.length() < 6){
                        dialogueBox.frame.remove(component);
                    }
                }
//                ((JButton) component).removeAll();
            }
        }
        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
    }

    /**
     * Plays the specified move and updates the button
     *
     * @param value the letter that we want played
     * @param coord the [y, x] coords of the letter
     */
    // helper method to update the game when a letter has been played by a player
    public void playLetter(String value, int[] coord, JButton button) {
        playedButtons.add(button);
        // play the tile onto the board
        controller.placeTile(coord, value);

        button.setIcon(createImageIcon(value + ".jpg")); // set the button to the letter's icon
        letters.add(value);
        coordinates.add(coord);

        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
    }

    /**
     * Prints the letter and its coordinates
     */
    public void printLettersAndCoordinates() {
        if (letters.isEmpty()){
            System.out.println("No letters");
        }
        for (int i = 0; i < letters.size(); i++) {
            System.out.println("Letter " + letters.get(i) + " played at coordinate: " + Arrays.toString(coordinates.get(i)));
        }
    }

    /**
     * Creates a board based on the inputted board
     * @param game is the entire game that is passed into the coordinates
     */
    @Override
    public void updateView(Game game){
        // board deleted
        deleteBoard();

        System.out.println("----------Beginning of UpdateView--------------");
        // update scores of players
        List<Player> players = game.getPlayers();
        // we're going to assume only 2 players for version 1. Will try to implement multiple players in the future
        player1Name = players.get(0).getName();
        player1Score = players.get(0).getScore();
        player2Name = players.get(1).getName();
        player2Score = players.get(1).getScore();

        player1Label.getLabel().setText(player1Name + "'s score is: "  + Integer.toString(player1Score)); // set the name to the current player
        player2Label.getLabel().setText(player2Name + "'s score is: " + Integer.toString(player2Score)); // set the name to the current player

        System.out.println(player1Name + ": " + player1Score);
        System.out.println(player2Name + ": " +  player2Score);

        // get who's turn it is
        Player currentPlayer = game.getCurrentPlayer();
        // get the holder tiles
        Cell[] hand = currentPlayer.getHand();

        turnLabel.getLabel().setText("It is " + currentPlayer.getName() + "'s turn!"); // set the name to the current player

        String[] letters = new String[]{"-", "-", "-", "-", "-", "-", "-"};
        // update the entire hand with new letters or nothing if it's a dash.
        System.out.println("Printing hand");
        for(int i = 0; i<letters.length; i++){
            if(hand[i] == null){
                letters[i] = "-";
                System.out.println("null");
            }
            else{
                letters[i] = hand[i].getValue();
                System.out.println(hand[i].getValue());
            }
        }
        currentLetters = letters;
        System.out.println("current letters: " + Arrays.toString(currentLetters));

        // update cells
        GameBoard gameBoard = game.getGameBoard();
        gameBoard.printBoard();

        Button letter = new Button();
        int letterIndex = 0;
        ImageIcon icon;

        // calculate the middle coords
        int middleCoord = BOARD_ROWS/2;
        System.out.println(middleCoord);
        // create the middle icon
        ImageIcon middleIcon = createImageIcon("StarDesign.png");
        ImageIcon doubleIcon = createImageIcon("double.png");
        ImageIcon tripleIcon = createImageIcon("tripple.png");

        // iterate through the board rows to set the board based on the cells
        for(int i = 0; i<BOARD_ROWS; i++){
            int yBound = boundY + BOARD_DIM / BOARD_ROWS * i;
            // iterate through each letter index, add the letters back based on [j,i] coordinates
            for(int j = 0; j<BOARD_ROWS; j++) {
                String val = gameBoard.getBoardCellValue(i, j);

                int xBound = boundX + BOARD_DIM / BOARD_ROWS * j; // buttons on the x axis

                if((Objects.equals(val, "-"))){
                    icon = createImageIcon("wood.jpg");
                    // if the tile is in the middle and is empty, then we set is as the star
                    if(j == middleCoord && i == middleCoord){
                        letter.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, middleIcon, "" + i + " " + j);
                    }
                    else{
                        if(TILE_MULTIPLIERS[i][j] == 1){
                            letter.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "" + i + " " + j);
                        }
                        else if(TILE_MULTIPLIERS[i][j] == 2){
                            letter.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, doubleIcon, "" + i + " " + j);
                        }
                        else if(TILE_MULTIPLIERS[i][j] == 3){
                            letter.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, tripleIcon, "" + i + " " + j);
                        }
                    }
                }
                else{
                    icon = createImageIcon(val + ".jpg");
//                    letterIndex += 1;
                    System.out.println("ADDED LETTER: " + val);
                    letter.createButtonWithID(dialogueBox.frame, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "" + i + " " + j);
                }
                letter.getButton().addActionListener(this); // add listener to the button to see when it gets pressed
            }
        }
        updateLetterHolder(); // updates the letter holder
    }

    @Override
    public void updateVictoryScreen(Player[] winners) { // to be implemented 
        dialogueBox.frame.dispose(); // close dialogue box permanently
        // for now, we display the end game page
        String winner;
        String firstWinner = winners[0].getName();
        if (winners.length > 1){
            winner = "Tie";
        }
        else if (player1Name.equals(firstWinner)){
            winner = player1Name;
        }
        else{
            winner = player2Name;
        }
        EndGamePage endGamePage = new EndGamePage(player1Score, player2Score, player1Name,player2Name, winner);
        endGamePage.createEndGamePage();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("--------------------------------------------------------------- ACTION ------------------");
        String s = e.getActionCommand();

        // check if button has been pressed
        Object actionSource = e.getSource();

        // check if we need to start a new game
        if (s.equals("Play Move")) {
            System.out.println("play move button pressed");
            printLettersAndCoordinates();
            controller.playMove();
        }

        else if (s.equals("End Game")) {
            System.out.println("end game button pressed");
            controller.endGame();
        }

        else if (s.equals("Shuffle Hand")) {
            System.out.println("shuffle hand button pressed");
            shuffleHand();
        }

        else if (s.equals("Recall Tiles")){
            System.out.println("recall tiles button pressed");
//            resetHolder();
            if (!controller.checkFullHand()){
                controller.resetMove();
            }
        }

        else if (s.equals("Swap Hands")) {
            System.out.println("swap hands button pressed");
            controller.swapTiles();
        }

        // if it is neither starting or ending, check to see if it's a move played
        else if (actionSource instanceof JButton) {
            JButton source = (JButton) e.getSource(); // cast button to a button

            String buttonClick = source.getName();

            // if the button was not clicked and it starts with holder
            if(buttonClick.startsWith("holder") && clickedValue == null && !buttonClick.endsWith("-")){
                System.out.println("holder pressed");
                String[] holderLetter = buttonClick.split(" ");
                clickedValue = holderLetter[2];
                System.out.println(clickedValue);
                source.setVisible(false);
//                updateLetterHolder();
                dialogueBox.frame.setVisible(true);
            }
            else {
                // if the button was not clicked and it doesn't start with holder or an empty tile
                if(clickedValue != null && !buttonClick.startsWith("holder") && !buttonClick.endsWith("-")){
                    //if (!source.getName().equals("empty")){
                    // System.out.println(location); // print out location of button
                    String[] yxLoc = buttonClick.split(" ");
                    int yLoc = Integer.parseInt(yxLoc[0]); // determine the y location
                    int xLoc = Integer.parseInt(yxLoc[1]); // determine the x location
                    System.out.println("" + yLoc + " " + xLoc); // print out location

                    // create an array consisting of yLoc and xLoc
                    int[] coord = new int[]{yLoc, xLoc};

                    playLetter(clickedValue, coord, source);
                    clickedValue = null; // set the button to be ready for next turn
                    printLettersAndCoordinates(); // print out the moves that were played
//                    }
                }
            }
        }
    }
}


