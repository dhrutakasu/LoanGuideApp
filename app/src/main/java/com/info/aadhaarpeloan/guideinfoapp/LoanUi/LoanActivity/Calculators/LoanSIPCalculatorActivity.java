package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.text.DecimalFormat;

public class LoanSIPCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvExpectedAmount, TvInvestmentAmount, TvWealthGain, TvReset, TvCalculate;
    private EditText EditMonthlyInvest, EditInvestmentPeriod, EditAnnualAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sipcalculator_loan);
        LoanCalInitViews();
        LoanCalInitListeners();
        LoanCalInitActions();
    }

    private void LoanCalInitViews() {
        context = this;
        ImgBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        EditMonthlyInvest = (EditText) findViewById(R.id.EditMonthlyInvest);
        EditAnnualAmount = (EditText) findViewById(R.id.EditAnnualAmount);
        EditInvestmentPeriod = (EditText) findViewById(R.id.EditInvestmentPeriod);
        TvExpectedAmount = (TextView) findViewById(R.id.TvExpectedAmount);
        TvInvestmentAmount = (TextView) findViewById(R.id.TvInvestmentAmount);
        TvWealthGain = (TextView) findViewById(R.id.TvWealthGain);
        TvReset = (TextView) findViewById(R.id.TvReset);
        TvCalculate = (TextView) findViewById(R.id.TvCalculate);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanSIPCalculator)+" Calculator");
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
        EditMonthlyInvest.setText("");
        EditAnnualAmount.setText("");
        EditInvestmentPeriod.setText("");
        TvExpectedAmount.setText(getResources().getString(R.string._00_0000));
        TvWealthGain.setText(getResources().getString(R.string._00_0000));
        TvInvestmentAmount.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        String StrmonthlyInvestment = EditMonthlyInvest.getText().toString();
        String StrannualReturnRate = EditMonthlyInvest.getText().toString();
        String StrinvestmentPeriod = EditInvestmentPeriod.getText().toString();
        LoanConst.hideKeyboard(LoanSIPCalculatorActivity.this);
        if (TextUtils.isEmpty(StrmonthlyInvestment) && TextUtils.isEmpty(StrannualReturnRate) && TextUtils.isEmpty(StrinvestmentPeriod)) {
            Toast.makeText(context, "Please Enter Value.", Toast.LENGTH_SHORT).show();
        } else {
            DecimalFormat format = new DecimalFormat("#####0.00");
            SipCalculator calculator = new SipCalculator();
            double Doamountttt = calculator.getTotalValue();
            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            builder.append(format.format(Doamountttt));
            TvExpectedAmount.setText(builder.toString());

            Doamountttt = calculator.getEstimatedReturns();
            builder = new StringBuilder();
            builder.append("₹ ");
            builder.append(format.format(Doamountttt));
            TvWealthGain.setText(builder.toString());

            Doamountttt = calculator.getTotalInvestedAmount();
            builder = new StringBuilder();
            builder.append("₹ ");
            builder.append(format.format(Doamountttt));
            TvInvestmentAmount.setText(builder.toString());
        }
    }

    public class SipCalculator {
        private int IntmonthlyInvestmentAmountInt = Integer.parseInt(EditMonthlyInvest.getText().toString());
        private int IntexpectedReturnRateInt = Integer.parseInt(EditAnnualAmount.getText().toString());
        private int IntinvestmentTimePeriodInt = Integer.parseInt(EditInvestmentPeriod.getText().toString()) * 12;

        public SipCalculator() {
        }

        public long getTotalInvestedAmount() {
            return (long) (IntmonthlyInvestmentAmountInt * IntinvestmentTimePeriodInt);
        }

        public double getEstimatedReturns() {
            return getTotalValue() - getTotalInvestedAmount();
        }

        public double getTotalValue() {
            double DofutureValue = 0;
            double DoannualReturnRate = IntexpectedReturnRateInt / 100.0;
            double DomonthlyReturnRate = DoannualReturnRate / 12;
            for (int i = 0; i < IntinvestmentTimePeriodInt; i++) {
                DofutureValue += IntmonthlyInvestmentAmountInt;
                DofutureValue += DofutureValue * DomonthlyReturnRate;
            }
            return DofutureValue;
        }

    }
}