package tk.zeryter.p2pchat.window;

import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    Canvas canvas = new Canvas();

    //define buttons, textfields, etc ...



    public void init(Container container) {
        //Initialise things


        //Canvas .. leave this here
        container.add(canvas);
    }

    public void draw(Container container) {
        //Set the size of objects, runs when the window is resized and on creation


        //canvas for painting on
        canvas.setBounds(0,0,container.getWidth(),container.getHeight());
    }

    public void actionPerformed(ActionEvent e) {
        //Action event for when buttons are pressed, etc ...

    }
}
