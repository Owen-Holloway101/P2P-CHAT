package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.window.AboutWindow;
import tk.zeryter.p2pchat.window.EncryptionWindow;
import tk.zeryter.p2pchat.window.MainWindow;
import tk.zeryter.p2pchat.window.StartWindow;

public class Vairables {

    //global variables
    public static String userName = null;
    public static int port = 5555;
    public static boolean encryptionToggled = false;
    public static String encryptionPass = "";

    //Windows
    public static StartWindow startWindow = new StartWindow();
    public static MainWindow mainWindow = new MainWindow();
    public static AboutWindow aboutWindow = new AboutWindow();
    public static EncryptionWindow encryptionWindow = new EncryptionWindow();

    //other class instances
    public static NetSend netSend = new NetSend();

}
