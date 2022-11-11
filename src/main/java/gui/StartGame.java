package gui;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    JFrame f;
    final int WIDTH = 1000;
    final int HEIGHT = 600;
    public StartGame(){
        f = new JFrame("Scrabble Game");
        JLabel label = new JLabel("Welcome to Scrabble");
        label.setBounds(WIDTH / 3,0,500,200);
        label.setFont(new Font("serif", Font.PLAIN, 40));
        JLabel contributors = new JLabel("Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", SwingConstants.CENTER);
        contributors.setBounds(WIDTH/4, HEIGHT/4, 500,30);
        contributors.setAlignmentX(Component.CENTER_ALIGNMENT);

        StartGameButton sgb = new StartGameButton();
        sgb.gameButton.setBounds(WIDTH/2, HEIGHT/2, 100,100);
        f.add(sgb.gameButton);
        f.add(sgb.tf);

        f.add(contributors); f.add(label);
        f.setSize(WIDTH,HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StartGame();
    }
}
