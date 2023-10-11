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
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BankDataActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvDocTitle, TvDocDec, TvDetailTitle;
    private RecyclerView RvDocList, RvDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_loan_list_details);

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
        TvDetailTitle = (TextView) findViewById(R.id.TvDetailTitle);
        RvDetailList = (RecyclerView) findViewById(R.id.RvDetailList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText("Loan Details");
        TvDocDec.setText(LoanConst.getLoanBankModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getDescription());
        TvDocTitle.setText("Loan Details");
        TvDetailTitle.setText("Loan Documents");
        RvDocList.setNestedScrollingEnabled(false);
        RvDetailList.setNestedScrollingEnabled(false);

        TvDocTitle.setPaintFlags(TvDocTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        TvDetailTitle.setPaintFlags(TvDocTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        RvDocList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        RvDocList.setAdapter(new AadhaarAdapter(context, LoanConst.getLoanBankModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getDescList(), pos -> {
            startActivity(new Intent(context, BankDataActivity.class));
        }));
        RvDetailList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        RvDetailList.setAdapter(new AadhaarAdapter(context, LoanConst.getLoanBankModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getSubDecList(), pos -> {
            startActivity(new Intent(context, BankDataActivity.class));
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