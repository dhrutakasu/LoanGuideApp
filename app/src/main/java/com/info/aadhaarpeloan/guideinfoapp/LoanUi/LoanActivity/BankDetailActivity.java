package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

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
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.AadhaarAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BankDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvBankDetail;
    private Button BtnGoToSite;
    private String BankUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);

        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvBankDetail = (TextView) findViewById(R.id.TvBankDetail);
        BtnGoToSite = (Button) findViewById(R.id.BtnGoToSite);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnGoToSite.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeBannerAds(context,((ProgressBar) findViewById(R.id.progressBarNative)),(RelativeLayout) findViewById(R.id.RlNativeAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getIntent().getStringExtra(LoanConst.AadhaarDetail));
        for (int i = 0; i < LoanConst.GotoBankLoanList(context).size(); i++) {
            if (LoanConst.GotoBankLoanList(context).get(i).getTitle().equalsIgnoreCase(getIntent().getStringExtra(LoanConst.AadhaarDetail))) {
                TvBankDetail.setText(LoanConst.GotoBankLoanList(context).get(i).getDescription());
                BankUrl = LoanConst.GotoBankLoanList(context).get(i).getUrl();
                break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnGoToSite:
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BankUrl));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.android.chrome");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}