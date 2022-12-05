package gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * The DialogueBox class creates a dialog box based on the JFrame module of Java Swing.
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

public class DialogueBox {
    public JFrame frame;


    /**
     * Creates a JFrame UI component as per the specs provided
     *
     * @param boxTitle the title of the dialogue box
     * @param width    the width of the dialogue box
     * @param height   the height of the dialogue box
     * @param exitCond the exit condition of the dialogue box
     */
    public void createDialogueBox(String boxTitle, int width, int height, boolean exitCond) {
        frame = new JFrame(); // create the frame
        
        Color c = new Color(255, 255, 255); // set the frame to a white colour
        // Setting background color for JFrame
        frame.getContentPane().setBackground(c);
        frame.setLayout(null);
        frame.setTitle(boxTitle); // set the frame to the title
        frame.setSize(width, height);
        frame.setVisible(true);
        // allows us to set whether we want to close an application or not
        if (exitCond) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
    }

}

