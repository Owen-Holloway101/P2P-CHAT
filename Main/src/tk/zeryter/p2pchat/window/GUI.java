package tk.zeryter.p2pchat.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    Canvas canvas = new Canvas();

    //define buttons, textfields, etc ...

    JTextField messageInput, encryptionPass;

    JTextPane messages, currentPeers, avaliablePeers;

    JScrollPane messagesScroll;

    public void init(Container container) {
        //Initialise things
        messageInput = new JTextField();
        container.add(messageInput);
        encryptionPass = new JTextField();
        container.add(encryptionPass);

        messages = new JTextPane();
        messagesScroll = new JScrollPane(messages);
        messagesScroll.createVerticalScrollBar();
        container.add(messagesScroll);

        currentPeers = new JTextPane();
        avaliablePeers = new JTextPane();

        //Canvas .. leave this here
        container.add(canvas);
    }

    public void draw(Container container) {
        //Set the size of objects, runs when the window is resized and on creation
        messageInput.setBounds(10,container.getHeight() - 30,container.getWidth()-120,20);
        encryptionPass.setBounds(10,10,container.getWidth()-120,20);

        messagesScroll.setBounds(10,35,container.getWidth() - 120,container.getHeight() - 70);
        messages.setBounds(0,0,messagesScroll.getWidth(),messagesScroll.getHeight());
        messages.setCaretPosition(messages.getDocument().getLength());

        //canvas for painting on
        canvas.setBounds(0,0,container.getWidth(),container.getHeight());
    }

    public void actionPerformed(ActionEvent e) {
        //Action event for when buttons are pressed, etc ...

    }
}
