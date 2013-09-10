package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;
import tk.zeryter.p2pchat.Vairables;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class StartWindow implements Runnable, ActionListener {

    JFrame frame = new JFrame();
    Image icon;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(450,150);
        frame.setTitle("P2P-CHAT by Owen Holloway GYC (ZerytSoft)");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.addWindowListener(new StartWindowMonitor());
        frame.setResizable(false);

        Container c = new Container();
        frame.add(c);
        c.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        gui_init(c);
        gui_draw(c);

    }

    //GUI widgets

    JButton startChatting;
    JTextArea uName,uNamePrompt, port, defaultPortPrompt, portPrompt;
    JCheckBox defaultPort;

    void gui_init(Container c) {

        startChatting = new JButton("start chatting");
        startChatting.addActionListener(this);
        c.add(startChatting);

        uName = new JTextArea();
        uName.setBorder(new BevelBorder(1));
        c.add(uName);
        uNamePrompt = new JTextArea();
        uNamePrompt.setEditable(false);
        uNamePrompt.setText("User Name:");
        uNamePrompt.setBackground(Color.GRAY);
        c.add(uNamePrompt);

        port = new JTextArea();
        port.setEditable(false);
        c.add(port);
        portPrompt = new JTextArea();
        portPrompt.setEditable(false);
        portPrompt.setText("Port: ");
        portPrompt.setBackground(Color.GRAY);
        c.add(portPrompt);
        defaultPortPrompt = new JTextArea();
        defaultPortPrompt.setEditable(false);
        defaultPortPrompt.setText("Default port: ");
        defaultPortPrompt.setBackground(Color.GRAY);
        c.add(defaultPortPrompt);

        defaultPort = new JCheckBox();
        c.add(defaultPort);

    }

    void gui_draw(Container c) {

        c.setBounds(0,0,frame.getWidth(),frame.getHeight());

        startChatting.setBounds(280,80,150,30);

        uName.setBounds(160,10,270,20);
        uNamePrompt.setBounds(10,10,150,20);

        defaultPort.setBounds(160,45,30,30);
        defaultPortPrompt.setBounds(10, 50, 150, 20);

        portPrompt.setBounds(10, 90, 100, 20);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startChatting) {
            if (uName.getText().equals("")) {
                startChatting.setBackground(Color.red);
                startChatting.setText("NO USER");
                uName.setBackground(Color.red);
            } else {
                Vairables.userName = uName.getText();
                System.out.println("Set username: " + Vairables.userName);
                frame.dispose();
                new Thread(Vairables.mainWindow).start();
                new Thread(Vairables.listen).start();
            }


        }

    }
}

class StartWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

