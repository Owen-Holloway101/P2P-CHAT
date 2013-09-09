//Owen Holloway GYC
package tk.zeryter.p2pchat;

public class Crypt {

    public String code(String message, String pass) {

        char passChar[] = new char[message.length() + 1];
        char codedChar[] = new char[message.length() + 1];

        int passcharPos = 0;


        for (int i = 0; i < message.length(); i++) {

            passChar[i] = pass.charAt(passcharPos);

            if (passcharPos == pass.length() - 1) {
                passcharPos = 0;
            } else {
                passcharPos++;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            codedChar[i] = (char)((((message.charAt(i)) - passChar[i]) - pass.charAt(pass.length() - 1)*(message.length()-i))-pass.charAt(0)*i);
        }

        String output = "";

        for (int i =0; i < message.length(); i++) {

            output = output + codedChar[i];

        }

        return output;
    }

    public String decode(String message, String pass) {

        char passChar[] = new char[message.length()];
        char codedChar[] = new char[message.length()];

        int passcharPos = 0;

        for (int i = 0; i < message.length(); i++) {

            passChar[i] = pass.charAt(passcharPos);

            if (passcharPos == pass.length() - 1) {
                passcharPos = 0;
            } else {
                passcharPos++;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            codedChar[i] = (char)((((message.charAt(i)) + pass.charAt(0)*i ) + (pass.charAt(pass.length() - 1)*(message.length()-i))) + passChar[i]);
        }

        String output = "";

        for (int i =0; i < message.length(); i++) {

            output = output + codedChar[i];

        }

        return output;
    }

}