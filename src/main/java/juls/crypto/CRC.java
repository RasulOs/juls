package juls.crypto;

import java.util.Locale;
import java.util.zip.CRC32;

public class CRC {

    private CRC() { }

    public static String getCRC32String(byte[] data) {
        CRC32 fileCRC32 = new CRC32();
        fileCRC32.update(data);
        return String.format(Locale.US, "%08X", fileCRC32.getValue());
    }

    public static byte[] getCRC32Byte(byte[] data, int startIndex, int endIndex) {

        // Copy the array and fill it
        byte[] newData = new byte[endIndex - startIndex];

        System.arraycopy(data, startIndex, newData, 0, newData.length);

        CRC32 fileCRC32 = new CRC32();
        fileCRC32.update(newData);

        long crc32 = fileCRC32.getValue();

        byte[] bytes = new byte[4];

        bytes[0] = (byte) (crc32 >>> 24);
        bytes[1] = (byte) (crc32 >>> 16);
        bytes[2] = (byte) (crc32 >>> 8);
        bytes[3] = (byte) (crc32);

        return bytes;
    }
}
