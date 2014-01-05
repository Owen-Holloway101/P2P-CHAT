package tk.zeryter.p2pchat.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 5/01/14
 */

public class AboutWindow extends Window {

    //Is window visible
    public boolean visible = false;
    public boolean firstRun = true;

    //Container
    Container container = new Container();

    //Widgets
    JLabel iconLabel, textLabel1, textLabel2, textLabel3, textLabel4;

    @Override
    public void init() {

        frame.setSize(400,350);

        //setup basic booleans
        visible = true;
        firstRun = false;

        //setup widgets
        textLabel1 = new JLabel("ZerytSoft 2013");
        textLabel2 = new JLabel("www.zeryter.tk");
        textLabel3 = new JLabel("Owen Holloway, aka Zeryter");
        textLabel4 = new JLabel("https://github.com/Owen-Holloway101/P2P-CHAT");
        iconLabel = new JLabel(new ImageIcon(MainWindow.icon));

        textLabel1.setHorizontalAlignment( SwingConstants.CENTER );
        textLabel2.setHorizontalAlignment( SwingConstants.CENTER );
        textLabel3.setHorizontalAlignment( SwingConstants.CENTER );
        textLabel4.setHorizontalAlignment( SwingConstants.CENTER );

        //add widgets to frame
        frame.getContentPane().add(container);
        container.add(textLabel1);
        container.add(textLabel2);
        container.add(textLabel3);
        container.add(textLabel4);
        container.add(iconLabel);

        frame.setResizable(false);
        frame.addWindowListener(new AboutWindowMonitor());
    }

    public void reinit() {
        frame.setVisible(true);
    }

    @Override
    public void draw() {

        //reset bounds
        textLabel1.setBounds(0,5,container.getWidth(),20);
        textLabel2.setBounds(0,25,container.getWidth(),20);
        textLabel3.setBounds(0,45,container.getWidth(),20);
        textLabel4.setBounds(0,65,container.getWidth(),20);
        iconLabel.setBounds(0, 80, container.getWidth(), container.getHeight() - 80);

    }

    class AboutWindowMonitor extends WindowAdapter implements WindowListener {

        public void windowClosing(WindowEvent e) {
            MainWindow.aboutWindow.visible = false;
            e.getWindow().setVisible(false);
        }
    }

}
