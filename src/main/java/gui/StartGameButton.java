package gui;

import java.awt.event.*;
import javax.swing.*;

public class StartGameButton{
    JButton gameButton;
    JTextField tf;

    public StartGameButton(){
        this.tf = new JTextField();
        this.gameButton = new JButton("Start Game");
        this.gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Good luck, have fun!");
                System.out.println("button pressed!");
            }
        });
    }
}
