package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartupPage implements ActionListener {
    DialogueBox dialogueBox;
    Label welcomeTitle, contributors;
    Button gameButton, rulesButton;
    final int WIDTH = 1000;
    final int HEIGHT = 600;
    public static void main(String[] args) {
        new StartupPage();
    }

    public void createStartupPage() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Game", WIDTH, HEIGHT);
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.f.setResizable(false);
        Color col = new Color(20,255,255);
        dialogueBox.f.getContentPane().setBackground(col);

        welcomeTitle = new Label();
        welcomeTitle.createLabel(30,WIDTH / 3,0,500,200, dialogueBox.f, "Welcome to Scrabble", Color.BLACK);

        contributors = new Label();
        contributors.createLabel(12,WIDTH/3, HEIGHT/4, 500,30, dialogueBox.f, "Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", Color.BLACK);
        contributors.setCentreAlignment();

        gameButton = new Button();
        gameButton.createButton(dialogueBox.f, "Start Game", WIDTH/3, HEIGHT/3, 200,50, null);
        gameButton.getButton().addActionListener(this);

        rulesButton = new Button();
        rulesButton.createButton(dialogueBox.f, "Rules", WIDTH/3, HEIGHT/2, 200,50, null);
        rulesButton.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println((e.getActionCommand()));
        if (e.getActionCommand().equals("Start Game")){
            System.out.println("Start game button pressed");
        }
        else if (e.getActionCommand().equals("Rules")){
            System.out.println("Rules button pressed");
        }
    }
}


