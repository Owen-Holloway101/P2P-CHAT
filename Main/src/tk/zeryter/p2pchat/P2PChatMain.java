package tk.zeryter.p2pchat;

public class P2PChatMain {

    public static Network net = new Network();
    public static DiscoveryNet discnet = new DiscoveryNet();

    public static void main(String[] args) {
        System.out.println("Owen Holloway, GYC");
        System.out.println(" _____               _   ____         __ _   \n" +
                           "|__  /___ _ __ _   _| |_/ ___|  ___  / _| |_ \n" +
                           "  / // _ \\ '__| | | | __\\___ \\ / _ \\| |_| __|\n" +
                           " / /|  __/ |  | |_| | |_ ___) | (_) |  _| |_ \n" +
                           "/____\\___|_|   \\__, |\\__|____/ \\___/|_|  \\__|\n" +
                           "               |___/                         ");
        System.out.println("www.zeryter.tk");


       // new Thread(new Window()).start();

        net.setPort(5555);
        net.setPACKETSIZE(100);
        net.setRunning(true);
        new Thread(net).start();

        discnet.setPort(5555);
        discnet.setPACKETSIZE(100);
        discnet.setRunning(true);
        new Thread(discnet).start();


    }

}
