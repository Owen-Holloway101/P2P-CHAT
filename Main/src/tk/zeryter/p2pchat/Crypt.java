//Owen Holloway GYC
package tk.zeryter.p2pchat;

import java.io.UnsupportedEncodingException;

public class Crypt {

    public String encode(String message, String pass) {

        System.out.println("encode");

        byte[] messageByte = new byte[0];
        try {
            messageByte = message.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] passByte = pass.getBytes();

        byte[] outputByte = new byte[message.length()];

        for (int i = 0; i < messageByte.length - 1; i++) {

            outputByte[i] = (byte)((messageByte[i] - passByte[i%(passByte.length-1)])%127);

        }

        printBytes(outputByte,"outputByte:encode");

        String output = new String(outputByte);

        return output;
    }

    public String decode(String data, String pass) {

        System.out.println("decode");

        byte[] passByte = pass.getBytes();

        byte[] dataByte = data.getBytes();

        byte[] outputByte = new byte[dataByte.length];

        for (int i = 0; i < dataByte.length - 1; i++) {

            outputByte[i] = (byte)((dataByte[i] + passByte[i%(passByte.length-1)])%127);

        }

        printBytes(outputByte,"outputByte:decode");

        String output = null;
        try {
            output = new String(outputByte,"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    UnicodeFormatter.byteToHex(array[k]));
        }
    }

}