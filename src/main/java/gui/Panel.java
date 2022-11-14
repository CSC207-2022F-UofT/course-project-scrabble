package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//        label.setText(convertToMultiline(labelText));
        panel.setBounds(boundX, boundY, width, height);
        panel.setBackground(Color.lightGray);
        if (dialogueBox != null) {
            dialogueBox.add(panel);
        }
    }

}
