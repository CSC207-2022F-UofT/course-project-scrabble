package gui;

import org.junit.Rule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Objects;

public class StartupPage implements ActionListener {
    DialogueBox dialogueBox;
    Label welcomeTitle, contributors;
    Button gameButton, rulesButton, createButton;
    final int WIDTH = 1000;
    final int HEIGHT = 600;

    public static void main(String[] args) {
        new StartupPage();
    }

    // Creates the startup page that we first see.
    public void createStartupPage() {
        dialogueBox = new DialogueBox(); // create dialogue box (the background)
        dialogueBox.createDialogueBox("Scrabble Game", WIDTH, HEIGHT, true); // name of the box
        dialogueBox.f.setVisible(true); // make it visible
        dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when someone hits the red x button
        dialogueBox.f.setResizable(false); // remove ability to resize frame
        Color col = new Color(200, 255, 255); // set colour
        dialogueBox.f.getContentPane().setBackground(col);

        welcomeTitle = new Label(); // create welcome title label
        welcomeTitle.createLabel(30, WIDTH / 2 - 130, 50, 500, 50, dialogueBox.f, "Welcome to Scrabble", Color.BLACK);

        contributors = new Label(); // create contributors label
        contributors.createLabel(12, WIDTH / 2 - 150, HEIGHT / 4 - 20, 350, 20, dialogueBox.f, "Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", Color.BLACK);
        contributors.setCentreAlignment();

        int buttonOffset = 75; // offset used for all 3 buttons to align in the centre
        gameButton = new Button(); // button for loading a game that we had already on file
        gameButton.createButton(dialogueBox.f, "Start Old Game", WIDTH / 3 + buttonOffset, HEIGHT / 3, 200, 50, null);
        gameButton.getButton().addActionListener(this);

        rulesButton = new Button(); // button for checking the rules of our game (they are different than the regular scrabble game)
        rulesButton.createButton(dialogueBox.f, "Rules", WIDTH / 3 + buttonOffset, HEIGHT / 2, 200, 50, null);
        rulesButton.getButton().addActionListener(this);

        createButton = new Button(); // button for creating a new game
        createButton.createButton(dialogueBox.f, "Create Game", WIDTH / 3 + buttonOffset, HEIGHT - 200, 200, 50, null);
        createButton.getButton().addActionListener(this);
    }

    // actionPeformed allows us to check when a button has been pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println((e.getActionCommand()));
        switch (e.getActionCommand()) {
            case "Create Game":
                // when the create game button has been pressed
                System.out.println("Create game button pressed");
                NewGamePage newGamePage = new NewGamePage(); // create a new game through the NewGamePage frame
                newGamePage.createGamePage();
                break;
            case "Rules":
                // when the rules button has been pressed
                System.out.println("Rules button pressed");
                RulesPage rules = new RulesPage(); // create a rules page to allow people to review the rules of the game
                try {
                    rules.createRulesPage();
                } catch (FileNotFoundException ex) { // we want to try to read the file, and catch any errors
                    throw new RuntimeException(ex);
                }   break;
            case "Start Old Game":
                System.out.println("Start old game button pressed");
                // TODO: determine what we can do to read from file a previous game
                break;
            default:
                break;
        }
    }
}


