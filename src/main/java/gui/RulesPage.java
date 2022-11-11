package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RulesPage {
    DialogueBox dialogueBox;
    Label rulesTitle, rulesHeader;
    final int WIDTH = 500;
    final int HEIGHT = 1000;
    public static void main(String[] args) {
        new StartupPage();
    }

    public void createRulesPage() throws FileNotFoundException {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Games Rules", WIDTH, HEIGHT);
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.f.setResizable(false);
        Color col = new Color(255,240,240);

        dialogueBox.f.getContentPane().setBackground(col);

        rulesTitle = new Label();
        rulesTitle.createLabel(30,0, 40,500,200, dialogueBox.f, "Revised Rules of Scrabble", Color.BLACK);

        rulesHeader = new Label();
        rulesHeader.createLabel(12,0, 100, 500,30, dialogueBox.f, "These rules were revised from the official Hasbro Rules of Scrabble", Color.BLACK);
        rulesHeader.setCentreAlignment();

        File rules = new File("src/main/java/gui/resources/revised_rules_of_scrabble.md");
        Scanner reader = new Scanner(rules);
        while(reader.hasNextLine()){
            String data = reader.nextLine();
            System.out.println(data);
        }
    }
}


