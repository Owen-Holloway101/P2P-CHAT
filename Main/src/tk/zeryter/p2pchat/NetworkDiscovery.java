//Owen Holloway GYC
package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.network.UDPSend;

public class NetworkDiscovery implements Runnable {

    boolean runing = true;

    UDPSend discNet = new UDPSend();

    public void run() {

        while (runing) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            discNet.sendString("255.255.255.255","u:null",5555);

        }

    }

    public void setRuning(boolean runing) {

        this.runing = runing;

    }

}
