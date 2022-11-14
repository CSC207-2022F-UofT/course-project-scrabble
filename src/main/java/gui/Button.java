package gui;

import javax.swing.*;

public class Button {
    JButton button;

    /**
     * Returns class variable button
     *
     * @return returns the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Creates a JButton UI component with an image icon
     *
     * @param dialogueBox the dialogue box we want to add this to
     * @param buttonText  the button's text
     * @param icon        the icon that we want to add to the button (can be optional)
     * @param boundX      bounds of the x coords
     * @param boundY      bounds of the y coords
     * @param boundWidth  width of the button
     * @param boundHeight height of the button
     */
    public void createButton(JFrame dialogueBox, String buttonText, int boundX,
                             int boundY, int boundWidth, int boundHeight, ImageIcon icon) {

        if (icon == null) { // if the image is null, then we don't add the image
            button = new JButton(buttonText);
        } else { // if the image is not null, we add the image to the button
            button = new JButton(buttonText, icon);
        }
        button.setBounds(boundX, boundY, boundWidth, boundHeight);
        dialogueBox.add(button);
    }

    /**
     * Creates a JButton UI component with an image icon and an id.
     * With an id, the button can have no text, and still be clickable.
     *
     * @param dialogueBox the dialogue box we want to add this to
     * @param buttonText  the button's text
     * @param icon        the icon that we want to add to the button (can be optional)
     * @param boundX      bounds of the x coords
     * @param boundY      bounds of the y coords
     * @param boundWidth  width of the button
     * @param boundHeight height of the button
     * @param id          id of the button we want to assign
     */
    public void createButtonWithID(JFrame dialogueBox, String buttonText, int boundX,
                                   int boundY, int boundWidth, int boundHeight, ImageIcon icon, String id) {

        if (icon == null) {
            button = new JButton(buttonText);
        } else {
            button = new JButton(buttonText, icon);
        }
        button.setBounds(boundX, boundY, boundWidth, boundHeight);
        button.setName(id); // set the id
        dialogueBox.add(button);
    }
}