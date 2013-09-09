//Owen Holloway GYC
package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;
import tk.zeryter.p2pchat.Vairables;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
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
    JMenu file, edit, help;
    //File menu items
    JMenuItem quit;
    //edit menu items
    JMenuItem encryption;
    //Help menu items
    JMenuItem about;

    //GUI widgets

    JScrollPane messagesScroll;

    JTextPane messages;

    JTextField messageInput;

    JButton messageSend;

    void gui_init() {

        menuBar = new JMenuBar();
        menuBar.setBounds(0,0, rootContainer.getWidth(),20);
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");

        menuBar.add(file);

        //File Menu items
        quit = new JMenuItem("QUIT");
        quit.addActionListener(this);

        //Add to file
        file.add(quit);

        menuBar.add(edit);

        //edit Menu items
        encryption = new JMenuItem("Encryption");
        encryption.addActionListener(this);

        //Add to edit
        edit.add(encryption);

        menuBar.add(help);

        //Help Menu items
        about = new JMenuItem("About");
        about.addActionListener(this);

        //add to Help
        help.add(about);

        rootContainer.add(menuBar);

        //Widgets
        messages = new JTextPane();
        messages.setEditable(false);
        messagesScroll = new JScrollPane(messages);
        messagesScroll.createVerticalScrollBar();
        widgetsContainer.add(messagesScroll);

        messageInput = new JTextField();
        messageInput.addActionListener(this);
        widgetsContainer.add(messageInput);

        messageSend = new JButton("SEND");
        messageSend.addActionListener(this);
        widgetsContainer.add(messageSend);

        gui_draw();

    }

    void gui_draw() {

        //Main GUI element resizing (Containers, Menus, etc ....)
        rootContainer.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        menuBar.setBounds(0,0, rootContainer.getWidth(),20);

        widgetsContainer.setBounds(0,20,rootContainer.getWidth()-16,rootContainer.getHeight()-30);

        //Wiget Resizing

        messagesScroll.setBounds(0,0,widgetsContainer.getWidth(),widgetsContainer.getHeight() - 60);
        messages.setBounds(0,0,messagesScroll.getWidth(),messagesScroll.getHeight());

        messageInput.setBounds(0,widgetsContainer.getHeight() - 60,widgetsContainer.getWidth() - 80,30);
        messageSend.setBounds(widgetsContainer.getWidth() - 80,widgetsContainer.getHeight() - 60,80,30);

        messageInput.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == messageSend | e.getSource() == messageInput) {
            if (!(messageInput.getText().equals(""))) {

                if (messageInput.getText().charAt(0) == '/') {

                } else {
                    if (Vairables.encryptionToggled){

                        String temp_message = messageInput.getText();

                        String encoded_message = Vairables.crypt.code(temp_message,Vairables.encryptionPass);
                        String decoded_message = Vairables.crypt.decode(encoded_message,Vairables.encryptionPass);

                        try {
                            messages.getStyledDocument().insertString(messages.getStyledDocument().getLength(),"Encoded: " + encoded_message + '\n',null);
                        } catch (BadLocationException e1) {
                            e1.printStackTrace();
                        }

                        try {
                            messages.getStyledDocument().insertString(messages.getStyledDocument().getLength(),"You: " + decoded_message + '\n',null);
                        } catch (BadLocationException e1) {
                            e1.printStackTrace();
                        }

                    } else {
                        try {
                            messages.getStyledDocument().insertString(messages.getStyledDocument().getLength(),"You: " + messageInput.getText() + '\n',null);
                        } catch (BadLocationException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
                messageInput.setText("");
                messageInput.requestFocus();
            }
        }

        if (e.getSource() == quit) {
            System.exit(0);
        }

        if (e.getSource() == encryption) {
            new Thread(Vairables.encryptionWindow).start();
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

