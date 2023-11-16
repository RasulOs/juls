package juls.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {

    private Currency() { }

    public static String format(double amount, Locale locale) {

        return NumberFormat.getCurrencyInstance(locale).format(amount);
    }

    public static String format(String amount, Locale locale) {
        String totalPrice = amount.replaceAll(",", ".");

        Double totalPriceDouble = Double.parseDouble(totalPrice);

        return NumberFormat.getCurrencyInstance(locale).format(totalPriceDouble);
    }

    public static String formatToTl(double amount) {
        return format(amount, new Locale("tr", "TR"));
    }

    public static String formatToTl(String amount) {
        return format(amount, new Locale("tr", "TR"));
    }
}
