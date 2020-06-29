package com.cashmysalary.utility;

import android.os.Build;


//Device Util Class
//Get Device Version, DeviceOEM, Device Model
public final class DeviceUtil {


    private DeviceUtil() {
        throw new Error("Do not need instantiate!");
    }


    /**
     * Device SDK Version
     *
     * @return
     */
    public static String getAndroidVersion() {

        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release + ")";

    }


    /**
     * Device Original equipment manufacturer
     *
     * @return
     */
    public static String deviceOEM() {

        return Build.MANUFACTURER.toString();

    }


    /**
     * Device Model
     *
     * @return
     */
    public static String deviceModel() {

        return Build.MODEL;

    }
}
