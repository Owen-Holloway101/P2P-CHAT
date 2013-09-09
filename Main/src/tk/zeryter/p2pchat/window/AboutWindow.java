package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class AboutWindow implements Runnable, ActionListener {

    JFrame frame = new JFrame();

    Image icon;

    public static boolean reopened = false;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(250,320);
        frame.setTitle("About");
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.addWindowListener(new AboutWindowMonitor());
        frame.setResizable(false);
        frame.requestFocus();

        Container c = new Container();
        frame.add(c);
        c.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        if (AboutWindow.reopened) {
            gui_reinit();
        } else {

            gui_init(c);
            reopened = true;
        }

        gui_draw(c);

        frame.validate();

    }

    //GUI widgets

    AboutWindowCanvas canvas;

    void gui_init(Container c) {

        canvas = new AboutWindowCanvas();
        canvas.setImages();
        c.add(canvas);

    }

    void  gui_reinit(){
        frame.setVisible(true);
    }

    void gui_draw(Container c) {

        c.setBounds(0,0,frame.getWidth(),frame.getHeight());
        canvas.setBounds(0,0,c.getWidth(),c.getHeight());

    }

    public void actionPerformed(ActionEvent e) {


    }
}

class AboutWindowMonitor extends WindowAdapter implements WindowListener {

    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        //w.dispose();
        w.setVisible(false);
    }
}

class AboutWindowCanvas extends Canvas {

    Image icon;

    public void paint(Graphics g){
        g.drawString("Owen Holloway GYC",40,15);
        g.drawString("P2P-CHAT (zerytsoft)",40,30);
        g.drawString("github.com/Owen-Holloway101",10,48);
        g.drawImage(icon,this.getWidth()/2-(icon.getHeight(this)/2),this.getHeight()/2-(icon.getWidth(this)/2),this);

    }

    public void setImages() {
        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

