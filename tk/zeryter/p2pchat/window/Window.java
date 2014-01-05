package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 25/12/13
 */

public class Window implements Runnable, ComponentListener {

    JFrame frame = new JFrame();
    Image icon;


    @Override
    public void run() {
        //Default icon
        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Set basic frame
        frame.setSize(200,300);
        frame.setIconImage(icon);
        frame.setTitle("[null title]");
        frame.addComponentListener(this);
        frame.setVisible(true);
        frame.addWindowListener(new WindowMonitor());

        init();

    }

    @Override
    public void componentResized(ComponentEvent e) {
        draw();
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}


    public void init() {

    }

    public void draw() {

    }

}

class WindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        P2PChatMain.running = false;
        e.getWindow().setVisible(false);
        System.exit(0);
    }
}
