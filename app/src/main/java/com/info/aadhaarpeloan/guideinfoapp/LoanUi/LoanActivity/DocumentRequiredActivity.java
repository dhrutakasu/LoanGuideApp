
package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.DocumentRequiredAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class DocumentRequiredActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle;
    private RecyclerView RvDocumentRequired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_required);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        RvDocumentRequired = (RecyclerView) findViewById(R.id.RvDocumentRequired);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeAds(context, ((ProgressBar) findViewById(R.id.progressBarNative)), (RelativeLayout) findViewById(R.id.RlNativeAd));

        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.DocumentRequired));
        RvDocumentRequired.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        RvDocumentRequired.setAdapter(new DocumentRequiredAdapter(context, LoanConst.getRequiredDocument(context), i -> {
            switch (i) {
                case 0:
                    LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                        @Override
                        public void AppCallback() {
                            loadNewActivity(RequiredHomeLoanActivity.class);
                        }
                    });
                    break;
                case 1:
                    LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                        @Override
                        public void AppCallback() {
                            loadNewActivity(RequiredBussinessLoanActivity.class);
                        }
                    });
                    break;
                case 2:
                    LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                        @Override
                        public void AppCallback() {
                            loadNewActivity(RequiredMortigageLoanActivity.class);
                        }
                    });
                    break;
                case 3:
                    LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                        @Override
                        public void AppCallback() {
                            loadNewActivity(RequiredTransferHomeLoanActivity.class);
                        }
                    });
                    break;
                case 4:
                    LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                        @Override
                        public void AppCallback() {
                            loadNewActivity(RequiredTransferMortigageLoanActivity.class);
                        }
                    });
                    break;
            }
        }));
    }

    public void loadNewActivity(Class aClass) {
        startActivity(new Intent(context, aClass));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
        }
    }
}