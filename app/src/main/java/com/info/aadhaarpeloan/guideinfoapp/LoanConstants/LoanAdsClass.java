package com.info.aadhaarpeloan.guideinfoapp.LoanConstants;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;

public class LoanAdsClass {

    public static InterstitialAd interstitialAd;
    public static LoanCallback loanCallback;
    public static NativeAd nativeAd;
    //banner
        /* if (AdsClass.isInternetOn(context)) {
                AdsClass.showBanner(this, AdSize.LARGE_BANNER, (RelativeLayout) findViewById(R.id.RlBannerAdView), (RelativeLayout) findViewById(R.id.RlBannerAd),Constants.BannerAd,"true");
        }*/

    //native
         /*  if (AdsClass.isInternetOn(context)) {
                AdsClass.showNative250(this, findViewById(R.id.FlNativeAds),"true");
         }*/

    //interstitial
     /*AdsClass.showInter(MainActivity.this, new AdsClass.MyAppCallback() {
            @Override
            public void AppCallback() {

            }
        },"true");*/

    public static void showFbBanner(Context activity, com.facebook.ads.AdSize adSize, RelativeLayout RlBannerParent, String id, String show) {
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(activity, id, adSize);
        RlBannerParent.addView(adView);
        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
        if (show.equalsIgnoreCase("t")) {
            RlBannerParent.setVisibility(View.VISIBLE);
        } else {
            RlBannerParent.setVisibility(View.INVISIBLE);
        }
    }

    public static void showAdMobBanner(Context context, AdSize adSize, RelativeLayout RlBannerParent, String id, String show) {
        AdView adView = new AdView(context);
        adView.setAdSize(adSize);
        adView.setAdUnitId(id);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
            }

            @Override
            public void onAdClosed() {
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
            }

            @Override
            public void onAdImpression() {
            }

            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdOpened() {
            }
        });
        adView.loadAd(new AdRequest.Builder().build());
        RlBannerParent.addView(adView);
        if (show.equalsIgnoreCase("t")) {
            RlBannerParent.setVisibility(View.VISIBLE);
        } else {
            RlBannerParent.setVisibility(View.INVISIBLE);
        }
    }

    public static void ShowActivityBannerAds(Context context, ProgressBar progressBar, RelativeLayout RlBannerAd) {
        if (LoanAdsClass.isInternetOn(context)) {
            progressBar.setVisibility(View.VISIBLE);
            LoanConst.LoadAdsData(context, new LoanConst.LoadAdsId() {
                @Override
                public void getAdsIds(LoanAdsModel loanAdsModel) {
                    progressBar.setVisibility(View.GONE);
                    if (loanAdsModel.getBtype().equalsIgnoreCase("1")) {
                        LoanAdsClass.showAdMobBanner(context, com.google.android.gms.ads.AdSize.BANNER, RlBannerAd, loanAdsModel.getBad(), loanAdsModel.getLogin());
                    } else {
                        LoanAdsClass.showFbBanner(context, com.facebook.ads.AdSize.BANNER_HEIGHT_50, RlBannerAd, loanAdsModel.getFbad(), loanAdsModel.getLogin());
                    }
                }
            });
        } else {
            RlBannerAd.setVisibility(View.GONE);
        }
    }

    private AdSize getAdSize(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    public interface LoanCallback {
        void AppCallback();

    }

    public void loadInterOne(Activity activity, String id, String show) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {

            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        interstitialAd.load(activity, id, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                LoanAdsClass.interstitialAd = interstitialAd;
                LoanAdsClass.interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        LoanAdsClass.interstitialAd = null;
                        loadInterOne(activity, id, show);
                        if (loanCallback != null) {
                            loanCallback.AppCallback();
                            loanCallback = null;
                        }
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {

                        LoanAdsClass.interstitialAd = null;
                        loadInterOne(activity, id, show);
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                interstitialAd = null;
            }
        });
    }

    public static void loadInterOne(final Activity activity, String id) {
        MobileAds.initialize(activity, new OnInitializationCompleteListener() {

            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        InterstitialAd.load(activity, id, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            public void onAdLoaded(InterstitialAd interstitialAd) {
                LoanAdsClass.interstitialAd = interstitialAd;
                LoanAdsClass.interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        LoanAdsClass.interstitialAd = null;
                        loadInterOne(activity, id);
                        if (loanCallback != null) {
                            loanCallback.AppCallback();
                            loanCallback = null;
                        }
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {

                        LoanAdsClass.interstitialAd = null;
                        loadInterOne(activity, id);
                    }
                });
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                interstitialAd = null;
            }
        });
    }

    public static void showInter(Activity activity, LoanCallback loanCallback2, String show) {
        loanCallback = loanCallback2;

        if (show.equalsIgnoreCase("t")) {
            InterstitialAd interstitialAd = LoanAdsClass.interstitialAd;
            if (interstitialAd != null) {
                interstitialAd.show(activity);
                return;
            }

            if (loanCallback != null) {
                loanCallback.AppCallback();
                loanCallback = null;
            }
        } else {
            if (loanCallback != null) {
                loanCallback.AppCallback();
                loanCallback = null;
            }
        }
    }

    public static boolean isInternetOn(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING || connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING || connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        if (connectivityManager.getNetworkInfo(0).getState() != NetworkInfo.State.DISCONNECTED) {
            connectivityManager.getNetworkInfo(1).getState();
            NetworkInfo.State state = NetworkInfo.State.DISCONNECTED;
        }
        return false;
    }

    public static void alert(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Internet Alert");
        builder.setMessage("You need to internet connection");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public static void showAdMobNative(Activity activity, String id, RelativeLayout RlNativeAd, String show, String appAdsButtonTextColor, String appAdsButtonColor) {
        AdLoader adLoader = new AdLoader.Builder(activity, id)
                .forNativeAd(nativeAd -> {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (nativeAd != null) {
                                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.layout_ads_item_big_native_layout, (ViewGroup) null);
                                populateUnifiedNativeAdView(nativeAd, nativeAdView, appAdsButtonColor, appAdsButtonTextColor);
                                RlNativeAd.removeAllViews();

                                if (show.equalsIgnoreCase("t")) {
                                    RlNativeAd.setVisibility(View.VISIBLE);
                                    RlNativeAd.addView(nativeAdView);
                                } else {
                                    RlNativeAd.setVisibility(View.INVISIBLE);
                                }
                            }
                        }
                    }, 1000);
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder().build())
                .build();
        adLoader.loadAd(new AdManagerAdRequest.Builder().build());
    }

    public static void showFbNativeBanner(Activity activity, NativeAdLayout adLayout, String id, RelativeLayout RlNativeAd, String show, String appAdsButtonTextColor, String appAdsButtonColor) {
        NativeBannerAd nativeBannerAd = new NativeBannerAd(activity, id);
        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (nativeBannerAd == null || nativeBannerAd != ad) {
                    return;
                }
                inflateNativeBannerAd(activity, adLayout, nativeBannerAd, appAdsButtonTextColor, appAdsButtonColor);
                RlNativeAd.removeAllViews();
                if (show.equalsIgnoreCase("t")) {
                    RlNativeAd.setVisibility(View.VISIBLE);
                    RlNativeAd.addView(adLayout);
                } else {
                    RlNativeAd.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeBannerAd.loadAd(nativeBannerAd.buildLoadAdConfig()
                .withAdListener(nativeAdListener)
                .build());
    }

    private static void inflateNativeBannerAd(Activity activity, NativeAdLayout nativeAdLayout, NativeBannerAd nativeBannerAd, String appAdsButtonTextColor, String appAdsButtonColor) {
        nativeBannerAd.unregisterView();
        LayoutInflater inflater = LayoutInflater.from(activity);
        LinearLayout inflate = (LinearLayout) inflater.inflate(R.layout.layout_fb_native_banner_ad, nativeAdLayout, false);
        nativeAdLayout.addView(inflate);

        RelativeLayout adChoicesContainer = inflate.findViewById(R.id.RlAdChoicesContainer);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        TextView nativeAdTitle = inflate.findViewById(R.id.TxtNativeAdTitle);
        TextView nativeAdSocialContext = inflate.findViewById(R.id.TxtNativeAdSocialContext);
        TextView sponsoredLabel = inflate.findViewById(R.id.TxtNativeAdSponsoredLabel);
        com.facebook.ads.MediaView nativeAdIconView = inflate.findViewById(R.id.MediaNativeIconView);
        Button nativeAdCallToAction = inflate.findViewById(R.id.BtnNativeAdCallAction);

        nativeAdTitle.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdSocialContext.setTextColor(Color.parseColor(appAdsButtonTextColor));
        sponsoredLabel.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdCallToAction.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdCallToAction.setBackgroundColor(Color.parseColor(appAdsButtonColor));

        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(inflate, nativeAdIconView, clickableViews);
    }

    public static void ShowActivityNativeBannerAds(Context context, ProgressBar progressBar, RelativeLayout RlNativeAd) {
        if (LoanAdsClass.isInternetOn(context)) {
            progressBar.setVisibility(View.VISIBLE);
            LoanConst.LoadAdsData(context, new LoanConst.LoadAdsId() {
                @Override
                public void getAdsIds(LoanAdsModel loanAdsModel) {
                    progressBar.setVisibility(View.GONE);
//                    if (loanAdsModel.getBtype().equalsIgnoreCase("1")) {
//                        LoanAdsClass.showAdMobNative((Activity) context, loanAdsModel.getNad(), RlNativeAd, loanAdsModel.getLogin(), loanAdsModel.getAppAdsButtonTextColor(), loanAdsModel.getAppAdsButtonColor());
//                    } else {
                    LoanAdsClass.showFbNativeBanner((Activity) context, ((NativeAdLayout) ((Activity) context).findViewById(R.id.NativeBannerAdContainer)), loanAdsModel.getFnbad(), RlNativeAd, loanAdsModel.getLogin(), loanAdsModel.getAppAdsButtonTextColor(), loanAdsModel.getAppAdsButtonColor());
//                    }
                }
            });
        } else {
            RlNativeAd.setVisibility(View.GONE);
        }
    }

    public static void showFbNative(Activity activity, NativeAdLayout adLayout, String id, RelativeLayout RlNativeAd, String show, String appAdsButtonTextColor, String appAdsButtonColor) {
        com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, id);
        NativeAdListener nativeAdListener = new NativeAdListener() {

            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, com.facebook.ads.AdError adError) {
            }

            @Override
            public void onAdLoaded(Ad ad) {
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateNativeAd(activity, adLayout, nativeAd, appAdsButtonTextColor, appAdsButtonColor);
                RlNativeAd.removeAllViews();
                if (show.equalsIgnoreCase("t")) {
                    RlNativeAd.setVisibility(View.VISIBLE);
                    RlNativeAd.addView(adLayout);
                } else {
                    RlNativeAd.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig()
                .withAdListener(nativeAdListener)
                .build());
    }

    private static void inflateNativeAd(Activity activity, NativeAdLayout nativeAdLayout, com.facebook.ads.NativeAd nativeAd, String appAdsButtonTextColor, String appAdsButtonColor) {
        nativeAd.unregisterView();
        LayoutInflater inflater = LayoutInflater.from(activity);
        LinearLayout inflate = (LinearLayout) inflater.inflate(R.layout.layout_fb_native_ad, nativeAdLayout, false);
        nativeAdLayout.addView(inflate);

        LinearLayout adChoicesContainer = inflate.findViewById(R.id.RlAdChoicesContainer);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        TextView nativeAdTitle = inflate.findViewById(R.id.TxtNativeAdTitle);
        TextView nativeAdSocialContext = inflate.findViewById(R.id.TxtNativeAdSocialContext);
        TextView sponsoredLabel = inflate.findViewById(R.id.TxtNativeAdSponsoredLabel);
        TextView nativeAdBody = inflate.findViewById(R.id.TxtNativeAdBody);
        com.facebook.ads.MediaView nativeAdIconView = inflate.findViewById(R.id.MediaNativeIconView);
        com.facebook.ads.MediaView MediaNativeAd = inflate.findViewById(R.id.MediaNativeAd);
        Button nativeAdCallToAction = inflate.findViewById(R.id.BtnNativeAdCallAction);

        nativeAdTitle.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdSocialContext.setTextColor(Color.parseColor(appAdsButtonTextColor));
        sponsoredLabel.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdCallToAction.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdBody.setTextColor(Color.parseColor(appAdsButtonTextColor));
        nativeAdCallToAction.setBackgroundColor(Color.parseColor(appAdsButtonColor));

        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeAd.registerViewForInteraction(inflate, MediaNativeAd, nativeAdIconView, clickableViews);
    }

    public static void ShowActivityNativeAds(Context context, ProgressBar progressBar, RelativeLayout RlNativeAd) {
        if (LoanAdsClass.isInternetOn(context)) {
            progressBar.setVisibility(View.VISIBLE);
            LoanConst.LoadAdsData(context, new LoanConst.LoadAdsId() {
                @Override
                public void getAdsIds(LoanAdsModel loanAdsModel) {
                    progressBar.setVisibility(View.GONE);
//                    if (loanAdsModel.getBtype().equalsIgnoreCase("1")) {
//                        LoanAdsClass.showAdMobNative((Activity) context, loanAdsModel.getNad(), RlNativeAd, loanAdsModel.getLogin(), loanAdsModel.getAppAdsButtonTextColor(), loanAdsModel.getAppAdsButtonColor());
//                    } else {
                    LoanAdsClass.showFbNative((Activity) context, ((NativeAdLayout) ((Activity) context).findViewById(R.id.NativeBannerAdContainer)), loanAdsModel.getFnbad(), RlNativeAd, loanAdsModel.getLogin(), loanAdsModel.getAppAdsButtonTextColor(), loanAdsModel.getAppAdsButtonColor());
//                    }
                }
            });
        } else {
            RlNativeAd.setVisibility(View.GONE);
        }
    }

    @SuppressLint("WrongConstant")
    private static void populateUnifiedNativeAdView(NativeAd nativeAd, NativeAdView adView, String appAdsButtonColor, String appAdsButtonTextColor) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.MvAdMedia));
        adView.setHeadlineView(adView.findViewById(R.id.TvAdHeadline));
        adView.setBodyView(adView.findViewById(R.id.TvAdBody));
        Button button = adView.findViewById(R.id.BtnAdCallToAction);
        adView.setCallToActionView(button);
        adView.setIconView(adView.findViewById(R.id.IvAdIcon));
        adView.setPriceView(adView.findViewById(R.id.TvAdPrice));
        adView.setStarRatingView(adView.findViewById(R.id.RbAdStars));
        adView.setStoreView(adView.findViewById(R.id.TvAdStore));
        adView.setAdvertiserView(adView.findViewById(R.id.TvAdAdvertiser));
        button.setBackgroundColor(Color.parseColor(appAdsButtonColor));
        button.setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAdBody)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAdHeadline)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAdPrice)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAdStore)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAdAdvertiser)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.findViewById(R.id.TvAd)).setTextColor(Color.parseColor(appAdsButtonTextColor));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(4);
        } else {
            adView.getBodyView().setVisibility(0);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(4);
        } else {
            adView.getCallToActionView().setVisibility(0);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(8);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(0);
        }
        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(4);
        } else {
            adView.getPriceView().setVisibility(0);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(4);
        } else {
            adView.getStoreView().setVisibility(0);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(0);
        }
        adView.setNativeAd(nativeAd);
    }
}
