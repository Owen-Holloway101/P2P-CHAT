package tk.zeryter.p2pchat;

import java.util.ArrayList;

public class Peers {

    static ArrayList<String> avaliable = new ArrayList<String>();
    static ArrayList<String> avaliableAddress = new ArrayList<String>();
    static ArrayList<String> connected = new ArrayList<String>();
    static ArrayList<String> connectedAddress = new ArrayList<String>();

    public static void addConnected(String peer, String address) {

        connected.add(peer);
        avaliableAddress.add(address);

    }

    public static void addAvaliable(String peer, String address) {

        avaliable.add(peer);
        avaliableAddress.add(address);

        System.out.println("added:" + address + ":" + peer);

    }

    public static boolean isAlreadyConnected (String peer) {

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

    public static boolean isAlreadyAvaliable (String peer) {

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

    public static void removeConnected(String peer) {

        for (int i = 0; i < connected.size(); i++) {
            if (peer.equals(connected.get(i))) {
                 connected.remove(i);
                 connectedAddress.remove(i);
            }
        }

    }

    public static void removeAvaliable(String peer) {

        for (int i = 0; i < avaliable.size(); i++) {
            if (peer.equals(avaliable.get(i))) {
                avaliable.remove(i);
                avaliableAddress.remove(i);
            }
        }


    }
}