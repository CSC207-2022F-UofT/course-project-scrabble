package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class RulesPage {
    DialogueBox dialogueBox;
    Label welcomeTitle, contributors;
    final int WIDTH = 500;
    final int HEIGHT = 1000;
    public static void main(String[] args) {
        new StartupPage();
    }

    public void createRulesPage() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Games Rules", WIDTH, HEIGHT);
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.f.setResizable(false);
        Color col = new Color(255,240,240);

        dialogueBox.f.getContentPane().setBackground(col);

        welcomeTitle = new Label();
        welcomeTitle.createLabel(30,0, HEIGHT/4,500,200, dialogueBox.f, "Revised Rules of Scrabble", Color.BLACK);

        contributors = new Label();
        contributors.createLabel(12,0, HEIGHT/6, 500,30, dialogueBox.f, "These rules were revised from the official Hasbro Rules of Scrabble", Color.BLACK);
        contributors.setCentreAlignment();
    }

}


