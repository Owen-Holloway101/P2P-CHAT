package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.net.NetAction;
import tk.zeryter.p2pchat.net.Network;

import java.net.DatagramPacket;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 17/11/13
 */

public class Message implements NetAction {

    public void init() {
        Network.startListening(5555, 1000);
        Network.setNetAction(5555, this);
    }

    public static void send(String message) {

        //if not encrypted {
        Network.send.bytearray(Crypt.utftobyte(message), "255.255.255.255", 5555);
        // } else {
        //Network.send.bytearray(Crypt.utftobyte(Crypt.encrypt(message)))
        //}
    }


    @Override
    public void packetRecieved(DatagramPacket packet) {
        System.out.println("Received: " + packet.getAddress() + ":" + Crypt.utftostring(packet.getData()));
    }

}
