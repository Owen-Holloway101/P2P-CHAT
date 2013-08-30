//Owen Holloway GYC
package tk.zeryter.p2pchat;

public class Crypt {

    public String code(String message, String pass) {

        char messageChar[] = new char[message.length()];
        char passChar[] = new char[message.length()];
        char codedChar[] = new char[message.length()];

        int passcharPos = 0;

        for (int i = 0; i < message.length(); i++) {

            passChar[i] = pass.charAt(passcharPos);

            if (passcharPos == pass.length()) {
                passcharPos = 0;
            } else {
                passcharPos++;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            messageChar[i] = message.charAt(i);

            int temp_int = ((int) messageChar[i] + (int) passChar[i]);
            passChar[i] = (char) temp_int;

        }

        String output = "";

        for (int i =0; i < message.length(); i++) {

            output = output + passChar[i];

        }

        return output;

    }

}
