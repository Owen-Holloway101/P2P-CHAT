package tk.zeryter.p2pchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Owen Holloway
 * ZerytSoft
 * Date: 5/01/14
 */

public class ConsoleInput implements Runnable {
    @Override
    public void run() {

        while (P2PChatMain.running) {

            //Reset input
            String inputString = "";

            //Setup new bufferRead
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            try {
                //Make read into string, this will wait until a string is input
               inputString = bufferRead.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Quit if "quit" is input
            if (inputString.equals("quit")) {
                System.exit(0);
            }

            if (inputString.length() >= 4) {
            System.out.println(inputString.substring(0,4));
            if (inputString.substring(0,4).equals("send")) {
                Message.send(inputString.substring(5,inputString.length()));
            }
            }

        }

    }
}
