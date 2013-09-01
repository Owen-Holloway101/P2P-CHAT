package tk.zeryter.p2pchat.window;

import javax.swing.*;

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

    JButton sendMessage, addPeer, encryptionToggle;


}