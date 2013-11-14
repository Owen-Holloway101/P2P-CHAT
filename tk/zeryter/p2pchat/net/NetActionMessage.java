package tk.zeryter.p2pchat.net;

import tk.zeryter.p2pchat.NetAction;

import java.net.DatagramPacket;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 14/11/13
 */

public class NetActionMessage extends NetAction {

    public void packetRecieved(DatagramPacket packet) {

        System.out.print("NetActionMessage \n");

    }
}
