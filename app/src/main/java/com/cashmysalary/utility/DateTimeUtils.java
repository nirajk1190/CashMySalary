package com.cashmysalary.utility;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//Date Time Util Class
public class DateTimeUtils {
    public static final String formatDate = "dd-MM-yyyy";
    public static final String formatDate1 = "yyyy-MM-dd";

    public static final String DATE_FORMAT = "dd MMM yyyy";
    public static final String DATE_FORMAT5 = "dd MMMM yyyy";
    public static final String DATE_FORMAT2 = "dd MMM,yyyy";
    public static final String DATE_FORMAT3 = "EEEE dd MMM,yyyy";
    public static final String DATE_FORMAT4 = "dd MMM";
    public static final SimpleDateFormat format2 = new SimpleDateFormat(DATE_FORMAT);
    public static final SimpleDateFormat format23 = new SimpleDateFormat(formatDate);
    public static final SimpleDateFormat format32 = new SimpleDateFormat(formatDate1);
    public static final SimpleDateFormat format34 = new SimpleDateFormat(DATE_FORMAT5);
    public static final SimpleDateFormat format35 = new SimpleDateFormat(DATE_FORMAT3);

    public static final String format7 = "yyyy-MM-dd";
    public static final String format8 = "MM-dd-yyyy";
    public static final String format6 = "dd-MM-yyyy";
    public static final String format9 = "dd-MMM-yyyy";
    public static final String format13 = "dd/MM/yyyy";
    public static final String format14 = "MM/dd/yyyy hh:mm:ss aa";
    public static final SimpleDateFormat format33 = new SimpleDateFormat(format8);
    public static final SimpleDateFormat format7_ = new SimpleDateFormat(format7);
    public static final String DATE_TIME_FORMAT_yyyyMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT_yyyyMMddTHHmm = "yyyy-MM-dd'T'HH:mm";
//     5/9/2019 10:58:00 AM
    public static final String DATE_TIME_FORMAT_ddMMyyyhhmmssaa = "dd/MM/yyyy hh:mm:ss aa";
    public static final String DATE_TIME_FORMAT_ddMMyyyhhmmaa = "dd MMM yyyy, hh:mm aa";
    public static final SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat format10 = new SimpleDateFormat(format9);
    public static final SimpleDateFormat format11 = new SimpleDateFormat(DATE_FORMAT2);
    public static final SimpleDateFormat format12 = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
    public static final SimpleDateFormat formatdd = new SimpleDateFormat("dd");
    public static final SimpleDateFormat formatMMM = new SimpleDateFormat("MMM");
    public static final SimpleDateFormat formathhmma = new SimpleDateFormat("hh:mm aa");
    public static final SimpleDateFormat formatddMMMyyyyhhmm = new SimpleDateFormat("dd MMM yyyy,hh:mm:ss");
    public static final SimpleDateFormat formatddMMMyyyyhhmma = new SimpleDateFormat("dd MMM yyyy, hh:mm aa");
    public static final SimpleDateFormat formatTIME_FORMAT_hhmmaa = new SimpleDateFormat("hh:mm aa");
    public static final SimpleDateFormat formatddMMM = new SimpleDateFormat(DATE_FORMAT4);
    public static final String DATE_FORMAT_yyyyMMdd = "yyyy-MM-dd";

    public static final String DATE_FORMAT_ddMMMyyyy = "dd MMM yyyy";
//    09 May 2019,12:00:00
    public static final String DATE_FORMAT_ddMMMyyyyhhmmss = "dd MMM yyyy,hh:mm:ss";

    public static final String DATE_FORMAT_ddMMyyyy = "dd MM yyyy";

    public static final String TIME_FORMAT_hhmm = "hh:mm";

    public static final String TIME_FORMAT_HHmm = "HH:mm";

    public static final String TIME_FORMAT_hhmmss = "HH:mm:ss";
    public static final String TIME_FORMAT_hh_mm_ss = "hh:mm:ss";

    public static final String TIME_FORMAT_HHmmss = "HH:mm:ss";

    public static final String TIME_FORMAT_hhmma = "hh:mm aa";

    /**
     * Gets formatted dates.
     *
     * @param strCurrentDate the str current date
     * @param dateFormat1    the date format 1
     * @param format3        the format 3
     * @return the formatted dates
     */
    public static String getFormattedDates(String strCurrentDate, String dateFormat1, SimpleDateFormat format3) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat1);
            Date newDate = format.parse(strCurrentDate);
            return format3.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get current date in dd MMM yyyy Format
     *
     * @return
     */
    public static String getCurrnetTime() {

        DateFormat df = new SimpleDateFormat(TIME_FORMAT_hhmmss);
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    /**
     * get current date in yyyyMMddTHHmmss Format
     *
     * @return
     */
    public static String getCurrentDate(String sPattern) {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(sPattern);
        String formattedDate = df.format(c.getTime());

        return formattedDate;
    }

    public static String getCurrentDay() {
        String weekDay = "";

        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == dayOfWeek) {
            weekDay = "Mon";
        } else if (Calendar.TUESDAY == dayOfWeek) {
            weekDay = "Tue";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            weekDay = "Wed";
        } else if (Calendar.THURSDAY == dayOfWeek) {
            weekDay = "Thu";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            weekDay = "Fri";
        } else if (Calendar.SATURDAY == dayOfWeek) {
            weekDay = "Sat";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            weekDay = "Sun";
        }
        return weekDay;
    }


    /**
     * @param dDate
     * @param sPattern
     * @return
     */
    public static String dateToString(Date dDate, String sPattern) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(sPattern);
            return df.format(dDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(Date date, String sPattern) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(sPattern);
            return df.parse(df.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param sDate
     * @param sPattern
     * @return
     */
    public static Date stringToDate(String sDate, String sPattern) {
        SimpleDateFormat df = new SimpleDateFormat(sPattern);
        Date date = null;
        try {
            date = df.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }


    /**
     * @param dDate
     * @param sPattern
     * @return
     */
    public static String dateToStringUTC(Date dDate, String sPattern) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(sPattern);
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            return df.format(dDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param sDate
     * @param sDatePattern
     * @param sReturnPattern
     * @return
     */
    public static final String getDateTimeUTC(String sDate, String sDatePattern, String sReturnPattern) {

        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sDatePattern);
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            targetFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date1 = originalFormat.parse(sDate);
            formattedDate = targetFormat.format(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    /**
     * @param sDate
     * @param sDatePattern
     * @param sReturnPattern
     * @return
     */
    public static final String getDateTimeLocale(String sDate, String sDatePattern, String sReturnPattern) {

        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sDatePattern);
            originalFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            Date date = originalFormat.parse(sDate);
            formattedDate = targetFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedDate;
    }


    public static final String getDateOrTime(String sDate) {
        String DateOrTime = null;

        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(DATE_TIME_FORMAT_yyyyMMddTHHmmss);
            originalFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = originalFormat.parse(sDate);
            DateFormat targetDateFormate = new SimpleDateFormat(DATE_FORMAT_ddMMMyyyy);
            DateFormat targetTimeFormate = new SimpleDateFormat(TIME_FORMAT_hhmma);
            formattedDate = targetDateFormate.format(date);

            String currentDate = getCurrentDate(DATE_FORMAT_ddMMMyyyy);
            int result = currentDate.compareTo(formattedDate);
            if (result == 0) {
                return targetTimeFormate.format(date);
            } else {
                return formattedDate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DateOrTime;
    }


    /**
     * @param sDate
     * @return
     */
    public static final String getDate(String sDate, String sDatePattern, String sReturnPattern) {

        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sDatePattern);
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            Date date = originalFormat.parse(sDate);
            formattedDate = targetFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedDate;
    }

    /**
     * @param sTime
     * @return
     */
    public static final String getTimeUTC(String sTime, String sTimePattern, String sReturnPattern) {

        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sTimePattern);
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            targetFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = originalFormat.parse(sTime);
            formattedDate = targetFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedDate;
    }

    /**
     * @param sTime
     * @return
     */
    public static final String getTimeLocale(String sTime, String sTimePattern, String sReturnPattern) {
        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sTimePattern);
            originalFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            Date date = originalFormat.parse(sTime);
            formattedDate = targetFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedDate;
    }

    /**
     * @param sTime
     * @return
     */
    public static final String getTime(String sTime, String sTimePattern, String sReturnPattern) {
        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat(sTimePattern);
            DateFormat targetFormat = new SimpleDateFormat(sReturnPattern);
            Date date = originalFormat.parse(sTime);
            formattedDate = targetFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formattedDate;
    }


    /**
     * get current year
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }


    /**
     * get current month
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;

    }


    /**
     * get currnet date
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * @param time
     * @return
     */
    public static String translateDate(Long time) {
        long oneDay = 24 * 60 * 60 * 1000;
        Calendar current = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));

        //  Calendar.HOUR——12 Calendar.HOUR_OF_DAY——24
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        long todayStartTime = today.getTimeInMillis();

        if (time >= todayStartTime && time < todayStartTime + oneDay) { // today
            return "Today";
        } else if (time >= todayStartTime - oneDay && time < todayStartTime) { // yesterday
            return "Yesterday";
        } else if (time >= todayStartTime - oneDay * 2 && time < todayStartTime - oneDay) { // the day before yesterday
            return "The day before yesterday";
        } else if (time > todayStartTime + oneDay) { // future
            return "Future";
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            return dateFormat.format(date);
        }
    }

    public static boolean compareDate(long date1, String date2) {
        Date strDate = null;
        try {
            strDate = format2.parse(date2);
            if (date1 > strDate.getTime()) {
              return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return false;
    }


    /**
     * @param time
     * @param curTime
     * @return
     */
    private String translateDate(long time, long curTime) {
        long oneDay = 24 * 60 * 60;
        Calendar today = Calendar.getInstance();    //Today
        today.setTimeInMillis(curTime * 1000);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        long todayStartTime = today.getTimeInMillis() / 1000;
        if (time >= todayStartTime) {
            long d = curTime - time;
            if (d <= 60) {
                return "1 minute ago";
            } else if (d <= 60 * 60) {
                long m = d / 60;
                if (m <= 0) {
                    m = 1;
                }
                return m + "minutes ago";
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("Nowadays HH:mm");
                Date date = new Date(time * 1000);
                String dateStr = dateFormat.format(date);
                if (!TextUtils.isEmpty(dateStr) && dateStr.contains(" 0")) {
                    dateStr = dateStr.replace(" 0", " ");
                }
                return dateStr;
            }
        } else {
            if (time < todayStartTime && time > todayStartTime - oneDay) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yesterday HH:mm");
                Date date = new Date(time * 1000);
                String dateStr = dateFormat.format(date);
                if (!TextUtils.isEmpty(dateStr) && dateStr.contains(" 0")) {

                    dateStr = dateStr.replace(" 0", " ");
                }
                return dateStr;
            } else if (time < todayStartTime - oneDay && time > todayStartTime - 2 * oneDay) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("The day before yesterday HH:mm");
                Date date = new Date(time * 1000);
                String dateStr = dateFormat.format(date);
                if (!TextUtils.isEmpty(dateStr) && dateStr.contains(" 0")) {
                    dateStr = dateStr.replace(" 0", " ");
                }
                return dateStr;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date(time * 1000);
                String dateStr = dateFormat.format(date);
                if (!TextUtils.isEmpty(dateStr) && dateStr.contains(" 0")) {
                    dateStr = dateStr.replace(" 0", " ");
                }
                return dateStr;
            }
        }
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static boolean validTime(Calendar current, Calendar selected) {
        return 0 < selected.compareTo(current);
    }

}
