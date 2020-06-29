
package com.cashmysalary;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseIntArray;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.cashmysalary.application.Application;
import com.cashmysalary.utility.CustomProgressDialog;

import static com.cashmysalary.util.Util.getStringRes;


public class BaseActivity extends AppCompatActivity {
    //Save the path as a string value


    public static Context mContext;
    //    private ProgressDialog mProgressDialog;
    public boolean isReplaced = false;

    public static Activity mActivity;
    protected Fragment fragmentCurrent;
    public FragmentManager fragmentManager;

    private String mImageUrl;
    private boolean isUpdateImage = false;
    protected CustomProgressDialog _progressDialog = null;
    private SparseIntArray mErrorString;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
    }


    public void addFragment(Fragment fragment, int containerId) {
        fragmentCurrent = fragment;
        fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment).addToBackStack("tag")
                .commit();
    }

    public void replaceFragment(Fragment fragment, int containerId) {
        isReplaced = true;
        fragmentCurrent = fragment;
        fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack("tag")
                .commitAllowingStateLoss();
    }


    public void showProgressDialog() {
        showProgressDialog(getStringRes(R.string.please_wait));
    }

    protected void showProgressDialog(Context context, int message) {
        _progressDialog = new CustomProgressDialog(this, getResources().getString(message));
        _progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        _progressDialog.setCancelable(true);
        if (null != _progressDialog) {
            _progressDialog.setMessage(getResources().getString(message));
            if (!_progressDialog.isShowing())
                _progressDialog.show();
        }
    }

    protected void showProgressDialog(int title, int message) {
        if (null != _progressDialog) {
            _progressDialog.setTitle(title);
            _progressDialog.setMessage(getResources().getString(message));
            _progressDialog.show();
        }
    }


    /**
     * Show progress dialog.
     *
     * @param messageText the message text
     */
    protected void showProgressDialog(String messageText) {
        try {
            if (Application.getContext() != null) {
                _progressDialog = new CustomProgressDialog(BaseActivity.this, messageText);
//                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                _progressDialog.setCancelable(true);
                if (null != _progressDialog) {
                    _progressDialog.setMessage(messageText);
                    _progressDialog.show();
                }
            }
        } catch (Exception e) {

        }
    }

    public void showProgressDialog(int msgId) {
        String message = getStringRes(msgId);
        showProgressDialog(message);
    }

    public void dismissProgress() {
        if (null != _progressDialog && _progressDialog.isShowing()) {
            _progressDialog.dismiss();
        }
    }

    public void dismissProgressDialog() {
        if (null != _progressDialog && _progressDialog.isShowing()) {
            _progressDialog.dismiss();
        }
    }


    protected boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            return checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED;
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissProgress();
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }

}
