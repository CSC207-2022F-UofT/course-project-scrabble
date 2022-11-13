package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel implements ActionListener {
    JPanel panel;
    Button letter;
    final int BOARD_DIM = 450;
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

        String path = "src/main/java/gui/resources/letters/wood.jpg";
        java.net.URL imgURL = getClass().getResource(path);
        if(imgURL != null){
            System.out.println("successful path");
        }
        else{
            System.out.println("unsuccessful path");
        }

        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage(); // scale image to fit the board size
        Image newImg = image.getScaledInstance(BOARD_DIM/BOARD_ROWS, BOARD_DIM/BOARD_ROWS, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);

        // attempt to make entire board full of buttons
        for(int i = 0; i < BOARD_ROWS; i++){
            int yBound = boundY + BOARD_DIM/BOARD_ROWS * i;
            for(int j = 0; j < BOARD_ROWS; j++){
                int xBound = boundX + BOARD_DIM/BOARD_ROWS * j;
                System.out.println("" + xBound + " " + yBound);
                letter.createButtonWithID(dialogueBox, "",xBound, yBound,BOARD_DIM/BOARD_ROWS, BOARD_DIM/BOARD_ROWS, icon, "" + i + " " + j);
                letter.getButton().addActionListener(this);
//                dialogueBox.setVisible(true);
            }
        }
        System.out.println("done");
//        letter.createButton(dialogueBox, "",boundX,boundY,BOARD_DIM/BOARD_ROWS, BOARD_DIM/BOARD_ROWS, icon);
    }
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand()); // useless
        System.out.println(e.getSource()); // interestingly, this gives us the location. y followed by x coordinate
        System.out.println(e.getID()); // useless

//        if(s.equals("")){
//            System.out.println("tile pressed");
//            System.out.println();
            // get text field information
//            String s1 = t1.textField.getText();
//            String s2 = t2.textField.getText();
//            System.out.println(s1); //prints into console the name of player 1
//            System.out.println(s2); //prints into console the name of player 2
        }
}
