//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPListen {

    boolean running = true;

    public void listenString(int port, int PACKETSIZE) {

        String receivedData;

        try {
            System.out.println("Starting up on port: " + port);
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Ready to recieve on " + port + " ....");

            while (running) {

                // Create a packet
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

                // Receive a packet (blocking)
                socket.receive(packet);

                // Print the packet
                System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + new String(packet.getData()).trim());

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

                        //System.out.println("User:" + data);

                        break;

                    case 'm':
                        //Append to the messages output
                        MainWindow.gui.messages.getStyledDocument().insertString(MainWindow.gui.messages.getStyledDocument().getLength(),data + '\n',null);

                        break;

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
