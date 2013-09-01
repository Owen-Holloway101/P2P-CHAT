package tk.zeryter.p2pchat.window;

import tk.zeryter.p2pchat.P2PChatMain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class StartPopUp implements Runnable{

    //TODO fix popup class

    JWindow window = new JWindow();

    Image icon;

    public void run() {

        URL url = P2PChatMain.class.getResource("/assets/icon.png");

        try {
            icon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        window.setSize(100,50);
        window.setVisible(true);
        window.setIconImage(icon);

    }
}
