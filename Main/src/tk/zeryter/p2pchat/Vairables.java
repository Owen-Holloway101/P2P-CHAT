package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.window.*;

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
    public static PeersWindow peersWindow = new PeersWindow();

    //other class instances
    public static NetSend netSend = new NetSend();

}
