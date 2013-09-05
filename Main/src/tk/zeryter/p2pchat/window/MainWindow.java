package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;
import tk.zeryter.p2pchat.Vairables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class MainWindow implements Runnable, ComponentListener, ActionListener {

    JFrame frame = new JFrame();
    Image icon;
    Container rootContainer = new Container();
    Container widgetsContainer = new Container();


    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setTitle("P2P-CHAT");
        frame.setIconImage(icon);
        frame.addWindowListener(new MainWindowMonitor());
        rootContainer.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.add(rootContainer);
        widgetsContainer.setBounds(0,20,rootContainer.getWidth(),rootContainer.getHeight()-201);
        rootContainer.add(widgetsContainer);

        gui_init();

        frame.addComponentListener(this);
        frame.validate();

    }

    JMenuBar menuBar;
    JMenu file, options, help;
    //File menu items
    JMenuItem quit;
    //Options menu items

    //Help menu items
    JMenuItem about;

    void gui_init() {

        menuBar = new JMenuBar();
        menuBar.setBounds(0,0, rootContainer.getWidth(),20);
        file = new JMenu(" File ");
        options = new JMenu(" Options ");
        help = new JMenu(" Help ");

        menuBar.add(file);

        //File Menu items
        quit = new JMenuItem("QUIT");
        quit.addActionListener(this);

        //Add to file
        file.add(quit);

        menuBar.add(options);

        //Options Menu items

        //Add to options

        menuBar.add(help);

        //Help Menu items
        about = new JMenuItem("About");
        about.addActionListener(this);

        //add to Help
        help.add(about);


        rootContainer.add(menuBar);

        gui_draw();

    }

    void gui_draw() {

        //Main GUI element resizing (Containers, Menus, etc ....)
        rootContainer.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        menuBar.setBounds(0,0, rootContainer.getWidth(),20);

        widgetsContainer.setBounds(0,20,rootContainer.getWidth(),rootContainer.getHeight()-201);

        //Wiget Resizing

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == quit) {
            System.exit(0);
        }
        if (e.getSource() == about) {
            new Thread(Vairables.aboutWindow).start();
        }

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

