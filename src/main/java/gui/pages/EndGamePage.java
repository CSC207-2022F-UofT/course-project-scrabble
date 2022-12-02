package gui.pages;

import gui.components.DialogueBox;
import gui.components.Label;

import java.awt.*;

/**
 * The EndGamePage is the final page after the game is completed. It displays the final result of the match with the player's information and who won.
 * @author Victor Zheng
 * @version 1.0
 */

public class EndGamePage {
    DialogueBox dialogueBox;
    Label player1Label, player2Label, winnerLabel, welcomeTitle;
    private final String player1Name;
    private final String player2Name;
    public int player1Score;
    public int player2Score;
    public String winner;
    final int WIDTH = 500;
    final int HEIGHT = 300;

    // requires the player information and also who won the match
    public EndGamePage(int player1Score, int player2Score, String player1Name, String player2Name, String winner){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.winner = winner;
    }

    public void createEndGamePage() { // throw an exception because we are reading a file
        // create a dialogue box for the entire page
        dialogueBox = new DialogueBox();
        dialogueBox.createDialogueBox("End of Game", WIDTH, HEIGHT, false);
        dialogueBox.frame.setVisible(true);
        dialogueBox.frame.setResizable(false);
        Color col = new Color(230, 240, 200);
        dialogueBox.frame.getContentPane().setBackground(col);

        // add title label for rules box
        welcomeTitle = new Label();
        welcomeTitle.createLabel(30, 10, 40, WIDTH - 100, 40, dialogueBox.frame, "Congratulations!", Color.BLACK);
        welcomeTitle.setCentreAlignment();

        // add label for player 1
        player1Label = new Label();
        player1Label.createLabel(16, 10, 100, WIDTH / 4, 20, dialogueBox.frame, player1Name + "'s Score: " + player1Score, Color.BLACK);
        player1Label.setCentreAlignment();

        // add label for player 2
        player2Label = new Label();
        player2Label.createLabel(16, 10, 120, WIDTH / 4, 20, dialogueBox.frame, player2Name + "'s Score: " + player2Score, Color.BLACK);
        player2Label.setCentreAlignment();

        winnerLabel = new Label();
        winnerLabel.createLabel(16, 10, 150, WIDTH - 100, 30, dialogueBox.frame, "The winner is: " + winner, Color.BLACK);
        winnerLabel.setCentreAlignment();
    }
}


