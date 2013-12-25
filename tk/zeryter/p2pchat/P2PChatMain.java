package tk.zeryter.p2pchat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 13/11/13
 */

public class P2PChatMain {

    public static boolean running = true;

    public static Path P2PDIR = Paths.get(System.getProperty("user.home") + "/.P2P-CHAT");

    public static void main(String args[]) {

        if (Files.notExists(P2PDIR)) {
            try {
                Files.createDirectories(P2PDIR);
                System.out.println("First time run dir creation");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}