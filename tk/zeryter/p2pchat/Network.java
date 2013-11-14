package tk.zeryter.p2pchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */


public class Network implements Runnable {

    public static class send {

        public static void bytearray(byte mode, byte[] data, String host, int port) {
            try {

                System.out.println();

                // Get the internet address of the specified host
                InetAddress address = InetAddress.getByName(host);

                // Initialize a datagram packet with data and address
                DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

                // Create a datagram socket, send the packet through it, close it.
                DatagramSocket dsocket = new DatagramSocket();
                dsocket.send(packet);
                dsocket.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void startListening(int port) {

        Network network = new Network();

        network.port = port;

        new Thread(network).start();

    }

    public int port;


    public void run() {

        init();

        while (P2PChatMain.running) {
            loop();
        }

    }

    private void init() {

        System.out.println("Listening on: " + this.port);

    }

    private void loop() {
    }

}
