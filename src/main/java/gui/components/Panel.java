package gui.components;

import javax.swing.*;
import java.awt.*;

/**
 * The Panel class creates a panel based on the JButton module of Java Swing.
 * @author Victor Zheng
 * @version 1.0
 * @since 2022-11-19
 */

public class Panel {
    JPanel panel;

    /**
     * @return returns a Java Swing panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Creates a Panel using the JPanel Java Swing
     *
     * @param dialogueBox the dialogue box we want to add this to
     * @param boundX      bounds of the x coords
     * @param boundY      bounds of the y coords
     */
    public void createPanel(int boundX, int boundY, int width, int height, JFrame dialogueBox) {
        panel = new JPanel();
        System.out.println("creating new panel");
        panel.setBounds(boundX, boundY, width, height);
        panel.setBackground(Color.lightGray);
        if (dialogueBox != null) {
            dialogueBox.add(panel);
        }
    }

}
