package com.cashmysalary.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cashmysalary.R;
import com.cashmysalary.RunTimePermissionActivity;
import com.cashmysalary.api.APIClient;
import com.cashmysalary.api.APIInterface;
import com.cashmysalary.fragment.BottomSheetFragment;
import com.cashmysalary.util.CommonMethod;
import com.cashmysalary.util.PrefManager;
import com.cashmysalary.util.SharedPrefUtil;
import com.cashmysalary.utility.NetUtil;
import com.cashmysalary.utility.ProgressUtils;
import com.cashmysalary.utility.ToastUtil;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class LoginAct extends RunTimePermissionActivity implements View.OnClickListener, BottomSheetFragment.OnFragmentInteractionListener, BottomSheetFragment.OnSkipClicked, View.OnFocusChangeListener {
    private String TAG = LoginAct.class.getSimpleName();
    private Context mContext;
    private AppCompatEditText etMobileNumber;
    private AppCompatButton btnLogin, btnCheck;
    private ImageView btnSignInGoogle, btnSignInfb;

    public static Activity a;
    private static final int RC_SIGN_IN = 234;
    //creating a GoogleSignInClient object
    GoogleSignInClient mGoogleSignInClient;
    //And also a Firebase Auth object
    FirebaseAuth mAuth;
    private PrefManager prefManager;

    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;

    private LoginButton fbLoginBtn;
    private boolean isClicked = false;
    private CheckBox cbAccept;


    private String sAppVersion, sDeviceType, sDeviceModel, sDeviceVersion, sDeviceIMEI;
    APIInterface apiInterface;
    private static final int REQUEST_PERMISSIONS = 20;
    private static final String[] ALL_PERMISSIONS = {
            Manifest.permission.READ_SMS,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.READ_PHONE_STATE

    };
    private String mobileNumber;
    private TextView tvSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        setContentView(R.layout.activity_login);
        a = LoginAct.this;
        mContext = LoginAct.this;
        prefManager = new PrefManager(mContext);
//        apiInterface = APIClient.getClient().create(APIInterface.class);
        callbackManager = CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {

            }
        };
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
//                displayMessage(newProfile);
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();


        FirebaseApp.initializeApp(mContext);
        mAuth = FirebaseAuth.getInstance();
        initViews();
        applyInit();
        initializeGoogleSignIn();
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        if (requestCode == REQUEST_PERMISSIONS) {
            getDeviceInformation();
            hideKeyboard();
        }
    }

    private void applyInit() {
        btnSignInGoogle.setOnClickListener(this);
        btnSignInfb.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);

        etMobileNumber.setOnFocusChangeListener(this);

    }


    private void initializeGoogleSignIn() {
        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


    }


    private void signIn() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //starting the activity for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        //getting the auth credential
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        //Now using firebase we are signing in the user here
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            assert user != null;
                            SharedPrefUtil.putString("Name", user.getDisplayName(), mContext);
                            SharedPrefUtil.putString("Email", user.getEmail(), mContext);
                            SharedPrefUtil.putString("Phone", user.getPhoneNumber(), mContext);
                            SharedPrefUtil.putString("PhotoUrl", String.valueOf(user.getPhotoUrl()), mContext);
                            SharedPrefUtil.putBoolean("isGoogleLogin", true, mContext);

                            Log.e(TAG, "Display Name**" + user.getDisplayName());
                            Log.e(TAG, "Display Email**" + user.getEmail());
                            Log.e(TAG, "Display Phone**" + user.getPhoneNumber());
                            Log.e(TAG, "Display PhotoUrl**" + user.getPhotoUrl());


                            Intent i = new Intent(mContext, MobileNumberActivity.class);
                            i.putExtra("Phone", user.getPhoneNumber());
                            startActivity(i);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(mContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        //if the requestCode is the Google Sign In code that we defined at starting
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                //authenticating with firebase
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // Calling method to access User Data After successfully login.
            GraphLoginRequest(loginResult.getAccessToken());
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    private void GraphLoginRequest(AccessToken accessToken) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {

                        try {

                            // Adding all user info one by one into TextView.
                            Log.e(TAG, "ID: " + jsonObject.getString("id"));
                            Log.e(TAG, "Name: " + jsonObject.getString("name"));
                            Log.e(TAG, "First name: " + jsonObject.getString("first_name"));
                            Log.e(TAG, "Last name: " + jsonObject.getString("last_name"));
                            Log.e(TAG, "Email: " + jsonObject.getString("email"));

                            SharedPrefUtil.putString("Name", jsonObject.getString("name"), mContext);
                            SharedPrefUtil.putString("Email", jsonObject.getString("email"), mContext);
                            SharedPrefUtil.putString("Phone", " ", mContext);


                            Intent i = new Intent(mContext, MobileNumberActivity.class);
                            startActivity(i);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle bundle = new Bundle();
        bundle.putString(
                "fields",
                "id,name,link,email,gender,last_name,first_name,locale,timezone,updated_time,verified"
        );
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();

    }


    @Override
    public void onStop() {
        super.onStop();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }


    private void initViews() {
        etMobileNumber = findViewById(R.id.etMobileNumber);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
        btnSignInGoogle = findViewById(R.id.btnSignInGoogle);
        btnSignInfb = findViewById(R.id.btnSignInfb);
        cbAccept = findViewById(R.id.cbAccept);
        fbLoginBtn = findViewById(R.id.login_button);
        btnCheck = findViewById(R.id.btnCheck);

        fbLoginBtn.setHeight(100);
        fbLoginBtn.setReadPermissions("email");
        fbLoginBtn.registerCallback(callbackManager, callback);

//        cbAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    btnLogin.setEnabled(true);
//                    btnLogin.setSupportBackgroundTintList(ContextCompat.getColorStateList(LoginAct.this, R.color.colorPrimary));
//                } else {
//                    btnLogin.setEnabled(false);
//                    btnLogin.setSupportBackgroundTintList(ContextCompat.getColorStateList(LoginAct.this, R.color.shadows));
//
//                }
//            }
//        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSignUp:
                startActivity(new Intent(mContext,SignUpActivity.class));
                break;
            case R.id.btnSignInGoogle:
                signIn();
                break;
            case R.id.btnSignInfb:
                fbLoginBtn.performClick();
                break;
            case R.id.btnCheck:
                if (isClicked) {
                    btnCheck.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_inactive));

                    isClicked = false;
                } else {
                    btnCheck.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_active));
                    showBottomSheetDialogFragment();
                    isClicked = true;
                }
                break;
            case R.id.btnLogin:
//                try {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        LoginAct.super.requestAppPermissions(ALL_PERMISSIONS, R.string.runtime_permissions_txt, REQUEST_PERMISSIONS);
//                    } else {
//                        if (NetUtil.isNetworkAvailable(mContext)) {
//                            getDeviceInformation();
//                            hideKeyboard();
//                        } else {
//                            ToastUtil.showToast(mContext, "" + mContext.getResources().getString(R.string.internet_connection_error_string));
//                        }
//
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                prefManager.setFirstTimeLaunch(false);
                Intent i = new Intent(mContext, MainActivity.class);
                startActivity(i);
                LoginAct.a.finish();
                LanguageActivity.a.finish();
                finish();
                break;
        }
    }

    public void showBottomSheetDialogFragment() {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            assert getSystemService(Context.INPUT_METHOD_SERVICE) != null;
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String etMobile = etMobileNumber.getText().toString();
        switch (v.getId()) {
            case R.id.etMobileNumber:
                if (hasFocus) {
                    {
                        if (TextUtils.isEmpty(etMobile)) {
//                            etMobileNumber.setError("Please enter a valid mobile number");
                        }
                    }
                }
            default:
                break;

        }
    }

    private void getDeviceInformation() {
        ProgressUtils.showSimpleProgressDialog(LoginAct.this, "", "Loading...", false);

        //App version
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            sAppVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //Device type
        sDeviceType = "android";
        sDeviceModel = Build.MODEL;
        sDeviceVersion = Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();

        //IMEI number;
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI;
        try {
            assert telephonyManager != null;
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            IMEI = telephonyManager.getDeviceId();
        } catch (Exception e) {
            IMEI = "Error!!";
        }
        sDeviceIMEI = IMEI;
        SharedPrefUtil.putString(IMEI, IMEI, mContext);
        if (applyLocalValidation()) {
            try {
//                SharedPrefUtil.getGcmRegistrationID(KeyConstants.FCMTOKEN.trim(), FirebaseInstanceId.getInstance().getToken(), LoginActivity.this);
            } catch (Exception e) {
                e.printStackTrace();
            }


//            validateWithServer();

        }
    }
    public boolean checkValidation() {
        mobileNumber = etMobileNumber.getText().toString();
        Log.e(TAG, "mobileNumber -> " + mobileNumber);

        if (mobileNumber.length()==10) {
            CommonMethod.showAlert("Mobile number Cannot be left blank", mContext);
            return false;
        }
        return true;
    }
    private void validateWithServer() {
        if (checkValidation()) {
            if (CommonMethod.isNetworkAvailable(mContext))
//                loginRetrofit2Api(userId, password);
//            else
                CommonMethod.showAlert("Internet Connectivity Failure", mContext);
        }

        Intent i = new Intent(mContext, OtpVerificationActivity.class);
        i.putExtra("Phone", Objects.requireNonNull(etMobileNumber.getText()).toString());
        startActivity(i);
        LoginAct.a.finish();
        LanguageActivity.a.finish();
        finish();
    }

    public boolean applyLocalValidation() {
        String etMobile = etMobileNumber.getText().toString();
        if (TextUtils.isEmpty(etMobile)) {
            etMobileNumber.setError("Please enter 10 digits mobile number");
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void onFragmentInteraction(String value) {
        Toast.makeText(mContext, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSkipClicked(boolean isSkiped) {
        if (isSkiped) {
            btnCheck.setBackgroundDrawable(getResources().getDrawable(R.drawable.circle_inactive));
            isClicked = false;
        }
    }


}
