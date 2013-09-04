package tk.zeryter.p2pchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetListen {

    boolean running = true;

    public void listenString(int port, int PACKETSIZE) {

        String receivedData;
            System.out.println("Starting up on port: " + port);
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(port);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            System.out.println("Ready to recieve on " + port + " ....");

            while (running) {

                // Create a packet
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

                // Receive a packet (blocking)
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Print the packet
                System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + new String(packet.getData()).trim());

            }
    }
}