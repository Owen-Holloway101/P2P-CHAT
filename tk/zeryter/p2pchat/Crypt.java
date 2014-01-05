//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.io.UnsupportedEncodingException;

public class Crypt {

    public static byte[] encode(String message, String pass) {

        String encodedMessage = "";

        char encocodedChar[] = new char[message.length()];

        int passchar = 0;

        for (int i = 0; i < message.length(); i++) {

            if (passchar < pass.length() - 1) {

                passchar++;

            } else {
                passchar = 0;
            }

            encocodedChar[i] = (char) (((message.charAt(i) * pass.charAt(passchar))) + message.length());

            encodedMessage = encodedMessage + encocodedChar[i];

        }

        byte[] outputByte = utftobyte(encodedMessage);

        //printBytes(outputByte,"outputByte:encode");

        return outputByte;
    }

    public static String decode(byte[] data, String pass) {

        String output = utftostring(data);

        output = output.trim();

        String decodedMessage = "";

        char decodedChar[] = new char[output.length()];

        int passchar = 0;

        for (int i = 0; i < output.length(); i++) {

            if (passchar < pass.length() - 1) {

                passchar++;

            } else {
                passchar = 0;
            }

            decodedChar[i] = (char) ((output.charAt(i) - output.length()) / pass.charAt(passchar));

            decodedMessage = decodedMessage + decodedChar[i];

        }

        return decodedMessage;
    }

    public static byte[] utftobyte(String data) {

        return data.getBytes();

    }

    public static String utftostring(byte[] data) {

        String returnString = "";

        try {
            returnString = new String(data, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        returnString = returnString.trim();

        return returnString;

    }
}