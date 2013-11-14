package tk.zeryter.p2pchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */

//TODO comment out entire file properly

public class Network implements Runnable {

    //Inner class for sending packets

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

    //External calls to class instances

    private static Map<Integer, Network> networkMap = new HashMap<Integer, Network>();

    public static void startListening(Integer port, int PACKETSIZE) {

        networkMap.put(port,new Network());
        networkMap.get(port).port = port;
        networkMap.get(port).PACKETSIZE = PACKETSIZE;

        new Thread(networkMap.get(port)).start();

    }


    public static void setNetAction(int port,NetAction newNetAction) {
        networkMap.get(port).netAction = newNetAction;
    }

    //Main body of class instance

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

        byte[] data = packet.getData();

        System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + data.length + ":" + Arrays.toString(data));

        netAction.packetRecieved(packet);

    }
}
