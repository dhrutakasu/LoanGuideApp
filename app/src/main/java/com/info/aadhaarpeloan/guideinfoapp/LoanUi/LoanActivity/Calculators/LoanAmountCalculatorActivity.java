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

public class LoanAmountCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle;
    private TextView TvMonthlyEMI, TvLoanAnsFirst, TvLoanAnsSecond, TvLoanAnsThird, TvLoanAmountFirst, TvLoanAmountSecond, TvLoanAmountThird, TvReset, TvCalculate;
    private EditText EditMonthlyEMI, EditLoanYear, EditLoanMonth, EditLoanRate;
    private int IntYears, IntMonths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_amountcalculator);
        LoanCalInitViews();
        LoanCalInitListeners();
        LoanCalInitActions();
    }

    private void LoanCalInitViews() {
        context = this;
        ImgBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvMonthlyEMI = (TextView) findViewById(R.id.TvMonthlyEMI);
        TvLoanAnsFirst = (TextView) findViewById(R.id.TvLoanAnsFirst);
        TvLoanAnsSecond = (TextView) findViewById(R.id.TvLoanAnsSecond);
        TvLoanAnsThird = (TextView) findViewById(R.id.TvLoanAnsThird);
        TvLoanAmountFirst = (TextView) findViewById(R.id.TvLoanAmountFirst);
        TvLoanAmountSecond = (TextView) findViewById(R.id.TvLoanAmountSecond);
        TvLoanAmountThird = (TextView) findViewById(R.id.TvLoanAmountThird);
        TvReset = (TextView) findViewById(R.id.TvReset);
        TvCalculate = (TextView) findViewById(R.id.TvCalculate);
        EditMonthlyEMI = (EditText) findViewById(R.id.EditMonthlyEMI);
        EditLoanYear = (EditText) findViewById(R.id.EditLoanYear);
        EditLoanMonth = (EditText) findViewById(R.id.EditLoanMonth);
        EditLoanRate = (EditText) findViewById(R.id.EditLoanRate);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanLoanAmountCalculator)+" Calculator");
        GotoLoanReset();
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
        EditMonthlyEMI.setText("");
        EditLoanYear.setText("");
        EditLoanMonth.setText("");
        EditLoanRate.setText("");
        TvMonthlyEMI.setText(context.getString(R.string.loan_amount_title));
        TvLoanAnsFirst.setText(context.getString(R.string.monthly_emi_title));
        TvLoanAnsSecond.setText(context.getString(R.string.total_interest_title));
        TvLoanAnsThird.setText(context.getString(R.string.total_payment_title));
        TvLoanAmountFirst.setText(context.getString(R.string._00_0000));
        TvLoanAmountSecond.setText(context.getString(R.string._00_0000));
        TvLoanAmountThird.setText(context.getString(R.string._00_0000));
        EditMonthlyEMI.setHint(context.getString(R.string.enter_amount_rs));
        EditLoanYear.setHint(context.getString(R.string.years));
        EditLoanMonth.setHint(context.getString(R.string.months));
        EditLoanRate.setHint(context.getString(R.string.rate_per));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanAmountCalculatorActivity.this);
        DecimalFormat format = new DecimalFormat("#####0.00");
        if (EditMonthlyEMI.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter loan amount.", Toast.LENGTH_SHORT).show();
        } else if (EditLoanYear.getText().toString().isEmpty() && EditLoanMonth.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter period.", Toast.LENGTH_SHORT).show();
        } else if (EditLoanRate.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter rate.", Toast.LENGTH_SHORT).show();
        } else {
            if (EditLoanYear.getText().toString().isEmpty()) {
                IntYears = 0;
            } else {
                IntYears = Integer.parseInt(EditLoanYear.getText().toString());
            }
            if (EditLoanMonth.getText().toString().isEmpty()) {
                IntMonths = 0;
            } else {
                IntMonths = Integer.parseInt(EditLoanMonth.getText().toString());
            }
            double DoloanAmount = Double.parseDouble(EditMonthlyEMI.getText().toString());
            double DointerestRate = Double.parseDouble(EditLoanRate.getText().toString());

            double DomonthlyInterestRate = DointerestRate / 12 / 100;
            int IntotalMonths = IntYears * 12 + IntMonths;
            double DomonthlyEMI = calculateLoanAmount(DoloanAmount, DomonthlyInterestRate, IntotalMonths);
            double DototalInterest = DomonthlyEMI * IntotalMonths - DoloanAmount;
            double DototalPayment = DomonthlyEMI * IntotalMonths;
            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DomonthlyEMI);
            builder.append(monthStr);
            TvLoanAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalInterestStr = format.format(DototalInterest);
            builder.append(totalInterestStr);
            TvLoanAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DototalPayment);
            builder.append(totalPaymentStr);
            TvLoanAmountThird.setText(builder.toString());
        }
    }

    public static double calculateLoanAmount(double DoloanAmount, double DomonthlyInterestRate, int IntotalMonths) {
        double Doemi = (DoloanAmount * DomonthlyInterestRate * Math.pow(1 + DomonthlyInterestRate, IntotalMonths)) / (Math.pow(1 + DomonthlyInterestRate, IntotalMonths) - 1);
        return Doemi;
    }
}