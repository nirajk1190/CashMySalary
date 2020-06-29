package com.cashmysalary.utility;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Currency {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String convertToIndianCurrency(String num) {
        BigDecimal bd = new BigDecimal(num);
        long number = bd.longValue();
        long no = bd.longValue();
        int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);
        int digits_length = String.valueOf(no).length();
        int i = 0;
        ArrayList<String> str = new ArrayList<>();
        HashMap<Integer, String> words = new HashMap<>();
        words.put(0, "");
        words.put(1, "One");
        words.put(2, "Two");
        words.put(3, "Three");
        words.put(4, "Four");
        words.put(5, "Five");
        words.put(6, "Six");
        words.put(7, "Seven");
        words.put(8, "Eight");
        words.put(9, "Nine");
        words.put(10, "Ten");
        words.put(11, "Eleven");
        words.put(12, "Twelve");
        words.put(13, "Thirteen");
        words.put(14, "Fourteen");
        words.put(15, "Fifteen");
        words.put(16, "Sixteen");
        words.put(17, "Seventeen");
        words.put(18, "Eighteen");
        words.put(19, "Nineteen");
        words.put(20, "Twenty");
        words.put(30, "Thirty");
        words.put(40, "Forty");
        words.put(50, "Fifty");
        words.put(60, "Sixty");
        words.put(70, "Seventy");
        words.put(80, "Eighty");
        words.put(90, "Ninety");

        String digits[] = {"", "Hundred", "Thousand", "Lakh", "Crore"};
        while (i < digits_length) {
            int divider = (i == 2) ? 10 : 100;
            number = no % divider;
            no = no / divider;
            i += divider == 10 ? 1 : 2;
            if (number > 0) {
                int counter = str.size();
                String plural = (counter > 0 && number > 9) ? "s" : "";
                String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural : words.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) + " " + words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;
                str.add(tmp);
            } else {
                str.add("");
            }
        }

        Collections.reverse(str);
        String Rupees = String.join(" ", str).trim();

        String paise = (decimal) > 0 ? " And Paise " + words.get(Integer.valueOf((int) (decimal - decimal % 10))) + " " + words.get(Integer.valueOf((int) (decimal % 10))) : "";
        return "Rupees " + Rupees + paise + " Only";
    }

        public static String withSuffix(double count) {
            //
            int exp;
            if (count < 1000) return "" + count;
            if (count < 100000)
                return String.format("%.2f %c",
                        count / Math.pow(1000, 1),
                        "kLC".charAt(1 - 1));
            if (count >= 100000 && count<10000000) {
                count = count / 1000;
                exp = (int) (Math.log((count)) / Math.log(100));

                double temp =  (count) / Math.pow(100, exp);
                double v = Math.floor(temp * 100) / 100.0;
              //  Log.e("withSuffix","########################### withSuffix ############################"+temp);
                return String.format("%.2f %c",
                        v,
                        "LC".charAt(exp - 1));
            }else {
                return  String.format("%.2f %c",
                        (count) / 10000000,
                        'C' );
            }


        }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("56721351.61 = " + Currency.convertToIndianCurrency("56721351.61"));
        System.out.println("52982156721351.61 = " + Currency.withSuffix(52982156721351.61));
        System.out.println("2982156721351.61 = " + Currency.withSuffix(2982156721351.61));
        System.out.println("182156721351.615 = " + Currency.withSuffix(182156721351.615));
        System.out.println("42156721351.61 = " + Currency.withSuffix(42156721351.61));
        System.out.println("2156721351.61 = " + Currency.withSuffix(2156721351.61));
        System.out.println("156721351.61 = " + Currency.withSuffix(156721351.61));
        System.out.println("56721351.61 = " + Currency.withSuffix(56721351.61));
        System.out.println("6721351.61 = " + Currency.withSuffix(6721351.61));
        System.out.println("721351.61 = " + Currency.withSuffix(721351.61));
        System.out.println("21351.61 = " + Currency.withSuffix(21351.61));
        System.out.println("1351.61 = " + Currency.withSuffix(1351.61));
        System.out.println("351.61 = " + Currency.withSuffix(351.61));
        System.out.println("51.61 = " + Currency.withSuffix(51.61));
    }
  /*  public static String indianNumberFormatLong(long amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        String moneyString = formatter.format(amount);

        return moneyString.replaceAll("Rs.","").replaceAll(getStringRes(R.string.Rs),"").replace(".00","").replace(".0","");
    }*/

    public static String formatValueCrore(long value) {

        if (value>=0) {
            try {
                if (!Currency.withSuffix(value).equalsIgnoreCase("0.0"))
                    return Currency.withSuffix(value);
                else {
                    return "0";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (value<=0) {
            String valuestr=String.valueOf(value);
            valuestr=valuestr.replace("-","");
            long valuestrlong=Long.parseLong(valuestr);
            Log.e("######","##### valuestrlong ########"+valuestrlong);
            try {
                if (!Currency.withSuffix(valuestrlong).equalsIgnoreCase("0.0")) {
                    Log.e("######", "##### Currency.withSuffix(valuestrlong) ########" + "-" + Currency.withSuffix(valuestrlong));
                    return "-" + Currency.withSuffix(valuestrlong);
                }else {
                    return "0";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return Currency.withSuffix(value);
    }
}