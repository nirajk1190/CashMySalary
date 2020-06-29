package com.cashmysalary.utility;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.WindowManager;

import com.cashmysalary.R;
import com.rey.material.widget.ProgressView;

public class CustomProgressView extends Dialog {


    public static CustomProgressView show(Context context, CharSequence title,
                                          CharSequence message) {
        return show(context, title, message, false);
    }

    public static CustomProgressView show(Context context, CharSequence title,
                                          CharSequence message, boolean indeterminate) {
        return show(context, title, message, indeterminate, false, null);
    }

    public static CustomProgressView show(Context context, CharSequence title,
                                          CharSequence message, boolean indeterminate, boolean cancelable) {
        return show(context, title, message, indeterminate, cancelable, null);
    }

    public static CustomProgressView show(final Context context, CharSequence title,
                                          CharSequence message, boolean indeterminate,
                                          boolean cancelable, OnCancelListener cancelListener) {
        final CustomProgressView dialog = new CustomProgressView(context);
        ProgressView progressView;

        //Hiding notification panel code started
      /*  dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        dialog.getWindow().getDecorView().setSystemUiVisibility(View.GONE);*/

        dialog.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface mdialog) {
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
            }
        });

        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.setContentView(R.layout.custom_progress_view);
        progressView = (ProgressView) dialog.findViewById(R.id.progressView);
        progressView.start();
        dialog.show();

        return dialog;
    }

    public CustomProgressView(Context context) {
        super(context, R.style.NewDialog);
    }
}