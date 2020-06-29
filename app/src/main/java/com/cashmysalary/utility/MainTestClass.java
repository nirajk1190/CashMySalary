package com.cashmysalary.utility;

public class MainTestClass {

    public static void main(String[] ags) {
        /*String CurrentDate = DateTimeUtils.getCurrentDate(DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss);
        System.out.println("Current Date Time: "+CurrentDate);

        String date = DateTimeUtils.getDate(CurrentDate, DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss,
                DateTimeUtils.DATE_FORMAT_ddMMMyyyy);
        System.out.println("Current Date: "+date);

        String UTCDate = DateTimeUtils.getDateTimeUTC(CurrentDate, DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss,
                DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss);
        System.out.println("UTC Date: "+UTCDate);

        String LocaleDate = DateTimeUtils.getDateTimeLocale(UTCDate, DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss,
                DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss);
        System.out.println("Locale Date: "+ LocaleDate);



        String time = DateTimeUtils.getDate(CurrentDate, DateTimeUtils.DATE_TIME_FORMAT_yyyyMMddTHHmmss,
                DateTimeUtils.TIME_FORMAT_HHmmss);
        System.out.println("Current Time: "+time);

        String UTCTime = DateTimeUtils.getTimeUTC(time, DateTimeUtils.TIME_FORMAT_HHmmss,
                DateTimeUtils.TIME_FORMAT_HHmmss);
        System.out.println("UTC Time: "+UTCTime);

        String LocaleTime = DateTimeUtils.getTimeLocale(UTCTime, DateTimeUtils.TIME_FORMAT_HHmmss,
                DateTimeUtils.TIME_FORMAT_HHmmss);
        System.out.println("Locale Time: "+ LocaleTime);*/


        String sID = "266fd6ec-07f9-4f5d-9c30-3b04b01a20af";
        String str = sID.replaceAll("[^0-9]+", "");

        System.out.println("Current string: " + str);


    }
}
