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
    final int WIDTH = 1100;
    final int HEIGHT = 750;

    public static void main(String[] args) {
        new StartupPage();
    }

    public void createRulesPage() throws FileNotFoundException { // throw an exception because we are reading a file
        // create a dialogue box for the entire page
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Scrabble Games Rules", WIDTH, HEIGHT, false);
        dialogueBox.f.setVisible(true);
        dialogueBox.f.setResizable(false);
        Color col = new Color(255, 240, 240);
        dialogueBox.f.getContentPane().setBackground(col);

        // add title label for rules box
        rulesTitleLabel = new Label();
        rulesTitleLabel.createLabel(30, 50, 40, WIDTH - 100, 30, dialogueBox.f, "Revised Rules of Scrabble", Color.BLACK);
        rulesTitleLabel.setCentreAlignment();

        // add header label for rules box
        rulesHeaderLabel = new Label();
        rulesHeaderLabel.createLabel(16, 50, 100, WIDTH - 100, 30, dialogueBox.f, "These rules were revised from the official Hasbro Rules of Scrabble", Color.BLACK);
        rulesHeaderLabel.setCentreAlignment();

        // add rules to the rules page from the revised rules of scrabble page we made
        File rules = new File("src/main/java/gui/resources/revised_rules_of_scrabble.txt");
        Scanner reader = new Scanner(rules);
        StringBuilder finalString = new StringBuilder();

        // read line by line the file
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            // System.out.println(data); // print the rules in the console
            finalString.append(data).append("\n"); // add a new line to allow the label to print it all
        }

        // set rules text
        rulesTextLabel = new Label();
        // create a label that is multiline and shows all the rules
        rulesTextLabel.createMultiLineLabel(12, 30, 60, WIDTH - 50, HEIGHT - 50, dialogueBox.f, finalString.toString(), Color.BLACK);
    }
}


