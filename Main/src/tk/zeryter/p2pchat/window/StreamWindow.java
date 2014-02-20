package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class StreamWindow implements Runnable, ActionListener {

    JFrame frame = new JFrame();
    Image icon;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(300,400);
        frame.setTitle("Stream Selection");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.addWindowListener(new StreamWindowMonitor());
        frame.setResizable(false);

        Container c = new Container();
        frame.add(c);
        c.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        c.validate();
    }

    public void actionPerformed(ActionEvent e) {

    }
}

class StreamWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        //w.dispose();
        w.setVisible(false);
    }
}
