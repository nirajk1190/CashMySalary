package com.cashmysalary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.cashmysalary.R;

public class LoanAgreementActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Toolbar toolbar;
    private AppCompatButton btnNext;
    private TextView tvAgreement;
    private WebView web;
    private ProgressBar progressBar1;
    public static Activity a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        mContext = this;
        a = LoanAgreementActivity.this;

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
        toolbar.setTitle(getResources().getString(R.string.loan_agreement_toolbar_title));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        web.setWebViewClient(new WebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://cashmysalary.com/privacy-policy");
        // this will enable the javascipt.


    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnConfirm);
        tvAgreement = findViewById(R.id.tvAgreement);
        web = findViewById(R.id.web);
        progressBar1 = findViewById(R.id.progressBar1);

        btnNext.setOnClickListener(this);
    }
    public class WebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            progressBar1.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar1.setVisibility(View.GONE);
        }
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConfirm) {
            RepaymentDetailsActivity.a.finish();
            startActivity(new Intent(mContext,ThanksActivity.class));
            finish();
        }
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

