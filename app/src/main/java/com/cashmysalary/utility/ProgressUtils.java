package com.cashmysalary.utility;

import android.app.Activity;
import android.content.DialogInterface;

public class ProgressUtils {
    private static CustomProgressView mProgressDialog;

    public static void showSimpleProgressDialog(final Activity activity, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = CustomProgressView.show(activity, title, msg);
                mProgressDialog.setCancelable(isCancelable);
                mProgressDialog.setCanceledOnTouchOutside(false);
                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ProgressUtils.mProgressDialog = null;
                        dialog.dismiss();
                    }
                });
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {

                    mProgressDialog.dismiss();
                    mProgressDialog = null;

                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

