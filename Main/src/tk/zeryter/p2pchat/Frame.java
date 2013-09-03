package tk.zeryter.p2pchat;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame implements Runnable {

    JFrame frame = new JFrame();

    public void run() {

        frame.setSize(300,400);
        frame.setVisible(true);
        frame.addWindowListener(new WindowMonitor());

    }
}

class WindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {

        System.exit(0);

    }
}

