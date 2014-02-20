//Owen Holloway GYC
package tk.zeryter.p2pchat;

import javax.swing.*;

public class P2PChatMain {

    public static void main(String[] args) {
        System.out.println("Owen Holloway, GYC");
        System.out.println(" _____               _   ____         __ _   \n" +
                           "|__  /___ _ __ _   _| |_/ ___|  ___  / _| |_ \n" +
                           "  / // _ \\ '__| | | | __\\___ \\ / _ \\| |_| __|\n" +
                           " / /|  __/ |  | |_| | |_ ___) | (_) |  _| |_ \n" +
                           "/____\\___|_|   \\__, |\\__|____/ \\___/|_|  \\__|\n" +
                           "               |___/                         ");
        System.out.println("www.zeryter.tk");
        System.out.println("https://github.com/Owen-Holloway101/P2P-CHAT");

        try{
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        new Thread(Vairables.startWindow).start();
        //new Thread(Vairables.mainWindow).start();
        //new Thread(Vairables.listen).start();
    }

}
