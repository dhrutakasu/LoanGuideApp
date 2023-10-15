package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnStartMain;
    private ImageView IvPrivacy, IvRate, IvShare;
    private View ViewExit;
    private TextView TvDialogNotExit;
    private Button BtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvPrivacy = (ImageView) findViewById(R.id.IvPrivacy);
        IvRate = (ImageView) findViewById(R.id.IvRate);
        IvShare = (ImageView) findViewById(R.id.IvShare);
        BtnStartMain = (Button) findViewById(R.id.BtnStartMain);
        ViewExit = (View) findViewById(R.id.ViewExit);
        BtnExit = (Button) findViewById(R.id.BtnExit);
        TvDialogNotExit = (TextView) findViewById(R.id.TvDialogNotExit);
    }

    private void GuideListerns() {
        IvPrivacy.setOnClickListener(this);
        IvRate.setOnClickListener(this);
        IvShare.setOnClickListener(this);
        BtnStartMain.setOnClickListener(this);
        BtnExit.setOnClickListener(this);
        TvDialogNotExit.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeBannerAds(context, ((ProgressBar) findViewById(R.id.progressBarExit)), (RelativeLayout) findViewById(R.id.RlBannerAdExit));
        LoanAdsClass.ShowActivityBannerAds(context, ((ProgressBar) findViewById(R.id.progressBar)), (RelativeLayout) findViewById(R.id.RlBannerAd));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvPrivacy:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, PrivacyActivity.class));
                    }
                });
                break;
            case R.id.IvShare:
                GotoLoanShareApp();
                break;
            case R.id.IvRate:
                GotoLoanRateUs();
                break;
            case R.id.BtnStartMain:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, OptionActivity.class));
                    }
                });
                break;
            case R.id.BtnExit:
                finishAffinity();
                break;
            case R.id.TvDialogNotExit:
                ViewExit.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        ViewExit.setVisibility(View.VISIBLE);
    }

    private void GotoLoanShareApp() {
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, context.getResources().getString(R.string.share_message) + context.getPackageName());
            Intent createChooser = Intent.createChooser(intent, "Share via");
            createChooser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(createChooser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GotoLoanRateUs() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }
}