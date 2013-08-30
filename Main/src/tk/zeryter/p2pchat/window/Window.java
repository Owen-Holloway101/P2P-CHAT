//Owen Holloway GYC
package tk.zeryter.p2pchat.window;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

import tk.zeryter.p2pchat.P2PChatMain;



public class Window implements Runnable, ComponentListener {

    Container container = new Container();

    GUI gui = new GUI();

    Image icon;

    JFrame window;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        window = new JFrame("P2P-Chat (swarm chat)");
        window.setSize(600, 600);
        window.add(container);
        container.setBounds(0, 0, window.getWidth(), window.getHeight());
        gui.init(container);
        window.setResizable(true);
        window.setVisible(true);
        window.setIconImage(icon);
        window.addWindowListener(new WindowMonitor());
        window.addComponentListener(this);
        gui.draw(container);
    }

    public void componentResized(ComponentEvent e) {
        //Resizes window elements when window size is changed
        if (window.getWidth() < 400) {
            window.setSize(400,window.getHeight());
        }
        if (window.getHeight() < 400) {
            window.setSize(window.getWidth(),400);
        }
        gui.draw(container);
    }

    public void componentMoved(ComponentEvent e) {}

    public void componentShown(ComponentEvent e) {}

    public void componentHidden(ComponentEvent e) {}
}
