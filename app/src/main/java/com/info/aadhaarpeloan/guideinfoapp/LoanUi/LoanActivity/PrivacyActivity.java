package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.LoanAdsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class PrivacyActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvNotFOund;
    private WebView WebViewPolicy;
    private ProgressBar ProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvNotFOund = (TextView) findViewById(R.id.TvNotFOund);
        WebViewPolicy = (WebView) findViewById(R.id.WebViewPolicy);
        ProgressDialog = (ProgressBar) findViewById(R.id.ProgressDialog);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        ProgressDialog.setVisibility(View.VISIBLE);
        WebViewPolicy.setVisibility(View.GONE);
        TvNotFOund.setVisibility(View.GONE);
        TvTitle.setText(LoanConst.getLoanAadhaar().get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)));
        if (LoanAdsClass.isInternetOn(this)) {
            LoanConst.LoadAdsData(PrivacyActivity.this, new LoanConst.LoadAdsId() {
                @Override
                public void getAdsIds(LoanAdsModel loanAdsModel) {
                    System.out.println("------ -- - loanAdsModel : " + loanAdsModel);
                    if (!loanAdsModel.getAppPrivacyPolicyLink().equalsIgnoreCase("")) {
                        WebViewPolicy.setInitialScale(100);
                        WebSettings webPrivacySettings = WebViewPolicy.getSettings();
                        webPrivacySettings.setJavaScriptEnabled(true);
                        webPrivacySettings.setTextZoom(webPrivacySettings.getTextZoom() + 70);
                        WebViewPolicy.loadUrl("https://sites.google.com/view/sleeping-sound/home");
                        WebViewPolicy.setWebViewClient(new AppWebViewClients(ProgressDialog));
                    } else {
                        ProgressDialog.setVisibility(View.GONE);
                        TvNotFOund.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
        }
    }

    private class AppWebViewClients extends WebViewClient {

        private final View progressBar;

        public AppWebViewClients(View progressBar) {
            this.progressBar = progressBar;
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            WebViewPolicy.setVisibility(View.VISIBLE);
        }
    }
}