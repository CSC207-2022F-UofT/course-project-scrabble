package gui;

import javax.swing.*;
import java.awt.*;

public class Panel {
    JPanel panel;
    /**
     * @return returns a Java Swing panel
     */
    public JPanel getPanel() {
        return panel;
    }

    public void createPanel(int boundX, int boundY, int boundWidth, int boundHeight, JFrame dialogueBox) {
        panel = new JPanel();
        System.out.println("creating new panel");
//        label.setText(convertToMultiline(labelText));
        panel.setBounds(boundX, boundY, boundWidth, boundHeight);
        panel.setBackground(Color.lightGray);
        if (dialogueBox != null) {
            dialogueBox.add(panel);
        }
    }
}
