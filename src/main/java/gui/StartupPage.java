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

    public void createStartupPage() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Game", WIDTH, HEIGHT, true);
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.f.setResizable(false);
        Color col = new Color(200,255,255);
        dialogueBox.f.getContentPane().setBackground(col);

        welcomeTitle = new Label();
        welcomeTitle.createLabel(30,WIDTH / 2 - 130,50,500,50, dialogueBox.f, "Welcome to Scrabble", Color.BLACK);

        contributors = new Label();
        contributors.createLabel(12,WIDTH/2 - 150, HEIGHT/4 - 20, 350,20, dialogueBox.f, "Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", Color.BLACK);
        contributors.setCentreAlignment();

        int buttonOffset = 75;
        gameButton = new Button();
        gameButton.createButton(dialogueBox.f, "Start Game", WIDTH/3 + buttonOffset, HEIGHT/3, 200,50, null);
        gameButton.getButton().addActionListener(this);

        rulesButton = new Button();
        rulesButton.createButton(dialogueBox.f, "Rules", WIDTH/3 + buttonOffset, HEIGHT/2, 200,50, null);
        rulesButton.getButton().addActionListener(this);

        createButton = new Button();
        createButton.createButton(dialogueBox.f, "Create Game", WIDTH/3 + buttonOffset, HEIGHT - 200, 200,50, null);
        createButton.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println((e.getActionCommand()));
        if (e.getActionCommand().equals("Start Game")){
            System.out.println("Start game button pressed");
        }
        else if (e.getActionCommand().equals("Rules")){
            System.out.println("Rules button pressed");
            RulesPage rules = new RulesPage();
            try {
                rules.createRulesPage();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}


