package juls.numbers;

public class Binary {

    private Binary() { }

    public static String convertStringToBinary(String str) {

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            sb.append(
                    String.format("%8s", Integer.toBinaryString(c))
                            .replaceAll(" ", "0")
            );
        }

        return sb.toString();
    }

    public static String prettyBinary(String binary, int blockSize, String separator) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {

            if (i % blockSize == 0 && i != 0)
                sb.append(separator);

            sb.append(binary.charAt(i));
        }

        return sb.toString();
    }
}
