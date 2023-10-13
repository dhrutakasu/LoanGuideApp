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

public class LoanSwapCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditTotalInvestment, EditWithdrawalMonth, EditReturnRate, EditTimePeriod;
    private TextView TvSwapAmountFirst, TvSwapAmountSecond, TvSwapAmountThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_calculator_loan);
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
        EditTotalInvestment = (EditText) findViewById(R.id.EditTotalInvestment);
        EditWithdrawalMonth = (EditText) findViewById(R.id.EditWithdrawalMonth);
        EditReturnRate = (EditText) findViewById(R.id.EditReturnRate);
        EditTimePeriod = (EditText) findViewById(R.id.EditTimePeriod);
        TvSwapAmountFirst = (TextView) findViewById(R.id.TvSwapAmountFirst);
        TvSwapAmountSecond = (TextView) findViewById(R.id.TvSwapAmountSecond);
        TvSwapAmountThird = (TextView) findViewById(R.id.TvSwapAmountThird);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanSwapCalculator)+" Calculator");
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
        EditTotalInvestment.setText("");
        EditWithdrawalMonth.setText("");
        EditReturnRate.setText("");
        EditTimePeriod.setText("");
        TvSwapAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvSwapAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvSwapAmountThird.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanSwapCalculatorActivity.this);

        if (EditTotalInvestment.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter total investment amount.", Toast.LENGTH_SHORT).show();
        } else if (EditWithdrawalMonth.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter withdrawal per month amount.", Toast.LENGTH_SHORT).show();
        } else if (EditReturnRate.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter rate.", Toast.LENGTH_SHORT).show();
        } else if (EditTimePeriod.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter years.", Toast.LENGTH_SHORT).show();
        } else {
            double DototalInvestment = Double.parseDouble(EditTotalInvestment.getText().toString());
            double DowithdrawalAmount = Double.parseDouble(EditWithdrawalMonth.getText().toString());
            double DoannualReturnRatePercentage = Double.parseDouble(EditReturnRate.getText().toString());
            double DoannualReturnRate = DoannualReturnRatePercentage / 100.0;
            int Intyears = Integer.parseInt(EditTimePeriod.getText().toString());

            double DomonthlyReturnRate = DoannualReturnRate / 12;
            int Inmonths = Intyears * 12;
            double DofinalValue = DototalInvestment;

            for (int i = 0; i < Inmonths; i++) {
                DofinalValue = DofinalValue * (1 + DomonthlyReturnRate) - DowithdrawalAmount;
            }

            double DototalWithdrawal = DowithdrawalAmount * Inmonths;

            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DototalInvestment);
            builder.append(monthStr);
            TvSwapAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalInterestStr = format.format(DototalWithdrawal);
            builder.append(totalInterestStr);
            TvSwapAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DofinalValue);
            builder.append(totalPaymentStr);
            TvSwapAmountThird.setText(builder.toString());
        }
    }
}