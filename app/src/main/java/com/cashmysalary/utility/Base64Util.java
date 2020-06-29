package com.cashmysalary.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * The type Base 64 util.
 */
public class Base64Util {

    public static String BitMapToString(Bitmap bitmap){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            byte[] arr = baos.toByteArray();
            Log.e("Base64Util", " Capture Bitmap Size after compress : "+arr.length);
            String result = Base64.encodeToString(arr, Base64.DEFAULT);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * String to  bitmap.
     *
     * @param image the image
     * @return the bitmap
     */
// String to Bitmap:
    public static Bitmap StringToBitMap(String image){
        try{
            byte [] encodeByte=Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }
}
