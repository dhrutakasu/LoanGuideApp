package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.text.DecimalFormat;

public class LoanPPFCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditYearlyInvestment, EditRateOfInterest, EditYears;
    private TextView TvPPFAmountFirst, TvPPFAmountSecond, TvPPFAmountThird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppf_calculator_loan);
        LoanCalInitViews();
        LoanCalInitListeners();
        LoanCalInitActions();
    }

    private void LoanCalInitViews() {
        context = this;
        ImgBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvReset = (TextView) findViewById(R.id.TvReset);
        TvCalculate = (TextView) findViewById(R.id.TvCalculate);
        EditYearlyInvestment = (EditText) findViewById(R.id.EditYearlyInvestment);
        EditRateOfInterest = (EditText) findViewById(R.id.EditRateOfInterest);
        EditYears = (EditText) findViewById(R.id.EditYears);
        TvPPFAmountFirst = (TextView) findViewById(R.id.TvPPFAmountFirst);
        TvPPFAmountSecond = (TextView) findViewById(R.id.TvPPFAmountSecond);
        TvPPFAmountThird = (TextView) findViewById(R.id.TvPPFAmountThird);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanPPFCalculator)+" Calculator");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.IvBack:
                finish();
                break;
            case R.id.TvReset:
                GotoLoanReset();
                break;
            case R.id.TvCalculate:
                GotoLoanCalculate();
                break;
        }
    }

    private void GotoLoanReset() {
        EditYearlyInvestment.setText("");
        EditRateOfInterest.setText("");
        EditYears.setText("");
        TvPPFAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvPPFAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvPPFAmountThird.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanPPFCalculatorActivity.this);

        if (EditYearlyInvestment.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter yearly investment.", Toast.LENGTH_SHORT).show();
        } else if (EditRateOfInterest.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter rate of interest.", Toast.LENGTH_SHORT).show();
        } else if (EditYears.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter years.", Toast.LENGTH_SHORT).show();
        } else {
            double DoyearlyInvestment = Double.parseDouble(EditYearlyInvestment.getText().toString());
            double DoannualInterestRate = Double.parseDouble(EditRateOfInterest.getText().toString())/100;
            int Inyears = Integer.parseInt(EditYears.getText().toString());

            double DototalInvestment = DoyearlyInvestment * Inyears;
            double DototalInterest = 0;
            for (int i = 0; i < Inyears; i++) {
                DototalInterest += (DototalInvestment + DototalInterest) * DoannualInterestRate;
            }
            double DomaturityValue = DototalInvestment + DototalInterest;

            DecimalFormat format = new DecimalFormat("#####0.00");
            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DototalInvestment);
            builder.append(monthStr);
            TvPPFAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalInterestStr = format.format(DototalInterest);
            builder.append(totalInterestStr);
            TvPPFAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DomaturityValue);
            builder.append(totalPaymentStr);
            TvPPFAmountThird.setText(builder.toString());
        }
    }
}