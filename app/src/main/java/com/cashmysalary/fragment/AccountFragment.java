package com.cashmysalary.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.cashmysalary.R;
import com.cashmysalary.activity.ApplicationStatusActivity;
import com.cashmysalary.activity.ContactUsActivity;
import com.cashmysalary.activity.EditProfileActivity;
import com.cashmysalary.activity.ImagePickerActivity;
import com.cashmysalary.activity.LoanHistoryActivity;
import com.cashmysalary.activity.NotificationActivity;
import com.cashmysalary.activity.ProfileActivity;
import com.cashmysalary.activity.SettingActivity;
import com.cashmysalary.model.ActivityResultBus;
import com.cashmysalary.model.ActivityResultEvent;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.squareup.otto.Subscribe;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AccountFragment extends Fragment implements View.OnClickListener {
    private String TAG = AccountFragment.class.getSimpleName();
    private View main;
    private ImageView img_profile,ivEdit;
    private RelativeLayout rlProfile,rlSettings,rlNotification,rlContactUs,rlLoanRecord,rlStatus;
    public static final int REQUEST_IMAGE = 100;
    public TextView textMobile;
    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.frag_account, container, false);
        ImagePickerActivity.clearCache(Objects.requireNonNull(getActivity()));
        init();
        applyInit();

        return main;
    }

    private void applyInit() {

    }

    private void init() {
        rlProfile = main.findViewById(R.id.rlProfile);
        rlSettings = main.findViewById(R.id.rlSettings);
        rlNotification = main.findViewById(R.id.rlNotification);
        rlContactUs = main.findViewById(R.id.rlContactUs);
        rlLoanRecord = main.findViewById(R.id.rlLoanRecord);
        rlStatus = main.findViewById(R.id.rlStatus);

        img_profile = main.findViewById(R.id.img_profile);
        ivEdit = main.findViewById(R.id.ivEdit);
        textMobile = main.findViewById(R.id.textMobile);

        rlProfile.setOnClickListener(this);
        rlSettings.setOnClickListener(this);
        rlNotification.setOnClickListener(this);
        rlContactUs.setOnClickListener(this);
        img_profile.setOnClickListener(this);
        ivEdit.setOnClickListener(this);
        rlStatus.setOnClickListener(this);
        rlLoanRecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.rlProfile){
            startActivity(new Intent(getActivity(), ProfileActivity.class));
        }if (v.getId()==R.id.rlSettings){
            startActivity(new Intent(getActivity(), SettingActivity.class));
        }if (v.getId()==R.id.rlNotification){
            startActivity(new Intent(getActivity(), NotificationActivity.class));
        }if (v.getId()==R.id.rlContactUs){
            startActivity(new Intent(getActivity(), ContactUsActivity.class));
        }if (v.getId()==R.id.img_profile){
            onProfileImageClick();
        }if (v.getId()==R.id.ivEdit){
            Intent i = new Intent(getActivity(), EditProfileActivity.class);
            i.putExtra("mobile",textMobile.getText().toString());
            i.putExtra("isVerify",false);
            startActivity(i);
        }if (v.getId()==R.id.rlLoanRecord){
            startActivity(new Intent(getActivity(), LoanHistoryActivity.class));
        }if (v.getId()==R.id.rlStatus){
            startActivity(new Intent(getActivity(), ApplicationStatusActivity.class));
        }
    }
    private void showImagePickerOptions() {
        ImagePickerActivity.showImagePickerOptions(getActivity(), new ImagePickerActivity.PickerOptionListener() {
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
    private void launchCameraIntent() {
        Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
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

    private void launchGalleryIntent() {
        Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        Objects.requireNonNull(getActivity()).startActivityForResult(intent, REQUEST_IMAGE);
    }
    public void onProfileImageClick() {
        Dexter.withActivity(getActivity())
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
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getActivity()).getContentResolver(), uri);

                    // loading profile image from local cache
                    loadProfile(uri.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        ActivityResultBus.getInstance().register(mActivityResultSubscriber);
    }

    @Override
    public void onStop() {
        super.onStop();
        ActivityResultBus.getInstance().unregister(mActivityResultSubscriber);
    }

    private Object mActivityResultSubscriber = new Object() {
        @Subscribe
        public void onActivityResultReceived(ActivityResultEvent event) {
            int requestCode = event.getRequestCode();
            int resultCode = event.getResultCode();
            Intent data = event.getData();
            onActivityResult(requestCode, resultCode, data);
        }
    };

    private void loadProfile(String url) {
        Log.d(TAG, "Image cache path: " + url);

        Glide.with(this).load(url)
                .into(img_profile);
        img_profile.setColorFilter(ContextCompat.getColor(getActivity(), android.R.color.transparent));
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
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
        Uri uri = Uri.fromParts("package", Objects.requireNonNull(getActivity()).getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }
}
