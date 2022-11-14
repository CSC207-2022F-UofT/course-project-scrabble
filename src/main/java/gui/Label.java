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
     *
     * @param dialogueBox     indicates which
     * @param labelText       the input text that we want displayed
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
    /**
     * Creates a multiline label.
     *
     * @param dialogueBox     indicates which
     * @param labelText       the input text that we want displayed
     * @param foregroundColor the colour on the foreground that we want on the label.
     */
    public void createMultiLineLabel(int size, int boundX, int boundY, int boundWidth, int boundHeight, JFrame dialogueBox, String labelText, Color foregroundColor) {
        label = new JLabel();
        label.setText(convertToMultiline(labelText)); // convert label to a multiline label
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        label.setFont(new Font("serif", Font.PLAIN, size));
        label.setForeground(foregroundColor);
        if (dialogueBox != null) {
            dialogueBox.add(label);
        }
    }
    /**
     * Returns a string that can be printed on multiiple lines via the JLabel
     *
     * @param orig takes in a String that we want to convert to a multiline printable label
     */
    public static String convertToMultiline(String orig) {
        return ("<html>" + orig.replaceAll("\n", "<br>"));
    }

    /**
     *  Sets the contents of the label to the centre of the label
     */
    public void setCentreAlignment() {
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
