package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private CardView BtnHomeLoan, BtnEducationLoan, BtnGoldLoan, BtnBusinessLoan, BtnVehicleLoan;
    private ImageView IvBack;
    private TextView TvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_type);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        BtnHomeLoan = (CardView) findViewById(R.id.BtnHomeLoan);
        BtnEducationLoan = (CardView) findViewById(R.id.BtnEducationLoan);
        BtnGoldLoan = (CardView) findViewById(R.id.BtnGoldLoan);
        BtnBusinessLoan = (CardView) findViewById(R.id.BtnBusinessLoan);
        BtnVehicleLoan = (CardView) findViewById(R.id.BtnVehicleLoan);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnHomeLoan.setOnClickListener(this);
        BtnEducationLoan.setOnClickListener(this);
        BtnGoldLoan.setOnClickListener(this);
        BtnBusinessLoan.setOnClickListener(this);
        BtnVehicleLoan.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeBannerAds(context,((ProgressBar) findViewById(R.id.progressBarNative)),(RelativeLayout) findViewById(R.id.RlNativeAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanType));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnHomeLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        loadNewActivity(0);
                    }
                });
                break;
            case R.id.BtnGoldLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        loadNewActivity(2);
                    }
                });
                break;
            case R.id.BtnEducationLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        loadNewActivity(3);
                    }
                });
                break;
            case R.id.BtnBusinessLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        loadNewActivity(1);
                    }
                });
                break;
            case R.id.BtnVehicleLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        loadNewActivity(4);
                    }
                });
                break;
        }
    }
    public void loadNewActivity(int pos){
        startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, pos));
    }
}