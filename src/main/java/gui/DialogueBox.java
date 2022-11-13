package gui;

import javax.swing.*;
import java.awt.*;

public class DialogueBox {
    JFrame f;

    /**
     * Returns class variable jframe
     * @return
     */
    public JFrame getJframe() {
        return f;
    }

//    public StartupPage() {
//
//        JFrame f = new JFrame("Scrabble");
//        JTextField t1, t2;
//        t1 = new JTextField("Player 1 Name");
//        t1.setBounds(50,50,150,20);
//
//        t2 = new JTextField("Player 2 Name");
//        t2.setBounds(50,150,150,20);
//        f.add(t1); f.add(t2);
//
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
    /**
     * Creates a JFrame UI component as per the specs provided
     * @param boxTitle the title of the dialogue box
     * @param width the width of the dialogue box
     * @param height the height of the dialogue box
     */
    public void createDialogueBox(String boxTitle, int width, int height, boolean exitCond) {
        f = new JFrame("Scrabble Project");
        Color c = new Color(240, 255, 255);
        // Setting background color for JFrame
        f.getContentPane().setBackground(c);
        f.setLayout(null);
        f.setTitle(boxTitle);
        f.setSize(width, height);
        f.setVisible(true);
        // allows us to set whether we want to close an application or not
        if (exitCond) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public static void main(String[] args){
//        new SwingDemo();
    }

}

