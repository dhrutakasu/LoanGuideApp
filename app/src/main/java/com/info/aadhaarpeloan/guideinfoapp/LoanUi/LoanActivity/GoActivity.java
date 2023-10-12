package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class GoActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        BtnGo = (Button) findViewById(R.id.BtnGo);
    }

    private void GuideListerns() {
        BtnGo.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnGo:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, MainActivity.class));
                    }
                });
                break;
        }
    }
}