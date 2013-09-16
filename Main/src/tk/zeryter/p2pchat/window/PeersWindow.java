//Owen Holloway GYC
package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;
import tk.zeryter.p2pchat.Vairables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class PeersWindow implements Runnable, ActionListener {

    JFrame frame = new JFrame();

    Image icon;

    public static boolean reopened = false;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(300, 90);
        frame.setTitle("Encryption");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.addWindowListener(new PeersWindowMonitor());
        frame.setResizable(false);
        frame.requestFocus();
        Container c = new Container();
        frame.add(c);
        c.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        if (EncryptionWindow.reopened) {
            gui_reinit(c);
        } else {

            gui_init(c);
            reopened = true;
        }
        gui_draw(c);

        frame.validate();

    }

    //GUI widgets


    void gui_init(Container c) {

        c.setLayout(null);

    }

    void gui_reinit(Container c) {

        frame.setVisible(true);
    }

    void gui_draw(Container c) {

        c.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
    }

    public void actionPerformed(ActionEvent e) {

    }
}

class PeersWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        //w.dispose();
        w.setVisible(false);
    }
}

