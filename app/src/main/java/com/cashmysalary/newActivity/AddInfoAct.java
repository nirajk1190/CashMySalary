package com.cashmysalary.newActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.cashmysalary.R;
import com.cashmysalary.activity.ImagePickerActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AddInfoAct extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private AppCompatButton btnReview, btnPrevious;
    private static final String TAG = AddInfoAct.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;
    private ImageView ivUploadRC, ivUploadRCCamera;
    private boolean isReview;
    private LinearLayout llPrevious;
    private ImageView ivClose;
    /*Inital commit...*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_additional_info);
        mContext = this;
        Intent i = getIntent();
        if (i != null) {
            isReview = i.getBooleanExtra("isReview", false);
        }
        init();
        applyInit();
    }

    private void applyInit() {
        if (isReview) {
            ivClose.setVisibility(View.VISIBLE);
            llPrevious.setVisibility(View.GONE);
            btnReview.setText(getResources().getString(R.string.done));
        }
    }

    private void init() {
        llPrevious = findViewById(R.id.llPrevious);
        ivClose = findViewById(R.id.ivClose);
        btnReview = findViewById(R.id.btnReview);
        btnPrevious = findViewById(R.id.btnPrevious);

        ivUploadRC = findViewById(R.id.ivUploadRC);
        ivUploadRCCamera = findViewById(R.id.ivUploadRCCamera);

        btnReview.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        ivUploadRC.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnReview) {
            if (isReview) {
                finish();
            } else {
                Intent i = new Intent(mContext, ReviewApplicationActivity.class);
                i.putExtra("isReview", isReview);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }

        }
        if (v.getId() == R.id.btnPrevious) {
            Intent i = new Intent(mContext, SalaryAccountDetailsActivity.class);
            i.putExtra("isReview", isReview);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }
        if (v.getId() == R.id.ivUploadRC) {
            onImageClick();
        }
        if (v.getId() == R.id.ivClose) {
            finish();
        }
    }

    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(mContext, new ImagePickerActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent(mContext, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchCameraIntent() {
        Intent intent = new Intent(mContext, ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    public void onImageClick() {
        Dexter.withActivity(AddInfoAct.this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            showImagePickerOptions();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            Log.e(TAG, "Called");
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);

                    // loading profile image from local cache
                    loadProfile(uri.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadProfile(String url) {
        Log.d(TAG, "Image cache path: " + url);
        ivUploadRCCamera.setVisibility(View.GONE);
        Glide.with(this).load(url)
                .into(ivUploadRC);
        ivUploadRC.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));

    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(mContext));
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", Objects.requireNonNull(mContext).getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }
}












