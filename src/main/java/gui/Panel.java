package gui;

import javax.swing.*;
import java.awt.*;

public class Panel {
    JPanel panel;
    Button letter;
    final int BOARD_DIM = 400;
    final int BOARD_ROWS = 15; // same as columns
    /**
     * @return returns a Java Swing panel
     */
    public JPanel getPanel() {
        return panel;
    }

    public void createPanel(int boundX, int boundY, JFrame dialogueBox) {
        panel = new JPanel();
        System.out.println("creating new panel");
//        label.setText(convertToMultiline(labelText));
        panel.setBounds(boundX, boundY, BOARD_DIM, BOARD_DIM);
        panel.setBackground(Color.lightGray);
        if (dialogueBox != null) {
            dialogueBox.add(panel);
        }
    }

    public void createDemoBoard(int boundX, int boundY, JFrame dialogueBox){
        Button letter = new Button();

        String path = "src/main/java/gui/resources/letters/A.jpg";
        java.net.URL imgURL = getClass().getResource(path);
        if(imgURL != null){
            System.out.println("successful path");
        }
        else{
            System.out.println("unsuccessful path");
        }

        ImageIcon icon = new ImageIcon(path);
        letter.createButton(dialogueBox, "",boundX,boundY,BOARD_DIM/BOARD_ROWS, BOARD_DIM/BOARD_ROWS, icon);
    }
}
