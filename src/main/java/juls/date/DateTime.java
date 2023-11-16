package juls.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTime {

    private DateTime() { }

    public static String getDateAndTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault()).format(new Date());
    }

    public static String getDate() {
        GregorianCalendar calendar = new GregorianCalendar();

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
    }

    public static String getTime() {
        GregorianCalendar calendar = new GregorianCalendar();

        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDateDaysAgo(int days) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.add(Calendar.DATE, -days);

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDateMonthsAgo(int months) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.add(Calendar.MONTH, -months);

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDateYearsAgo(int years) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.add(Calendar.YEAR, -years);

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDate(long millisFromUnixEpoch) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTimeInMillis(millisFromUnixEpoch);

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
    }

    public static String[] getStartAndEndDates(long startMillisFromUnixEpoch, long endMillisFromUnixEpoch) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTimeInMillis(startMillisFromUnixEpoch);

        String startDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());

        calendar.setTimeInMillis(endMillisFromUnixEpoch);

        String endDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());

        return new String[]{ startDate, endDate };
    }
}
