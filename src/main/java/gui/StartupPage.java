package gui;

import javax.swing.*;
import java.awt.*;

public class StartupPage {
    DialogueBox dialogueBox;
    Label welcomeTitle, contributers;
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

        contributers = new Label();
        contributers.createLabel(12,WIDTH/3, HEIGHT/4, 500,30, dialogueBox.f, "Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", Color.BLACK);
        contributers.setCentreAlignment();

//        StartGameButton sgb = new StartGameButton();
//        sgb.gameButton.setBounds(WIDTH/2, HEIGHT/2, 100,100);

//        dialogueBox.f.add(sgb.gameButton);
//        dialogueBox.f.add(sgb.tf);
    }
}


