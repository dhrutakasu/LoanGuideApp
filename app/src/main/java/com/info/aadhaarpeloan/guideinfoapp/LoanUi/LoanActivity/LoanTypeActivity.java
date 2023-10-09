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

public class LoanTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Button BtnHomeLoan, BtnEducationLoan, BtnGoldLoan, BtnBusinessLoan, BtnVehicleLoan;
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
        BtnHomeLoan = (Button) findViewById(R.id.BtnHomeLoan);
        BtnEducationLoan = (Button) findViewById(R.id.BtnEducationLoan);
        BtnGoldLoan = (Button) findViewById(R.id.BtnGoldLoan);
        BtnBusinessLoan = (Button) findViewById(R.id.BtnBusinessLoan);
        BtnVehicleLoan = (Button) findViewById(R.id.BtnVehicleLoan);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnHomeLoan.setOnClickListener(this);
        BtnEducationLoan.setOnClickListener(this);
        BtnGoldLoan.setOnClickListener(this);
        BtnBusinessLoan.setOnClickListener(this);
        BtnVehicleLoan.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanType));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnHomeLoan:
                startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, 0));
                break;
            case R.id.BtnGoldLoan:
                startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, 2));
                break;
            case R.id.BtnEducationLoan:
                startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, 3));
                break;
            case R.id.BtnBusinessLoan:
                startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, 1));
                break;
            case R.id.BtnVehicleLoan:
                startActivity(new Intent(context, HomeLoanActivity.class).putExtra(LoanConst.AadhaarPos, 4));
                break;
        }
    }
}