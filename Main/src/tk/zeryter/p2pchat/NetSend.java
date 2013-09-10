//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetSend {

    public void sendString(byte mode,String message, String host, int port) {
        try {

            byte[] data = message.getBytes();

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
