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

public class LoanFDCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle,TvReset,TvCalculate;
    private EditText EditFixedDepositAmount,EditRateInterest,EditHowSave;
    private TextView TvFDAmountFirst,TvFDAmountSecond,TvFDAmountThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdcalculator_loan);
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
        EditFixedDepositAmount = (EditText) findViewById(R.id.EditFixedDepositAmount);
        EditRateInterest = (EditText) findViewById(R.id.EditRateInterest);
        EditHowSave = (EditText) findViewById(R.id.EditHowSave);
        TvFDAmountFirst = (TextView) findViewById(R.id.TvFDAmountFirst);
        TvFDAmountSecond = (TextView) findViewById(R.id.TvFDAmountSecond);
        TvFDAmountThird = (TextView) findViewById(R.id.TvFDAmountThird);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanFDCalculator)+" Calculator");
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
        EditFixedDepositAmount.setText("");
        EditRateInterest.setText("");
        EditHowSave.setText("");
        TvFDAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvFDAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvFDAmountThird.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanFDCalculatorActivity.this);

        if (EditFixedDepositAmount.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter fixed deposit amount.", Toast.LENGTH_SHORT).show();
        }  else if (EditRateInterest.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter rate of interest.", Toast.LENGTH_SHORT).show();
        } else if (EditHowSave.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter years.", Toast.LENGTH_SHORT).show();
        } else {
            double DofdAmount = Double.parseDouble(EditFixedDepositAmount.getText().toString());
            double DointerestRate = Double.parseDouble(EditRateInterest.getText().toString());
            int Inyears =Integer.parseInt(EditHowSave.getText().toString());

            double DointerestAmount = (DofdAmount * DointerestRate * Inyears) / 100;
            double DototalPayment = DofdAmount + DointerestAmount;
            
            DecimalFormat format = new DecimalFormat("#####0.00");
            
            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DofdAmount);
            builder.append(monthStr);
            TvFDAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalInterestStr = format.format(DointerestAmount);
            builder.append(totalInterestStr);
            TvFDAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DototalPayment);
            builder.append(totalPaymentStr);
            TvFDAmountThird.setText(builder.toString());
        }
    }
}