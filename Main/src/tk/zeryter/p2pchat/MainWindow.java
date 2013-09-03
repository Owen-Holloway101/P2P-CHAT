//Owen Holloway GYC
package tk.zeryter.p2pchat;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;

public class MainWindow implements Runnable, ComponentListener {

    static JFrame window = new JFrame();

    Container container = new Container();

    WindowMonitor windowMonitor = new WindowMonitor();

    public static GUI gui = new GUI();

    public void run() {

        window.setTitle("P2P CHAT: no-user");
        window.setSize(600, 500);
        window.setVisible(true);
        window.add(container);

        container.setBounds(0, 0, window.getWidth(), window.getHeight());

        gui.init(container);
        gui.draw(container);

        window.addWindowListener(windowMonitor);
        window.addComponentListener(this);
    }

    public void componentResized(ComponentEvent e) {
        gui.draw(container);
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }
}

class GUI implements ActionListener {

    JButton sendMessage, encryptionToggle;
    Button  addPeer, setUsername;

    JTextField messageInput, encryptionPass, userName;

    JScrollPane messagesScroll;

    JTextPane messages, currentPeers;

    List avaliablePeers = new List();

    UDPSend messageout = new UDPSend();


    public void init(Container c) {

        //Initialise things
        messageInput = new JTextField();
        c.add(messageInput);
        encryptionPass = new JTextField();
        c.add(encryptionPass);

        messages = new JTextPane();

        messages.setEditable(false);
        messagesScroll = new JScrollPane(messages);
        messagesScroll.createVerticalScrollBar();
        c.add(messagesScroll);

        currentPeers = new JTextPane();

        //avaliablePeers = new JList();
        //c.add(avaliablePeers);

        c.add(avaliablePeers);

        sendMessage = new JButton("SEND");
        c.add(sendMessage);

        addPeer = new Button("add peer");
        c.add(addPeer);

        userName = new JTextField();
        c.add(userName);

        setUsername = new Button("set user name");
        c.add(setUsername);

        //Action listeners
        sendMessage.addActionListener(this);
        messageInput.addActionListener(this);
        setUsername.addActionListener(this);

    }

    public void draw(Container c) {

        //Set the size of objects, runs when the window is resized and on creation
        messageInput.setBounds(0, c.getHeight() - 30, c.getWidth() - 120, 30);
        encryptionPass.setBounds(0, 0, c.getWidth() - 120, 30);

        messagesScroll.setBounds(0, 30, c.getWidth() - 120, c.getHeight() - 60);
        messages.setBounds(0, 0, messagesScroll.getWidth(), messagesScroll.getHeight());

        //int max =  messagesScroll.getVerticalScrollBar().getMaximum();
        //System.out.println(max);
        //messagesScroll.getVerticalScrollBar().setValue(max);

        sendMessage.setBounds(c.getWidth() - 120, c.getHeight() - 30, 120, 30);

        addPeer.setBounds(c.getWidth() - 120, c.getHeight() / 2 - 40, 120, 20);

        userName.setBounds(c.getWidth() - 120,c.getHeight() / 2 -20,120,20);
        setUsername.setBounds(c.getWidth() - 120,c.getHeight() / 2,120,20);

        //avaliablePeers.setBounds(c.getWidth() - 120,30,120,c.getHeight()/2 - 80);
        avaliablePeers.setBounds(c.getWidth() - 120, 30, 120, c.getHeight() / 2 - 70);

        //messages.setCaretPosition(messages.getDocument().getLength());

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendMessage | e.getSource() == messageInput) {
            String input = messageInput.getText();

            if (input.charAt(0) == '/') {
                if (input.contains("debug")) {
                    System.out.println("debug messages");
                    Switches.debug = !Switches.debug;
                }
                if (input.contains("quit")) {
                    System.exit(0);
                }
                if (input.contains("iptoggle")) {
                    System.out.println("iptoggle");
                    Switches.ipShow = !Switches.ipShow;
                }
                if (input.contains("addNullPeer")) {
                       avaliablePeers.add("avaliablePeers");
                }
            } else {
                //TODO send message packet
                //messageout.sendString(input,,5555);
                try {
                    messages.getStyledDocument().insertString(messages.getStyledDocument().getLength(), "You: " + input + "\n", null);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
            messageInput.setText("");
            messageInput.requestFocus();
        }
        if (e.getSource() == setUsername) {
            String uname = userName.getText();
            MainWindow.window.setTitle("P2P-CHAT: " + uname);
            Switches.userName = uname;
        }

    }
}

class WindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        w.setVisible(false);
        w.dispose();
        System.exit(0);
    }
}