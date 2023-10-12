package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnApplyLoan,BtnFAQs;
    private ImageView IvBack;
    private TextView TvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        BtnApplyLoan = (Button) findViewById(R.id.BtnApplyLoan);
        BtnFAQs = (Button) findViewById(R.id.BtnFAQs);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnApplyLoan.setOnClickListener(this);
        BtnFAQs.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        LoanAdsClass.ShowActivityNativeBannerAds(context,((ProgressBar) findViewById(R.id.progressBarNative)),(RelativeLayout) findViewById(R.id.RlNativeAd));

        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.OptionTitle));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnApplyLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanOptionActivity.class));
                    }
                });
                break;
            case R.id.BtnFAQs:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, FAQsOptionActivity.class));
                    }
                });
                break;
        }
    }}