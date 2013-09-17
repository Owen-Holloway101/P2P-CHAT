//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Crypt {

    public byte[] encode(String message, String pass) {

        System.out.println("encode");

        byte[] temp_messageByte = new byte[0];

        try {
            temp_messageByte = message.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] messageByte = new byte[1000];
        Arrays.fill(messageByte,(byte)0);

        System.arraycopy(temp_messageByte,0,messageByte,0,temp_messageByte.length);

        byte[] passByte = pass.getBytes();

        byte[] outputByte = new byte[1000];

        for (int i = 0; i < messageByte.length; i++) {

            outputByte[i] = (byte)(messageByte[i] - passByte[i%(passByte.length-1)]);

        }

        //printBytes(outputByte,"outputByte:encode");

        return outputByte;
    }

    public String decode(byte[] data, String pass) {

        System.out.println("decode");

        byte[] passByte = pass.getBytes();

        byte[] outputByte = new byte[data.length];

        for (int i = 0; i < data.length; i++) {

            outputByte[i] = (byte)(data[i] + passByte[i%(passByte.length-1)]);

        }

        //printBytes(outputByte,"outputByte:decode");

        String output = null;
        try {
            output = new String(outputByte,"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        output = output.trim();

        return output;
    }

    public byte[] utftobyte(String data) {

        byte[] returnByte = data.getBytes();

        return returnByte;

    }

    public String utftostring(byte[] data) {

        String returnString = null;

        try {
            returnString = new String(data, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        returnString = returnString.trim();

        return returnString;

    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    UnicodeFormatter.byteToHex(array[k]));
        }
    }

}