package gui.pages;

import gui.components.TextField;
import gui.components.DialogueBox;
import gui.components.Label;
import gui.components.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The NewGamePage is the page that creates a new game based on the user's player names
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

public class NewGamePage implements ActionListener {
    DialogueBox dialogueBox;
    Label playerLabel1, playerLabel2, newGamePageTitle;
    TextField t1, t2;

    Button createGameButton;

    final int WIDTH = 500;
    final int HEIGHT = 400;

    public void createGamePage() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Create A New Game!", WIDTH, HEIGHT, false);
        dialogueBox.frame.setVisible(true);
        // we may want to ignore the exit when we close only the rules page
        // dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.frame.setResizable(false);
        Color col = new Color(255, 255, 240);
        dialogueBox.frame.getContentPane().setBackground(col);

        // add title label for rules box
        newGamePageTitle = new Label();
        newGamePageTitle.createLabel(30, 50, 40, WIDTH - 100, 40, dialogueBox.frame, "Create a new Game", Color.BLACK);
        newGamePageTitle.setCentreAlignment();

        // add title label for rules box
        playerLabel1 = new Label();
        playerLabel1.createLabel(16, 50, 100, WIDTH / 4, 20, dialogueBox.frame, "Player 1 Name: ", Color.BLACK);
        playerLabel1.setCentreAlignment();

        // add header label for rules box
        playerLabel2 = new Label();
        playerLabel2.createLabel(16, 50, 140, WIDTH / 4, 30, dialogueBox.frame, "Player 2 Name: ", Color.BLACK);
        playerLabel2.setCentreAlignment();

        t1 = new TextField();
        t1.createTextField(200, 100, WIDTH / 4, 20, dialogueBox.frame, "Player 1");
        t2 = new TextField();
        t2.createTextField(200, 140, WIDTH / 4, 20, dialogueBox.frame, "Player 2");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.frame, "Start Game", 200, 180, WIDTH / 4, 30, null);
        createGameButton.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Start Game")) {
            System.out.println("new start game button pressed");
            // get text field information
            String s1 = t1.textField.getText();
            String s2 = t2.textField.getText();
            System.out.println(s1); //prints into console the name of player 1
            System.out.println(s2); //prints into console the name of player 2

            // create game page using the players information
            GamePage game = new GamePage(s1, s2, true);
            game.createGame(false);

            dialogueBox.frame.dispose(); // close dialogue box permanently
        }
    }
}


