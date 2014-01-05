package tk.zeryter.p2pchat.window;

import javax.swing.*;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 5/01/14
 */

public class MainWindow extends Window {

    JMenuBar menuBar;
    //MenuBar items
    JMenu file, edit, help;

    //File menu items
    JMenuItem quit;

    //Edit menu items
    JMenuItem encryption;
    JMenuItem chatStream;

    //Help menu items
    JMenuItem about;

    @Override
    public void init() {
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, frame.getContentPane().getWidth(), 20);
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");

        menuBar.add(file);

        //File Menu items
        quit = new JMenuItem("QUIT");

        //Add to file
        file.add(quit);

        menuBar.add(edit);

        //edit Menu items
        encryption = new JMenuItem("Encryption");
        //encryption.addActionListener(this);
        chatStream = new JMenuItem("Chat Stream");
        //chatStream.addActionListener(this);

        //Add to edit
        edit.add(encryption);
        edit.add(chatStream);

        menuBar.add(help);

        //Help Menu items
        about = new JMenuItem("About");
        //about.addActionListener(this);

        //add to Help
        help.add(about);

        frame.setJMenuBar(menuBar);
    }
}
