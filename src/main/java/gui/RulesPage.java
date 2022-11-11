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
    Label rulesTitleLabel, rulesHeaderLabel, rulesTextLabel;
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

        rulesTitleLabel = new Label();
        rulesTitleLabel.createLabel(30,50, 40,WIDTH-100,200, dialogueBox.f, "Revised Rules of Scrabble", Color.BLACK);
        rulesTitleLabel.setCentreAlignment();

        rulesHeaderLabel = new Label();
        rulesHeaderLabel.createLabel(16,50, 100, WIDTH-100,30, dialogueBox.f, "These rules were revised from the official Hasbro Rules of Scrabble", Color.BLACK);
        rulesHeaderLabel.setCentreAlignment();

        File rules = new File("src/main/java/gui/resources/revised_rules_of_scrabble.md");
        Scanner reader = new Scanner(rules);
        String finalString = "";

        while(reader.hasNextLine()){
            String data = reader.nextLine();
            System.out.println(data);
            finalString = finalString + data + "\n";
        }

        rulesTextLabel = new Label();
        rulesTextLabel.createMultiLineLabel(12,30, 200, WIDTH-100,500, dialogueBox.f, finalString, Color.BLACK);
    }
}


