package gui;

import javax.swing.*;

public class StartupPage {
    JFrame f;

    public StartupPage() {

        JFrame f = new JFrame("Scrabble");
        JTextField t1, t2;
        t1 = new JTextField("Player 1 Name");
        t1.setBounds(50,50,150,20);

        t2 = new JTextField("Player 2 Name");
        t2.setBounds(50,150,150,20);
        f.add(t1); f.add(t2);

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new SwingDemo();
    }

}