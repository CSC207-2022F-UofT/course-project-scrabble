package gui;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    JFrame f;
    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    public StartGame(){
        f = new JFrame("Scrabble Game");
        JLabel label = new JLabel("Welcome to Scrabble");
        label.setBounds(WIDTH / 3,0,500,200);
        label.setFont(new Font("serif", Font.PLAIN, 40));
        JLabel contributers = new JLabel("Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark", SwingConstants.CENTER);
//        JLabel contributers = new JLabel("Created by: Victor, Jazli, Umair, Claire, Francisco, Davit, and Clark");
        contributers.setBounds(WIDTH/4, HEIGHT/2, 500,30);
        contributers.setAlignmentX(Component.CENTER_ALIGNMENT);

        f.add(contributers); f.add(label);
        f.setSize(WIDTH,HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new StartGame();
    }
}
