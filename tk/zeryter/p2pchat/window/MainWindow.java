package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 5/01/14
 */

public class MainWindow extends Window implements ActionListener {

    //Windows
    static AboutWindow aboutWindow = new AboutWindow();

    //MenuBar etc ......
    JMenuBar menuBar;
    //MenuBar items
    JMenu file, edit, help;

    //File menu items
    JMenuItem quit;

    //Edit menu items
    JMenuItem encryption;
    JMenuItem changePort;

    //Help menu items
    JMenuItem about;

    //Containers
    Container mainContainer;

    //Widgets
    JTextArea output;
    JScrollPane outputScroll;

    @Override
    public void init() {

        //MenuBar setup
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, frame.getContentPane().getWidth(), 20);

        //MenuBar items
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        menuBar.add(file);

        //File Menu items
        quit = new JMenuItem("QUIT");
        quit.addActionListener(this);

        //Add to file
        file.add(quit);

        menuBar.add(edit);

        //edit Menu items
        encryption = new JMenuItem("Encryption");
        //encryption.addActionListener(this);
        changePort = new JMenuItem("Change Port");
        changePort.addActionListener(this);

        //Add to edit
        edit.add(encryption);
        edit.add(changePort);

        menuBar.add(help);

        //Help Menu items
        about = new JMenuItem("About");
        about.addActionListener(this);

        //add to Help
        help.add(about);

        //Container setup
        mainContainer = new Container();

        //Widget setup
        output = new JTextArea();
        output.setEditable(true);
        outputScroll = new JScrollPane(output);
        outputScroll.createVerticalScrollBar();
        mainContainer.add(outputScroll);

        //Frame final setup
        frame.setTitle("P2P-CHAT_V2: infdev");
        frame.setSize(400,600);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(mainContainer);
        frame.addWindowListener(new WindowMonitor());
    }

    @Override
    public void draw() {
        //Set mainContainers bound to fill the content pane
        mainContainer.setBounds(0,0,frame.getContentPane().getWidth(), frame.getContentPane().getHeight());

        //Set widget bounds
        outputScroll.setBounds(0,0,mainContainer.getWidth(),mainContainer.getHeight() - 40);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //About MenuItem open a about window
        if (e.getSource() == about) {
            if (!aboutWindow.visible && aboutWindow.firstRun) {
                new Thread(aboutWindow).start();
            } else if (!aboutWindow.visible) {
                aboutWindow.reinit();
            } else {
                aboutWindow.frame.requestFocus();
            }
        }

        //QUIT
        if (e.getSource() == quit) {
            P2PChatMain.running = false;
            System.exit(0);
        }

    }
}
