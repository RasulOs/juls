package juls.string;

public class TextMasking {

    private TextMasking() { }

    public static String maskText(String text, int start, int end, char maskCharacter) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i >= start && i < end) {
                stringBuilder.append(maskCharacter);
            } else {
                stringBuilder.append(text.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
