//Owen Holloway GYC
package tk.zeryter.p2pchat;

public class Listen implements Runnable {

    NetListen netListen = new NetListen();

    public void run() {

        netListen.listenString(5555,1000);

    }
}
