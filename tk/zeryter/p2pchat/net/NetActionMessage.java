package tk.zeryter.p2pchat.net;

import tk.zeryter.p2pchat.NetAction;

import java.net.DatagramPacket;
import java.util.Arrays;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 14/11/13
 */

public class NetActionMessage extends NetAction {

    public void packetRecieved(DatagramPacket packet) {

        byte[] data = packet.getData();

        System.out.println(packet.getAddress() + ":" + packet.getPort() + ":" + data.length + ":" + Arrays.toString(data));

    }
}
