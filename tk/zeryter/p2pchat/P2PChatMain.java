package tk.zeryter.p2pchat;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */

public class P2PChatMain {

    public static boolean running = true;

    public static void main(String args[]) {

        Network.startListening(10);
        Network.startListening(20);
        Network.startListening(30);

    }
}