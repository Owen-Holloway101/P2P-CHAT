package tk.zeryter.p2pchat.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow implements Runnable, ComponentListener {

    JFrame frame = new JFrame();

    Container container = new Container();

    public void run() {

        frame.setSize(300,400);
        frame.setVisible(true);
        frame.addWindowListener(new MainWindowMonitor());

        frame.add(container);

        container.setBounds(0,0,frame.getWidth(),frame.getHeight());

        gui_init();

        frame.addComponentListener(this);
        frame.validate();

    }

    JMenuBar menuBar;
    JMenu file, options, help;
    JMenuItem test,test1,test2,test3;

    void gui_init() {

        menuBar = new JMenuBar();
        menuBar.setBounds(0,0,container.getWidth(),20);
        file = new JMenu(" File ");
        options = new JMenu(" Options ");
        help = new JMenu(" Help ");

        menuBar.add(file);
        //File options
        test = new JMenuItem("test");
        file.add(test);
        test1 = new JMenuItem("test1");
        file.add(test1);
        test2 = new JMenuItem("test2");
        file.add(test2);
        test3 = new JMenuItem("test3");
        file.add(test3);

        menuBar.add(options);
        menuBar.add(help);


        container.add(menuBar);

        gui_draw();

    }

    void gui_draw() {

        container.setBounds(0,0,frame.getWidth(),frame.getHeight());

        menuBar.setBounds(0,0,container.getWidth(),20);

    }



    public void componentResized(ComponentEvent e) {
        gui_draw();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }
}

class MainWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

