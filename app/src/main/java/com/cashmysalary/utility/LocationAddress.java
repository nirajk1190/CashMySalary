package com.cashmysalary.utility;

/**
 * Created by bijay.laxmi on 12-02-2018.
 */

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationAddress {
    private static final String TAG = "LocationAddress";

    public static String getAddressFromLocation(final double latitude, final double longitude,
                                                final Context context) {
        Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
        String result = null;
        try {
            List<Address> addressList = geocoder.getFromLocation(
                    latitude, longitude, 1);
            if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    sb.append(address.getAddressLine(i)).append(", ");
                }
                Log.v(TAG, "LOCATION-- " + addressList.get(0).getFeatureName() + ", " + addressList.get(0).getLocality() + ", " + addressList.get(0).getAdminArea());
                Log.v(TAG, "");
                sb.append(addressList.get(0).getFeatureName()).append(",");

                //sb.append(addressList.get(0).getPremises()).append(",");//
                //sb.append(addressList.get(0).getSubAdminArea()).append(",");//
                sb.append(addressList.get(0).getLocality()).append(",");
                sb.append(addressList.get(0).getSubLocality()).append(",");

                sb.append(addressList.get(0).getPostalCode()).append(", ");
                sb.append(addressList.get(0).getAdminArea()).append(",");
                //  sb.append(address.getCountryName());
                result = sb.toString();
            }
        } catch (IOException e) {
            Log.e(TAG, "Unable connect to Geocoder", e);
        } finally {

            if (result != null) {
                result =
                        "" + result;
            } else {
                result = "Latitude: " + latitude + " Longitude: " + longitude +
                        "\n Unable to get address for this lat-long.";
            }

        }
        return result;
    }

    public static double calculateKilometers(double meters) {
        double kilometers = 0;
        try {
            kilometers = meters * 0.001;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kilometers;
    }
}