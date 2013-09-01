package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.window.MainWindowMonitor;

import javax.swing.*;
import java.awt.*;

public class MainWindow implements Runnable {

    JFrame window = new JFrame();

    public void run() {

        window.setTitle("Place Holder Text");
        window.setSize(600,500);
        window.setVisible(true);
        window.addWindowListener(new MainWindowMonitor());

    }


}

class GUI {

    static JButton sendMessage, addPeer, encryptionToggle;

    static void  test() {

    }


}