//Owen Holloway GYC
package tk.zeryter.p2pchat;

public class Network implements Runnable {

    public UDPListen net = new UDPListen();

    public void run() {
        net.listenString(5555,1000);
    }
}
