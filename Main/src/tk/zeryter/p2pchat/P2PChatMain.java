package tk.zeryter.p2pchat;

import tk.zeryter.p2pchat.window.Window;

public class P2PChatMain {

    public static void main(String[] args) {

        new Thread(new Window()).start();

    }

}
