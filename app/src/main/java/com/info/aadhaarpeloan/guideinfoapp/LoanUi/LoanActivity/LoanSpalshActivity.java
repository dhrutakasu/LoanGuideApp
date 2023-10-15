package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoanSpalshActivity extends AppCompatActivity {

    private View progressSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_loan);
        progressSplash = findViewById(R.id.progressSplash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        InitActions();
    }

    private void InitActions() {
//        if (LoanConst.checkDeveloperOptions(LoanSpalshActivity.this)) {
//            ((View)findViewById(R.id.ViewSetting)).setVisibility(View.VISIBLE);
//            ((Button)findViewById(R.id.BtnTurnOff)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
//                    finish();
//                }
//            });
//        } else {
            ((View)findViewById(R.id.ViewSetting)).setVisibility(View.GONE);
            if (LoanAdsClass.isInternetOn(this)) {
                progressSplash.setVisibility(View.VISIBLE);

                LoanConst.LoadAdsData(LoanSpalshActivity.this, new LoanConst.LoadAdsId() {
                    @Override
                    public void getAdsIds(LoanAdsModel loanAdsModel) {
                        if (!loanAdsModel.getOad().equalsIgnoreCase("")) {
                            fetchAd(loanAdsModel);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressSplash.setVisibility(View.GONE);
                                    LoanAdsClass.ShowActivityInterstitialAd(LoanSpalshActivity.this, new LoanAdsClass.LoanCallback() {
                                        @Override
                                        public void AppCallback() {
                                            GotoStartActivity();
                                        }
                                    });
                                }
                            }, 2000L);
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please Turn Your Internet..", Toast.LENGTH_SHORT).show();
                finish();
            }
//        }
    }

    public void fetchAd(LoanAdsModel loanAdsModel) {
        AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            private AppOpenAd appOpenAd;

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                appOpenAd = null;
                GotoStartActivity();
            }

            @Override
            public void onAdLoaded(AppOpenAd appOpenAds) {
                appOpenAd = appOpenAds;
                if (appOpenAd != null) {
                    appOpenAd.show(LoanSpalshActivity.this);
                    appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            progressSplash.setVisibility(View.GONE);
                            appOpenAd = null;
                            GotoStartActivity();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            appOpenAd = null;
                            GotoStartActivity();
                            progressSplash.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAdImpression() {
                            super.onAdImpression();
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent();
                        }
                    });
                }
            }
        };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(this, loanAdsModel.getOad(), request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    private void GotoStartActivity() {
        startActivity(new Intent(LoanSpalshActivity.this, StartActivity.class));
        finish();
    }

}