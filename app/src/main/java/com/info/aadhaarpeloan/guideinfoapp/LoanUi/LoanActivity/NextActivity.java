package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.facebook.ads.AdSize;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        BtnNext = (Button) findViewById(R.id.BtnNext);
    }

    private void GuideListerns() {
        BtnNext.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeBannerAds(context, ((ProgressBar) findViewById(R.id.progressBar)), (RelativeLayout) findViewById(R.id.RlBannerAd));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnNext:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, GoActivity.class));
                    }
                });
                break;
        }
    }
}