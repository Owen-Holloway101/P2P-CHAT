package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.net.NetAction;
import tk.zeryter.p2pchat.net.Network;

import java.net.DatagramPacket;
import java.util.HashMap;
import java.util.Map;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 17/11/13
 */

public class Message implements NetAction {

    public void init() {
        Network.startListening(P2PChatMain.PORT, 1000);
        Network.setNetAction(P2PChatMain.PORT, this);
    }

    public static void sendMessage(String message) {

        //if not encrypted {
        Network.send.bytearray(Crypt.utftobyte(message), "255.255.255.255", P2PChatMain.PORT);
        // } else {
        //Network.sendMessage.bytearray(Crypt.utftobyte(Crypt.encrypt(message)))
        //}
    }

    public void stop() {
        Network.stopListening(P2PChatMain.PORT);
    }

    @Override
    public void packetRecieved(DatagramPacket packet) {
    }

    Map<String, String> userMap = new HashMap<String, String>();

}
