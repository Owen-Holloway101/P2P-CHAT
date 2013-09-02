package tk.zeryter.p2pchat;

import java.util.ArrayList;

public class Peers {

    ArrayList avaliable = new ArrayList<String>();
    ArrayList connected = new ArrayList<String>();

    public void addConnected(String peer) {

        connected.add(peer);

    }

    public void addAvaliable(String peer) {

        avaliable.add(peer);

    }

    public boolean isAlreadyConnected (String peer) {

        boolean alreadyConnected = false;

        for (int i = 0; i < connected.size(); i++) {
            if (peer.equals(connected.get(i))) {
                alreadyConnected = true;
            } else {
                alreadyConnected = false;
            }
        }

        if (alreadyConnected) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlreadyAvaliable (String peer) {

        boolean alreadyAvaliable = false;

        for (int i = 0; i < avaliable.size(); i++) {
            if (peer.equals(avaliable.get(i))) {
                alreadyAvaliable = true;
            } else {
                alreadyAvaliable = false;
            }
        }

        if (alreadyAvaliable) {
            return true;
        } else {
            return false;
        }
    }

    public void removeConnected(String peer) {

        for (int i = 0; i < connected.size(); i++) {
            if (peer.equals(connected.get(i))) {
                 connected.remove(i);
            }
        }

    }
}
