package gui;

import javax.swing.*;
import java.awt.*;

public class DisplayGraphics extends Canvas {
    Graphics graphics;

    // testing out how to use this. still not sure TODO: determine if this is possible / how to use
    public Graphics getGraphics() {
        return graphics;
    }

    public void paint(Graphics g){
        g.fillRect(130,30,100,80);
        g.drawOval(30,130,50,40);
    }
}