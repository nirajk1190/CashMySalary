package com.cashmysalary.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.cashmysalary.R;
import com.cashmysalary.fragment.HomeFragment;
import com.cashmysalary.fragment.AccountFragment;
import com.cashmysalary.fragment.PaymentFragment;
import com.cashmysalary.fragment.ReferEarnFragment;
import com.cashmysalary.model.ActivityResultBus;
import com.cashmysalary.model.ActivityResultEvent;
import com.cashmysalary.util.PrefManager;
import com.cashmysalary.util.SharedPrefUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textCartItemCount;
    int mCartItemCount = 10;
    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PAYMENT = "payment";
    private static final String TAG_DOCUMENT = "MyDocument";
    private static final String TAG_LOAN_RECORD = "LoanRecord";
    private static final String TAG_APPLICATION_STATUS = "appStatus";
    private static final String TAG_LANGUAGE = "language";
    private static final String TAG_NOTIFICATION = "Notifications";
    private static final String TAG_INVITE = "invite";
    private static final String TAG_TERMS = "terms";
    private static final String TAG_ABOUT_US = "aboutUs";
    private static final String TAG_FAQ = "faq";
    private static final String TAG_CONTACT_US = "contactUs";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_LOG_OUT = "logOut";

    public static String CURRENT_TAG = TAG_HOME;
    private FrameLayout fragment_frame;
    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    private String userName, userEmail, userPhone, userImage;
    private Context mContext;
    private ImageView icon_profile;
    private TextView textMobile;
    private PrefManager prefManager;
    private BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        prefManager = new PrefManager(mContext);
        userName = SharedPrefUtil.getString("Name", "", mContext);
        userPhone = SharedPrefUtil.getString("Phone", "", mContext);
        userEmail = SharedPrefUtil.getString("Email", "", mContext);

        initView(savedInstanceState);

    }

    private void initView(Bundle savedInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        mHandler = new Handler();

        fragment_frame = findViewById(R.id.fragment_frame);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // Navigation view header

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_frame, fragment, CURRENT_TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.action_home:
                    getSupportActionBar().setTitle("Home");
                    CURRENT_TAG = TAG_HOME;
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_payment:
                    getSupportActionBar().setTitle("Loan Repayment");
                    CURRENT_TAG = TAG_PAYMENT;
                    fragment = new PaymentFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_invite:
                    getSupportActionBar().setTitle("Refer & Earn");
                    CURRENT_TAG = TAG_INVITE;
                    fragment = new ReferEarnFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_profile:
                    getSupportActionBar().setTitle("My Account");
                    CURRENT_TAG = TAG_PROFILE;
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // set toolbar title
        setToolbarTitle();


        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.fragment_frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }



    @Override
    public void onBackPressed() {
        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();

                return;
            }
        }


        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_notification) {
            startActivity(new Intent(mContext,NotificationActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_notification);
        View actionView = menuItem.getActionView();
        textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        setupBadge();
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }
    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityResultBus.getInstance().postQueue(
                new ActivityResultEvent(requestCode, resultCode, data));
    }
}
