package tk.zeryter.p2pchat;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */

public class P2PChatMain {

    public static boolean running = true;

    public static void main(String args[]) {

        Network.startListening(55555,1000);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte[] b;
        b = new byte[]{1, 2, 4, 5, 6, 7, 8, 8, 9, 0};

        Network.send.bytearray((byte)1,b,"255.255.255.255",55555);

    }
}