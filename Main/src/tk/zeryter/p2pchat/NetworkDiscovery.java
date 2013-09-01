//Owen Holloway GYC
package tk.zeryter.p2pchat;

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

            discNet.sendString("u:null","255.255.255.255",5555);

        }

    }

    public void setRuning(boolean runing) {

        this.runing = runing;

    }

}
