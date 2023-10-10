package com.info.aadhaarpeloan.guideinfoapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;

//https://7starinnovation.com/api/loan.json

public class LoanApp extends Application implements DefaultLifecycleObserver, LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private boolean IsPausedAd = false;
    private Activity currentActivity;
    private AppOpenAd appOpenAd;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, initializationStatus -> { });
        this.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onPause(LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onPause(owner);
        IsPausedAd = true;
    }

    @Override
    public void onResume(LifecycleOwner owner) {
        if (IsPausedAd) {
            if (LoanAdsClass.isInternetOn(this)) {
                LoanConst.LoadAdsData(currentActivity, new LoanConst.LoadAdsId() {
                    @Override
                    public void getAdsIds(LoanAdsModel loanAdsModel) {
                        if (!loanAdsModel.getOad2().equalsIgnoreCase("")) {
                            fetchAd(currentActivity, loanAdsModel.getOad2());
                        }
                    }
                });
            }
        }
        DefaultLifecycleObserver.super.onResume(owner);
    }

    @Override
    public void onStart(LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    public void OnShowAd(Activity activity) {
        if (!IsPausedAd) {
            Log.d("LOG_TAG", "The app open ad is already showing.");
            return;
        }
        if (appOpenAd != null) {
            appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    IsPausedAd = false;
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    appOpenAd = null;
                    IsPausedAd = false;
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
            IsPausedAd = false;
            appOpenAd.show(activity);
        }
    }

    public void fetchAd(Activity activity, String OpenAd) {
        AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                appOpenAd = null;
            }

            @Override
            public void onAdLoaded(AppOpenAd appOpenAds) {
                appOpenAd = appOpenAds;
                if (appOpenAd != null) {
                }

                OnShowAd(activity);
            }
        };
        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(this, OpenAd, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
