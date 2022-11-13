package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePage implements ActionListener {
    DialogueBox dialogueBox;
    Label gamePageLabel, gamePageTitle;
    TextField letterPlayed, coordinate;

    Button createGameButton, endGameButton;

    final int WIDTH = 600;
    final int HEIGHT = 700;

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
        gamePageTitle.createLabel(30,50, 40,WIDTH-100,40, dialogueBox.f, "Play Scrabble", Color.BLACK);
        gamePageTitle.setCentreAlignment();

        // add title label for rules box
        gamePageLabel = new Label();
        gamePageLabel.createLabel(16,50, 100,WIDTH/4,20, dialogueBox.f, "Drag and drop moves onto the board: ", Color.BLACK);
        gamePageLabel.setCentreAlignment();

        letterPlayed = new TextField();
        letterPlayed.createTextField(200, 100, WIDTH/4,20, dialogueBox.f, "Letter played");
        coordinate = new TextField();
        coordinate.createTextField(200, 140, WIDTH/4,20, dialogueBox.f, "Coordinate");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.f, "Play Move", 200, 180, WIDTH/4,30, null);
        createGameButton.getButton().addActionListener(this);

        endGameButton = new Button();
        endGameButton.createButton(dialogueBox.f, "End Game", WIDTH-150, HEIGHT-100, 100,30, null);
        endGameButton.getButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(s.equals("Play Move")){
            System.out.println("new start game button pressed");
            // get text field information
            String s1 = letterPlayed.textField.getText();
            String s2 = coordinate.textField.getText();
            System.out.println(s1); //prints into console the name of player 1
            System.out.println(s2); //prints into console the name of player 2
            // TODO: game board updates
            // using graphics hasn't worked yet
            // DisplayGraphics graphics = new DisplayGraphics();
            // dialogueBox.f.add(graphics);
            Panel panel = new Panel();
            panel.createPanel(100, 200, WIDTH/2,200, dialogueBox.f);

            // after changes, the dialogue box has to be updated.
            dialogueBox.f.setVisible(true);
            dialogueBox.f.setResizable(false);
        }
        if(s.equals("End Game")){
            // end game
            // TODO: add action after ending game
            System.out.println("end game button pressed");
            dialogueBox.f.dispose(); // close dialogue box permanently
        }
    }
}


