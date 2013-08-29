package tk.zeryter.p2pchat;

import java.io.IOException;
import java.net.*;

public class DiscoveryNet implements Runnable{

    boolean running = true;

    int port, PACKETSIZE;

    public void UDPSend(String text, String host, int port) {
        try {

            byte[] message = text.getBytes();

            // Get the internet address of the specified host
            InetAddress address = InetAddress.getByName(host);

            // Initialize a datagram packet with data and address
            DatagramPacket packet = new DatagramPacket(message, message.length,
                    address, port);

            // Create a datagram socket, send the packet through it, close it.
            DatagramSocket dsocket = new DatagramSocket();
            dsocket.send(packet);
            dsocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void run() {

        while (running) {

            UDPSend("u:foo","255.255.255.255",5555);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

    public void setPort(int port){
        this.port = port;

    }

    public void setPACKETSIZE(int packetsize) {
        this.PACKETSIZE = packetsize;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
