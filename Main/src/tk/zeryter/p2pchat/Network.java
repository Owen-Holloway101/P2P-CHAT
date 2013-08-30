//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.net.*;

public class Network implements Runnable{

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

    public void UDPRecieve(int port, int PACKETSIZE) {

        String receivedData;

        try {
            // Convert the argument to ensure that is it valid
            System.out.println("Starting up on port: " + port);
            // Construct the socket
            DatagramSocket socket = new DatagramSocket(port);

            System.out.println("Ready to recieve on " + port + " ....");

            int discoveryCount = 0;

            while (running) {

                // Create a packet
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

                // Receive a packet (blocking)
                socket.receive(packet);

                // Print the packet
                System.out.println(packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()));

                receivedData = new String(packet.getData());

                char receivedChar[];
                int charsRecived;

                String data = "";

                charsRecived = receivedData.length();

                receivedChar = new char[charsRecived];

                for (int i = 0; i < charsRecived; i++) {
                    receivedChar[i] = receivedData.charAt(i);
                }

                for (int i = 2; i < charsRecived; i++) {
                    data = data + receivedChar[i];
                }

                switch (receivedChar[0]) {

                    case 'u':

                        System.out.println("User:" + data);

                        break;

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {

        UDPRecieve(port, PACKETSIZE);
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
