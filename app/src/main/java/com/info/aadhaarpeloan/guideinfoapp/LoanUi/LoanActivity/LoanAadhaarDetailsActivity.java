package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanAadhaarDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvAadhaarDetail,TvAadhaarDetail3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_aadhaar_details);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvAadhaarDetail = (TextView) findViewById(R.id.TvAadhaarDetail);
        TvAadhaarDetail3 = (TextView) findViewById(R.id.TvAadhaarDetail3);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getLoanAadhaar().get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)));
        TvAadhaarDetail.setText(getIntent().getStringExtra(LoanConst.AadhaarDetail));
        TvAadhaarDetail3.setText(getIntent().getStringExtra(LoanConst.AadhaarDetail));
        if (getIntent().getIntExtra(LoanConst.AadhaarPos,0)==2){
            TvAadhaarDetail3.setVisibility(View.VISIBLE);
            TvAadhaarDetail.setVisibility(View.GONE);
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
}