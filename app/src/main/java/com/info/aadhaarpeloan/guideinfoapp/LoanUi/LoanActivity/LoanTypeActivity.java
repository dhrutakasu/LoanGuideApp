package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button BtnLoanAadhaarOption,BtnLoanType;
    private ImageView IvBack;
    private TextView TvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_type);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        BtnLoanAadhaarOption = (Button) findViewById(R.id.BtnLoanAadhaarOption);
        BtnLoanType = (Button) findViewById(R.id.BtnLoanType);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnLoanAadhaarOption.setOnClickListener(this);
        BtnLoanType.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.OptionTitle));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnLoanAadhaarOption:
                startActivity(new Intent(context, LoanOnAdhaarActivity.class));
                break;
            case R.id.BtnLoanType:
                startActivity(new Intent(context, LoanTypeActivity.class));
                break;
        }
    }
}