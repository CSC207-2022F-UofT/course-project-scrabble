package gui;

import javax.swing.*;
import java.awt.*;

public class DialogueBox {
    JFrame f;

    /**
     * Returns the dialogueBox JFrame
     */
    public JFrame getJFrame() {
        return f;
    }

    /**
     * Creates a JFrame UI component as per the specs provided
     *
     * @param boxTitle the title of the dialogue box
     * @param width    the width of the dialogue box
     * @param height   the height of the dialogue box
     */
    public void createDialogueBox(String boxTitle, int width, int height, boolean exitCond) {
        f = new JFrame(); // create the frame
        Color c = new Color(255, 255, 255); // set the frame to a white colour
        // Setting background color for JFrame
        f.getContentPane().setBackground(c);
        f.setLayout(null);
        f.setTitle(boxTitle); // set the frame to the title
        f.setSize(width, height);
        f.setVisible(true);
        // allows us to set whether we want to close an application or not
        if (exitCond) {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public static void main(String[] args) {
    }

}

