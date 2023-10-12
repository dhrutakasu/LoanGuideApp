package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.AadhaarAdapter;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.BankAdapter;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.DocumentListAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BankListDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvDocTitle, TvDocDec;
    private RecyclerView RvDocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list_details);

        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvDocDec = (TextView) findViewById(R.id.TvDocDec);
        TvDocTitle = (TextView) findViewById(R.id.TvDocTitle);
        RvDocList = (RecyclerView) findViewById(R.id.RvDocList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeAds(context, ((ProgressBar) findViewById(R.id.progressBar)), (RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getLoanBankModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getTitle());
        TvDocTitle.setVisibility(View.GONE);
        TvDocDec.setText(LoanConst.getLoanBankModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getDescription());
        RvDocList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Aadhaar Loan Details");
        stringArrayList.add("Aadhaar Loan Documents");
        RvDocList.setAdapter(new AadhaarAdapter(context, stringArrayList, pos -> {
            LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                @Override
                public void AppCallback() {
                    startActivity(new Intent(context, BankDataActivity.class)
                            .putExtra(LoanConst.AadhaarPos, getIntent().getIntExtra(LoanConst.AadhaarPos, 0)));

                }
            });
        }));
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