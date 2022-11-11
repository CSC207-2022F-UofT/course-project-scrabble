package gui;

import javax.swing.*;
import java.awt.*;

public class Label {
    JLabel label;

    /**
     * @return returns a Java Swing label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Creates a label and (optionally) adds it to an existing Dialog Box.
     * @param dialogueBox indicates which
     * @param labelText the input text that we want displayed
     * @param foregroundColor the colour on the foreground that we want on the label.
     */
    public void createLabel(int size, int boundX, int boundY, int boundWidth, int boundHeight, JFrame dialogueBox, String labelText, Color foregroundColor) {
        label = new JLabel(labelText);
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        label.setFont(new Font("serif", Font.PLAIN, size));
        label.setForeground(foregroundColor);
        if (dialogueBox != null) {
            dialogueBox.add(label);
        }
    }
    public void setCentreAlignment(){
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
