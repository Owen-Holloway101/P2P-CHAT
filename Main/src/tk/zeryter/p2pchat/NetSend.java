//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetSend {

    public void sendString(byte mode,String text, String host, int port) {
        try {

            byte[] textBytes = text.getBytes();

            /*
            for (int i = 0; i < textBytes.length; i++)
                System.out.println("output bytes: " + textBytes[i]);
            */

            byte message[] = new byte[textBytes.length + 1];

            message[0] = mode;

            System.arraycopy(textBytes, 0, message, 1, textBytes.length);

            /*
            for (int i = 0; i < message.length; i++)
                System.out.println("output bytes: " + message[i]);
            */


            System.out.println();

            // Get the internet address of the specified host
            InetAddress address = InetAddress.getByName(host);

            // Initialize a datagram packet with data and address
            DatagramPacket packet = new DatagramPacket(message, message.length, address, port);

            // Create a datagram socket, send the packet through it, close it.
            DatagramSocket dsocket = new DatagramSocket();
            dsocket.send(packet);
            dsocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
