//Owen Holloway GYC
package tk.zeryter.p2pchat;

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetListen implements Runnable {

    public void run() {

    }

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

            while (Vairables.running) {

                // Create a packet
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);

                // Receive a packet (blocking)
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                byte[] packetData = packet.getData();

                // Print the packet
                System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + new String(packet.getData()).trim());

                byte[] data = new byte[packetData.length - 1];

                System.arraycopy(packetData,1,data,0,packetData.length - 1);


                    String temp_message = new String(packet.getData()).trim();

                    if (Vairables.encryptionToggled) {
                        temp_message = Vairables.crypt.decode(packetData,Vairables.encryptionPass);
                        System.out.println("Temp_Message_decrypt:" + temp_message);
                    } else {
                        temp_message = Vairables.crypt.utftostring(packetData);
                        System.out.println("Temp_Message_decrypt:" + temp_message);
                    }

                    try {
                        Vairables.mainWindow.messages.getStyledDocument().insertString(Vairables.mainWindow.messages.getStyledDocument().getLength(),packet.getAddress() + ": " + temp_message + '\n',null);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }

            }
    }
}