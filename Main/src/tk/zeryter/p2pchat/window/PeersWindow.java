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

    JButton toggleEncryption;
    JTextArea pass;

    void gui_init(Container c) {

        c.setLayout(null);

        if (Vairables.encryptionToggled) {
            toggleEncryption = new JButton("Encryption is on");
            toggleEncryption.setBackground(Color.green);
        } else {
            toggleEncryption = new JButton("Encryption is off");
            toggleEncryption.setBackground(Color.red);
        }

        toggleEncryption.addActionListener(this);
        c.add(toggleEncryption);

        if (Vairables.encryptionToggled) {
            pass = new JTextArea();
            pass.setBackground(Color.green);
            pass.setEditable(false);
            //pass.setText(Vairables.encryptionPass);
        } else {
            pass = new JTextArea();
            pass.setBackground(Color.red);
            pass.setEditable(true);
            //pass.setText(Vairables.encryptionPass);
        }

        c.add(pass);

    }

    void gui_reinit(Container c) {

        frame.setVisible(true);
    }

    void gui_draw(Container c) {

        c.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        toggleEncryption.setBounds(0,20,c.getWidth(),c.getHeight() - 50);
        pass.setBounds(0,0,c.getWidth(),20);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == toggleEncryption) {

            Vairables.encryptionToggled = !Vairables.encryptionToggled;
            Vairables.encryptionPass = pass.getText();

            if (Vairables.encryptionToggled) {
                toggleEncryption.setText("Encryption is on");
                toggleEncryption.setBackground(Color.green);
            } else {
                toggleEncryption.setText("Encryption is off");
                toggleEncryption.setBackground(Color.red);
            }

            if (Vairables.encryptionToggled) {
                pass.setBackground(Color.green);
                pass.setEditable(false);
                pass.setText(Vairables.encryptionPass);
            } else {
                pass.setBackground(Color.red);
                pass.setEditable(true);
                pass.setText(Vairables.encryptionPass);
            }

        }
    }
}

class PeersWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        //w.dispose();
        w.setVisible(false);
    }
}

