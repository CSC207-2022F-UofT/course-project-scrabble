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

    /**
     * Creates a Panel using the JPanel Java Swing
     * @param dialogueBox the dialogue box we want to add this to
     * @param boundX bounds of the x coords
     * @param boundY bounds of the y coords
     */
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

//    /**
//     * Creates an initial board on the panel dimensions
//     * @param dialogueBox the dialogue box we want to add this to
//     * @param boundX bounds of the x coords
//     * @param boundY bounds of the y coords
//     */
//    public void createInitialBoard(int boundX, int boundY, JFrame dialogueBox) {
//        Button letter = new Button();
//
//        // determine whether the path is set correctly
//        String path = "src/main/java/gui/resources/letters/wood.jpg";
//        java.net.URL imgURL = getClass().getResource(path);
//        if (imgURL != null) {
//            System.out.println("successful path");
//        } else {
//            System.out.println("unsuccessful path");
//        }
//
//        // create an ImageIcon to display as the button image
//        ImageIcon icon = new ImageIcon(path);
//        Image image = icon.getImage(); // scale image to fit the board size
//        // make sure that the image is the same size as the button
//        Image newImg = image.getScaledInstance(BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, Image.SCALE_SMOOTH);
//        // replace old imageIcon with the new one
//        icon = new ImageIcon(newImg);
//
//        // make entire board full of buttons 15x15 buttons
//        for (int i = 0; i < BOARD_ROWS; i++) { // start with the buttons on the y axis
//            int yBound = boundY + BOARD_DIM / BOARD_ROWS * i;
//            for (int j = 0; j < BOARD_ROWS; j++) {
//                int xBound = boundX + BOARD_DIM / BOARD_ROWS * j; // buttons on the x axis
//                // System.out.println("" + xBound + " " + yBound); // debugging code to allow for printing values
//                letter.createButtonWithID(dialogueBox, "", xBound, yBound, BOARD_DIM / BOARD_ROWS, BOARD_DIM / BOARD_ROWS, icon, "" + i + " " + j);
//                letter.getButton().addActionListener(this); // add listener to the button to see when it gets pressed
//            }
//        }
//    }

    // checks whenever the button gets pressed, and alerts the system
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e.getSource()); // interestingly, this gives us the location. y followed by x coordinate
//        Object actionSource = e.getSource();
//        if(actionSource instanceof JButton) {
//            JButton source = (JButton) e.getSource(); // cast button to a button
//
//            String location = source.getName();
//            // System.out.println(location); // print out location of button
//            String[] yxLoc = location.split(" ");
//            int yLoc = Integer.parseInt(yxLoc[0]); // determine the y location
//            int xLoc = Integer.parseInt(yxLoc[1]); // determine the x location
//            System.out.println("" + yLoc + " " + xLoc); // print out location
//        }
    }
}
