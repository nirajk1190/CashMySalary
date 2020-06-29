package com.cashmysalary.utility;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * The type Date and time util.
 */
//Date Time Util Class
public class DateAndTimeUtil {

    //Previously used "yyyyMMddHHmm" now using  "yyyy-MM-dd'T'HH:mm:ss.SSS" // sample "NextScheduleDateTime": "2018-05-21T13:07:46.203",
    private static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    /**
     * The constant DATE_AND_TIME_FORMAT_SIMPLE.
     */
// private static final SimpleDateFormat DATE_AND_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT_SIMPLE = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    /**
     * The constant DATE_AND_TIME_FORMAT_INDIA.
     */
    public static final SimpleDateFormat DATE_AND_TIME_FORMAT_INDIA = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
    private static final SimpleDateFormat DATE_AND_TIME_FORMAT_JSON_STANDARD = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
    private static final SimpleDateFormat DATE_AND_TIME_WITH_SECONDS_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
    private static final SimpleDateFormat READABLE_DAY_MONTH_FORMAT = new SimpleDateFormat("d MMMM", Locale.getDefault());
    private static final SimpleDateFormat READABLE_DAY_MONTH_YEAR_FORMAT = new SimpleDateFormat("d MMMM yyyy", Locale.getDefault());
    private static final SimpleDateFormat READABLE_TIME_24_FORMAT = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static final SimpleDateFormat READABLE_TIME_FORMAT = new SimpleDateFormat("h:mm a", Locale.getDefault());
    private static final SimpleDateFormat WEEK_DAYS_FORMAT = new SimpleDateFormat("EEEE", Locale.getDefault());
    private static final SimpleDateFormat SHORT_WEEK_DAYS_FORMAT = new SimpleDateFormat("E", Locale.getDefault());

    /**
     * To string readable date string.
     *
     * @param calendar the calendar
     * @return the string
     */
    public static String toStringReadableDate(Calendar calendar) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }

    /**
     * To string readable time string.
     *
     * @param calendar the calendar
     * @param context  the context
     * @return the string
     */
    public static String toStringReadableTime(Calendar calendar, Context context) {
        if (android.text.format.DateFormat.is24HourFormat(context)) {
            return READABLE_TIME_24_FORMAT.format(calendar.getTime());
        } else {
            return READABLE_TIME_FORMAT.format(calendar.getTime());
        }
    }
    public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {

        Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
        String parsedDate = formatter.format(initDate);
    //
        return parsedDate;
    }
    /**
     * To long date and time long.
     *
     * @param calendar the calendar
     * @return the long
     */
    public static Long toLongDateAndTime(Calendar calendar) {
        return Long.parseLong(DATE_AND_TIME_FORMAT.format(calendar.getTime()));
    }

    /**
     * To string date and time string.
     *
     * @param calendar the calendar
     * @return the string
     */
    public static String toStringDateAndTime(Calendar calendar) {
        return DATE_AND_TIME_FORMAT.format(calendar.getTime());
    }

    /**
     * To custom string date and time string.
     *
     * @param calendar     the calendar
     * @param customformat the customformat
     * @return the string
     */
    public static String toCustomStringDateAndTime(Calendar calendar,SimpleDateFormat customformat) {
        return customformat.format(calendar.getTime());
    }

    /**
     * To string date time with seconds string.
     *
     * @param calendar the calendar
     * @return the string
     */
    public static String toStringDateTimeWithSeconds(Calendar calendar) {
        return DATE_AND_TIME_WITH_SECONDS_FORMAT.format(calendar.getTime());
    }

    /**
     * Gets appropriate date format.
     *
     * @param context  the context
     * @param calendar the calendar
     * @return the appropriate date format
     */
    public static String getAppropriateDateFormat(Context context, Calendar calendar) {
        if (isThisYear(calendar)) {
            if (isThisMonth(calendar) && isThisDayOfMonth(calendar)) {
                return "Today";
            } else {
                return READABLE_DAY_MONTH_FORMAT.format(calendar.getTime());
            }
        } else {
            return READABLE_DAY_MONTH_YEAR_FORMAT.format(calendar.getTime());
        }
    }

    /**
     * Parse date and time calendar.
     *
     * @param dateAndTime the date and time
     * @return the calendar
     */
    public static Calendar parseDateAndTime(String dateAndTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_AND_TIME_FORMAT.parse(dateAndTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * Parse date and time test calendar.
     *
     * @param dateAndTime the date and time
     * @return the calendar
     */
    public static Calendar parseDateAndTimeTest(String dateAndTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_AND_TIME_FORMAT_JSON_STANDARD.parse(dateAndTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * Get week days string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getWeekDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String[] weekDays = new String[7];
        for (int i = 0; i < 7; i++) {
            weekDays[i] = WEEK_DAYS_FORMAT.format(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        return weekDays;
    }

    /**
     * Get short week days string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getShortWeekDays() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String[] weekDays = new String[7];
        for (int i = 0; i < 7; i++) {
            weekDays[i] = SHORT_WEEK_DAYS_FORMAT.format(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        return weekDays;
    }

    private static Boolean isThisYear(Calendar calendar) {
        Calendar nowCalendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) == nowCalendar.get(Calendar.YEAR);
    }

    private static Boolean isThisMonth(Calendar calendar) {
        Calendar nowCalendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) == nowCalendar.get(Calendar.MONTH);
    }

    private static Boolean isThisDayOfMonth(Calendar calendar) {
        Calendar nowCalendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH) == nowCalendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Gets custom date and time.
     *
     * @param dateAndTime the date and time
     * @return the custom date and time
     */
    public static String getCustomDateAndTime(String dateAndTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_AND_TIME_FORMAT.parse(dateAndTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.HOUR_OF_DAY, 0);
        calendarToday.set(Calendar.MINUTE, 0);
        calendarToday.set(Calendar.SECOND, 0);
        calendarToday.set(Calendar.MILLISECOND, 0);

        Date today = calendarToday.getTime();

        calendarToday.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendarToday.getTime();


        Date dueDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM, yyyy");
        String strDate = "Due on " + format.format(dueDate);
        if (dueDate.compareTo(today) == 0) {
            strDate = "Due Today | 0 day left";
        }
        if (dueDate.compareTo(tomorrow) == 0) {
            strDate = "Due Tomorrow | 1 day left";
        }
        return strDate;
    }


    /**
     * Gets my date and time.
     *
     * @param suffix      the suffix
     * @param dateAndTime the date and time
     * @return the my date and time
     */
    public static String getMyDateAndTime(String suffix,String dateAndTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_AND_TIME_FORMAT.parse(dateAndTime));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        Date dueDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        String strDate = suffix + format.format(dueDate);
        return strDate;
    }
 public static String getMyDateAndTime2(String dateAndTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_AND_TIME_FORMAT.parse(dateAndTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date dueDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy h:mm a");
        String strDate =  format.format(dueDate);
        return strDate;
    }

    public static String formatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getDateFromString(String sDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
