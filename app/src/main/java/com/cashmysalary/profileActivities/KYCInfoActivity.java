package com.cashmysalary.profileActivities;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
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

public class KYCInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_IMAGE = 100;
    private static final String TAG = KYCInfoActivity.class.getSimpleName();
    private Context mContext;
    private Toolbar toolbar;
    private AppCompatButton btnNext;
    private ImageView ivSelfie,ivAadhaarFront,ivAadhaarBack,ivPanCard,ivOther;
    private ImageView ivCamera,ivAadhaarFrontCamera,ivAadhaarBackCamera,ivPanCardCamera,ivOtherCamera;
    private boolean isSelfie = false;
    private boolean isAadhaarFront = false;
    private boolean isAadhaarBack = false;
    private boolean isPanCard;
    private boolean isOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyc);
        mContext = this;

        init();
        applyInit();
    }

    private void applyInit() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setTitle(getResources().getString(R.string.kyc_act_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnNext);

        ivSelfie = findViewById(R.id.ivSelfie);
        ivAadhaarFront = findViewById(R.id.ivAadhaarFront);
        ivAadhaarBack = findViewById(R.id.ivAadhaarBack);
        ivPanCard = findViewById(R.id.ivPanCard);
        ivOther = findViewById(R.id.ivOther);

        ivCamera = findViewById(R.id.ivCamera);
        ivAadhaarFrontCamera = findViewById(R.id.ivAadhaarFrontCamera);
        ivAadhaarBackCamera = findViewById(R.id.ivAadhaarBackCamera);
        ivPanCardCamera = findViewById(R.id.ivPanCardCamera);
        ivOtherCamera = findViewById(R.id.ivOtherCamera);


        btnNext.setOnClickListener(this);

        ivSelfie.setOnClickListener(this);
        ivAadhaarFront.setOnClickListener(this);
        ivAadhaarBack.setOnClickListener(this);
        ivPanCard.setOnClickListener(this);
        ivOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNext) {
            startActivity(new Intent(mContext,EmploymentInfoActivity.class));
        }if (v.getId() == R.id.ivSelfie) {
            isSelfie = true;
            onImageClick();
        }if (v.getId() == R.id.ivAadhaarFront) {
            isAadhaarFront = true;
            onImageClick();
        }if (v.getId() == R.id.ivAadhaarBack) {
            isAadhaarBack = true;
            onImageClick();
        }if (v.getId() == R.id.ivPanCard) {
            isPanCard = true;
            onImageClick();
        }if (v.getId() == R.id.ivOther) {
            isOther = true;
            onImageClick();
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
        Dexter.withActivity(KYCInfoActivity.this)
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
            Log.e(TAG,"Called");
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
        if (isSelfie){
            ivCamera.setVisibility(View.GONE);
            Glide.with(this).load(url)
                    .into(ivSelfie);
            ivSelfie.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));
            isSelfie = false;
        }if (isAadhaarFront){
            ivAadhaarFrontCamera.setVisibility(View.GONE);
            Glide.with(this).load(url)
                    .into(ivAadhaarFront);
            ivAadhaarFront.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));
            isAadhaarFront = false;
        }if (isAadhaarBack){
            ivAadhaarBackCamera.setVisibility(View.GONE);
            Glide.with(this).load(url)
                    .into(ivAadhaarBack);
            ivAadhaarBack.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));
            isAadhaarBack = false;
        }if (isPanCard){
            ivPanCardCamera.setVisibility(View.GONE);
            Glide.with(this).load(url)
                    .into(ivPanCard);
            ivPanCard.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));
            isPanCard = false;
        }if (isOther){
            ivOtherCamera.setVisibility(View.GONE);
            Glide.with(this).load(url)
                    .into(ivOther);
            ivOther.setColorFilter(ContextCompat.getColor(mContext, android.R.color.transparent));
            isOther = false;
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

