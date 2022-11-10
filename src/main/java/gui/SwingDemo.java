package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame{
    JFrame f;
    private JPanel panelMain;
    private JTextField player1Name;
    private JTextField player2Name;
    private JButton startGameButton;

    public SwingDemo() {
//        JLabel label1 = new JLabel("Welcome to Scrabble!");
//        add(label1);
        player1Name = new JTextField();
        player1Name.setBounds(50,50,150,20);

        JButton b = new JButton("Play Game"); // create a button to start the game
        b.setBounds(50,100,95,30);

        add(b);
        add(player1Name);

        setTitle("Scrabble");
        setSize(400   , 500);
        setVisible(true);
    }

    public static void main(String[] args){
        new SwingDemo();
    }

}
