package tk.zeryter.p2pchat.net;

import java.net.DatagramPacket;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 14/11/13
 */

public interface NetAction {

    public void packetRecieved(DatagramPacket packet);

}