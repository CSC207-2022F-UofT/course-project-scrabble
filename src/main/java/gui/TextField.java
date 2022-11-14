package gui;

import javax.swing.*;
import java.awt.*;

public class TextField {
    JTextField textField;

    /**
     * @return returns a Java Swing textField
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * Creates a label and (optionally) adds it to an existing Dialog Box.
     *
     * @param dialogueBox   indicates which place to add the text field
     * @param textFieldText the input text that we want displayed
     */
    public void createTextField(int boundX, int boundY, int boundWidth, int boundHeight, JFrame dialogueBox, String textFieldText) {
        textField = new JTextField(textFieldText);
        textField.setBounds(boundX, boundY, boundWidth, boundHeight);
        // textField.setFont(new Font("serif", Font.PLAIN, size));
        if (dialogueBox != null) {
            dialogueBox.add(textField);
        }
    }
}
