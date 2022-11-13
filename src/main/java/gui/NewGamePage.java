package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePage implements ActionListener {
    DialogueBox dialogueBox;
    Label playerLabel1, playerLabel2, newGamePageTitle;
    TextField t1, t2;

    Button createGameButton;

    final int WIDTH = 500;
    final int HEIGHT = 400;
    public static void main(String[] args) {
        new StartupPage();
    }

    public void createGamePage() {
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("Create A New Game!", WIDTH, HEIGHT, false);
        dialogueBox.f.setVisible(true);
        // we may want to ignore the exit when we close only the rules page
        // dialogueBox.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogueBox.f.setResizable(false);
        Color col = new Color(255,255,240);
        dialogueBox.f.getContentPane().setBackground(col);

        // add title label for rules box
        newGamePageTitle = new Label();
        newGamePageTitle.createLabel(30,50, 40,WIDTH-100,40, dialogueBox.f, "Create a new Game", Color.BLACK);
        newGamePageTitle.setCentreAlignment();

        // add title label for rules box
        playerLabel1 = new Label();
        playerLabel1.createLabel(16,50, 100,WIDTH/4,20, dialogueBox.f, "Player 1 Name: ", Color.BLACK);
        playerLabel1.setCentreAlignment();

        // add header label for rules box
        playerLabel2 = new Label();
        playerLabel2.createLabel(16,50, 140, WIDTH/4,30, dialogueBox.f, "Player 2 Name: ", Color.BLACK);
        playerLabel2.setCentreAlignment();

        t1 = new TextField();
        t1.createTextField(200, 100, WIDTH/4,20, dialogueBox.f, "Player 1");
        t2 = new TextField();
        t2.createTextField(200, 140, WIDTH/4,20, dialogueBox.f, "Player 2");

        createGameButton = new Button();
        createGameButton.createButton(dialogueBox.f, "Start Game", 200, 180, WIDTH/4,30, null);
        createGameButton.getButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(s.equals("Start Game")){
            System.out.println("start game button pressed");
            // TODO: game is now created
            dialogueBox.f.dispose(); // close dialogue box permanently
        }
    }
}


