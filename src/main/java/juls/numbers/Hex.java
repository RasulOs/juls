package juls.numbers;

public class Hex {

    private Hex() {}

    // Takes a string with numbers or characters and returns
    // a string with hex digits corresponding to them in the
    // ASCII representation.
    public static String toAsciiHex(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c: str.toCharArray()) {
            sb.append(
                    String.format("%02x", (int) c)
            );
        }

        return sb.toString();
    }

    // Takes a string with hex digits and returns the formatted string
    public static String prettyHex(String str, int blockSize, String separator ) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (i % blockSize == 0 && i != 0)
                sb.append(separator);

            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
