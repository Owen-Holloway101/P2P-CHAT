package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.window.MainWindow;
import tk.zeryter.p2pchat.window.Window;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */

public class P2PChatMain {

    //is everything running? this is the global variable
    public static boolean running = true;

    //Global Variables

    //The main dir for P2P-CHAT, config files are stored here
    public static Path P2PDIR = Paths.get(System.getProperty("user.home") + "/.P2P-CHAT");

    //Static classes
    public static Message message = new Message();

    public static void main(String args[]) {

        //About the application
        System.out.println("Owen Holloway, ZerytSoft, 2013");
        System.out.println(" _____               _   ____         __ _   \n" +
                "|__  /___ _ __ _   _| |_/ ___|  ___  / _| |_ \n" +
                "  / // _ \\ '__| | | | __\\___ \\ / _ \\| |_| __|\n" +
                " / /|  __/ |  | |_| | |_ ___) | (_) |  _| |_ \n" +
                "/____\\___|_|   \\__, |\\__|____/ \\___/|_|  \\__|\n" +
                "               |___/                         ");
        System.out.println("www.zeryter.tk");
        System.out.println("https://github.com/Owen-Holloway101/P2P-CHAT");

        if (Files.notExists(P2PDIR)) {
            try {
                Files.createDirectories(P2PDIR);
                System.out.println("First time run dir creation");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //ARGS
        boolean GUI = true;

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("--nogui")) {
                GUI = false;
            }

        }


        //Setup stuff for the messages
        message.init();

        //Input

        //Console input
        ConsoleInput consoleInput = new ConsoleInput();
        new Thread(consoleInput).start();

        //This is the main window
        if (GUI) {
            Window window = new MainWindow();
            new Thread(window).start();
        } else {
            System.out.println("NO GUI");
        }

        //System.exit(0);
    }
}