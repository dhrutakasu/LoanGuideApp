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

public class FAQsOptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnFAQsOption,BtnDocumentRequired;
    private ImageView IvBack;
    private TextView TvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs_option);

        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        BtnFAQsOption = (Button) findViewById(R.id.BtnFAQsOption);
        BtnDocumentRequired = (Button) findViewById(R.id.BtnDocumentRequired);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnFAQsOption.setOnClickListener(this);
        BtnDocumentRequired.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeBannerAds(context, ((ProgressBar) findViewById(R.id.progressBar)), (RelativeLayout) findViewById(R.id.RlBannerAd));

        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanFAQs));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnFAQsOption:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, FAQsActivity.class));
                    }
                });
                break;
            case R.id.BtnDocumentRequired:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, DocumentRequiredActivity.class));
                    }
                });
                break;
        }
    }
}