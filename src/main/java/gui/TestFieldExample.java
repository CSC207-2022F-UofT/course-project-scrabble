package gui;

import javax.swing.*;

// testing file for testing Java Text Field example

public class TestFieldExample {
    TestFieldExample() {
        JFrame f = new JFrame("Scrabble Game");
        JTextArea ta = new JTextArea("Welcome to the area");
        ta.setBounds(50, 50, 100, 200);
        f.add(ta);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFieldExample();
    }
}