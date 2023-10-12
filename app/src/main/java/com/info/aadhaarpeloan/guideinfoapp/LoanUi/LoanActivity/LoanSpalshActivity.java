package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.info.aadhaarpeloan.guideinfoapp.LoanApp;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoanSpalshActivity extends AppCompatActivity {

    private View progressSplash;
    LoanAdsModel loanAdsModel = new LoanAdsModel();

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
//            SettingDialog exisettingDialogDialog = new SettingDialog(LoanSpalshActivity.this, LoanSpalshActivity.this, () -> {
//                startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
//                finish();
//            });
//            exisettingDialogDialog.show();
//            WindowManager.LayoutParams lp = exisettingDialogDialog.getWindow().getAttributes();
//            Window window = exisettingDialogDialog.getWindow();
//            lp.copyFrom(window.getAttributes());
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//            lp.gravity = Gravity.BOTTOM;
//            window.setAttributes(lp);
//        } else {
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
//    }
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
                           /* if (LoanSpalshActivity.this.loanAdsModel.getItype().equalsIgnoreCase("1")) {
                                if (findViewById(R.id.NativeBannerAdContainer) != null) {
                                    findViewById(R.id.NativeBannerAdContainer).setVisibility(View.GONE);
                                }
                                LoanAdsClass.ShowInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> GotoStartActivity());
                            } else {
                                if (findViewById(R.id.NativeBannerAdContainer) != null) {
                                    findViewById(R.id.NativeBannerAdContainer).setVisibility(View.GONE);
                                }
                                System.out.println("------- getFbad : " + LoanSpalshActivity.this.loanAdsModel.getIad());
                                LoanAdsClass.Initialize(LoanSpalshActivity.this);
                                LoanAdsClass.ShowFbInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> GotoStartActivity());
                            }
                            return;*/
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            appOpenAd = null;
                            GotoStartActivity();
                            /*if (LoanSpalshActivity.this.loanAdsModel.getItype().equalsIgnoreCase("1")) {
                                if (findViewById(R.id.NativeBannerAdContainer) != null) {
                                    findViewById(R.id.NativeBannerAdContainer).setVisibility(View.GONE);
                                }
                                LoanAdsClass.ShowInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> GotoStartActivity());
                            } else {
                                if (findViewById(R.id.NativeBannerAdContainer) != null) {
                                    findViewById(R.id.NativeBannerAdContainer).setVisibility(View.VISIBLE);
                                }
                                System.out.println("------- getFbad : " + LoanSpalshActivity.this.loanAdsModel.getIad());
                                LoanAdsClass.Initialize(LoanSpalshActivity.this);
                                LoanAdsClass.ShowFbInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> GotoStartActivity());
                            }*/
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
//        if (LoanSpalshActivity.this.loanAdsModel.getItype().equalsIgnoreCase("1")) {
//            if (findViewById(R.id.NativeBannerAdContainer) != null) {
//                findViewById(R.id.NativeBannerAdContainer).setVisibility(View.GONE);
//            }
//            LoanAdsClass.ShowInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> {
                startActivity(new Intent(LoanSpalshActivity.this, StartActivity.class));
                finish();
          /*  });
        } else {
            if (findViewById(R.id.NativeBannerAdContainer) != null) {
                findViewById(R.id.NativeBannerAdContainer).setVisibility(View.GONE);
            }
            System.out.println("------- getFbad : " + LoanSpalshActivity.this.loanAdsModel.getIad());
            LoanAdsClass.Initialize(LoanSpalshActivity.this);
            LoanAdsClass.ShowFbInterstitialAd(LoanSpalshActivity.this, LoanSpalshActivity.this.loanAdsModel.getIad(), LoanSpalshActivity.this.loanAdsModel.getLogin(), () -> {

                startActivity(new Intent(LoanSpalshActivity.this, StartActivity.class));
                finish();
            });
        }*/
    }

}