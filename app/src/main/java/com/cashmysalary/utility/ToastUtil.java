package com.cashmysalary.utility;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cashmysalary.R;


//Toast Util Class
public final class ToastUtil {


    private static final int TOAST_MARGIN_BOTTOM_DP = 0;

    private static Toast mSingletonToast;

    public static void showToast(Context pContext, String pMessage) {
        showToast(pContext, pMessage, Toast.LENGTH_SHORT);
    }


    public static void showToast(Context pContext, String pMessage, int pDuration) {
        if (pMessage == null || pMessage.trim().length() == 0) {
            return;
        }

        if (pDuration != Toast.LENGTH_LONG && pDuration != Toast.LENGTH_SHORT) {
            pDuration = Toast.LENGTH_LONG;
        }

        if (mSingletonToast == null) {


            mSingletonToast = Toast.makeText(pContext.getApplicationContext(), pMessage, pDuration);
            mSingletonToast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        try {
            mSingletonToast.setDuration(pDuration);
            mSingletonToast.setText(pMessage);
            View view1 = mSingletonToast.getView();
            view1.setBackgroundResource(R.drawable.rectangle_round_shape_black);
            TextView toastMessage = (TextView) mSingletonToast.getView().findViewById(android.R.id.message);
            toastMessage.setTextColor(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mSingletonToast.show();
    }

    public static void showToast(Context pContext, String pMessage, int pDuration, int color) {
        if (pMessage == null || pMessage.trim().length() == 0) {
            return;
        }

        if (pDuration != Toast.LENGTH_LONG && pDuration != Toast.LENGTH_SHORT) {
            pDuration = Toast.LENGTH_SHORT;
        }

        if (mSingletonToast == null) {


            mSingletonToast = Toast.makeText(pContext.getApplicationContext(), pMessage, pDuration);
            mSingletonToast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        try {
            mSingletonToast.setDuration(pDuration);
            mSingletonToast.setText(pMessage);
            View view1 = mSingletonToast.getView();
            view1.setBackgroundResource(color);
            TextView toastMessage = (TextView) mSingletonToast.getView().findViewById(android.R.id.message);
            toastMessage.setTextColor(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mSingletonToast.show();
    }

    public static void removeToast() {
        if (mSingletonToast == null) {
            mSingletonToast.cancel();
        }
    }
}