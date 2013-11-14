package tk.zeryter.p2pchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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

    public static void startListening(int port, int PACKETSIZE) {

        Network network = new Network();

        network.port = port;
        network.PACKETSIZE = PACKETSIZE;

        new Thread(network).start();

    }

    public int port;
    public int PACKETSIZE;

    NetAction netAction = new NetAction();

    public void run() {

        init();

        while (P2PChatMain.running) {
            loop();
        }

    }

    private DatagramSocket socket = null;

    private void init() {

        String receivedData;
        System.out.println("Starting up on port: " + port);
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        System.out.println("Ready to recieve on " + port + " ....");
    }

    private void loop() {

        DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // Receive a packet (blocking)
        try {
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + new String(packet.getData()).trim());

        netAction.packetRecieved(packet);

    }

    public void setNetAction(NetAction newNetAction) {
        netAction = newNetAction;
    }

    public class NetAction {

        public void packetRecieved(DatagramPacket packet) {

        }

    }

}
