package juls.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String hash256(String message) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(message.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            // Take last 8 bits only
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                // If the value is between 0 and 15 append 0 in front of this value.
                // It will give you a String with a length of 256 bits everytime. (64 hex digits) (without padding)
                hexString.append('0');

            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
