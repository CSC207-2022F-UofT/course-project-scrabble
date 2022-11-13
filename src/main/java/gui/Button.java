package gui;

import javax.swing.*;

public class Button {
    JButton button;

    /**
     * Returns class variable button
     * @return returns the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Creates a JButton UI component with an image icon
     * @param dialogueBox the dialogue box we want to add this to
     * @param buttonText the button's text
     * @param icon the icon that we want to add to the button (can be optional)
     * @param boundX bounds of the x coords
     * @param boundY bounds of the y coords
     * @param boundWidth width of the button
     * @param boundHeight height of the button
     */
    public void createButton(JFrame dialogueBox, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight, ImageIcon icon) {

        if(icon == null){
            button = new JButton(buttonText);
        }else{
            button = new JButton(buttonText, icon);
        }
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
        dialogueBox.add(button);
    }
}