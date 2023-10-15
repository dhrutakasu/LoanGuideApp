package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanCalculateActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView IvBack;
    private TextView TvTitle;
    private EditText EdtLoanAmount, EdLoanTime;
    private Button BtnGetBorrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculate);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        BtnGetBorrow = (Button) findViewById(R.id.BtnGetBorrow);
        EdtLoanAmount = (EditText) findViewById(R.id.EdtLoanAmount);
        EdLoanTime = (EditText) findViewById(R.id.EdLoanTime);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnGetBorrow.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityNativeAds(context,((ProgressBar) findViewById(R.id.progressBarNative)),(RelativeLayout) findViewById(R.id.RlNativeAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.GetLoan));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnGetBorrow:
                GotoBorrow();
                break;
        }
    }

    private void GotoBorrow() {
        if (EdtLoanAmount.getText().toString().isEmpty() || EdLoanTime.getText().toString().isEmpty()) {
            Toast.makeText(context, getResources().getString(R.string.LoanFill), Toast.LENGTH_SHORT).show();
        } else {
            LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                @Override
                public void AppCallback() {
                    GotoResult();
                    startActivity(new Intent(context,BankListActivity.class));
                }
            });
        }
    }

    private void GotoResult() {
        double loanAmount = Double.parseDouble(EdtLoanAmount.getText().toString());
        int loanYears = Integer.parseInt(EdLoanTime.getText().toString());
        double annualInterestRate = 0.05;
        double monthlyInterestRate = annualInterestRate / 12;
        int numberOfPayments = loanYears * 12;
        double monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

      }
}