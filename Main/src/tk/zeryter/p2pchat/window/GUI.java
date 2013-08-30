//Owen Holloway GYC
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

    JButton sendMessage, addPeer, encryptionToggle;

    public void init(Container container) {

        try{
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Initialise things
        messageInput = new JTextField();
        container.add(messageInput);
        encryptionPass = new JTextField();
        container.add(encryptionPass);

        messages = new JTextPane();

        //messages.setEditable(false);
        messagesScroll = new JScrollPane(messages);
        messagesScroll.createVerticalScrollBar();
        container.add(messagesScroll);

        currentPeers = new JTextPane();
        avaliablePeers = new JTextPane();


        sendMessage = new JButton("SEND");
        container.add(sendMessage);
        addPeer = new JButton("add peer");
        container.add(addPeer);

        //Canvas .. leave this here
        container.add(canvas);
    }

    public void draw(Container container) {



        //Set the size of objects, runs when the window is resized and on creation
        messageInput.setBounds(0,container.getHeight() - 30,container.getWidth()-120,30);
        encryptionPass.setBounds(0,0,container.getWidth() - 120,30);

        messagesScroll.setBounds(0,30,container.getWidth() - 120,container.getHeight() - 60);
        messages.setBounds(0,0,messagesScroll.getWidth(),messagesScroll.getHeight());

        sendMessage.setBounds(container.getWidth()-120,container.getHeight() - 30,120,30);

        addPeer.setBounds(container.getWidth()-120,container.getHeight()/2 - 50,120,30);

        //canvas for painting on
        canvas.setBounds(0,0,container.getWidth(),container.getHeight());

        messageInput.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        //Action event for when buttons are pressed, etc ...

        if(e.getSource() == messageInput  | e.getSource() == sendMessage) {

        }

    }
}
