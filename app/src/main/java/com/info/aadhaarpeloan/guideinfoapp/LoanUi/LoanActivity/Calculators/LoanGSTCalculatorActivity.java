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

public class LoanGSTCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditInitialAmount, EditGstRate;
    private TextView TvGstAmountZero, TvGstAmountFirst, TvGstAmountSecond, TvGstAmountThird, TvGstAmountFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gstcalculator_loan);
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
        EditInitialAmount = (EditText) findViewById(R.id.EditInitialAmount);
        EditGstRate = (EditText) findViewById(R.id.EditGstRate);
        TvGstAmountZero = (TextView) findViewById(R.id.TvGstAmountZero);
        TvGstAmountFirst = (TextView) findViewById(R.id.TvGstAmountFirst);
        TvGstAmountSecond = (TextView) findViewById(R.id.TvGstAmountSecond);
        TvGstAmountThird = (TextView) findViewById(R.id.TvGstAmountThird);
        TvGstAmountFourth = (TextView) findViewById(R.id.TvGstAmountFourth);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanGSTCalculator)+" Calculator");
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
        EditInitialAmount.setText("");
        EditGstRate.setText("");
        TvGstAmountZero.setText(getResources().getString(R.string._00_0000));
        TvGstAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvGstAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvGstAmountThird.setText(getResources().getString(R.string._00_0000));
        TvGstAmountFourth.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanGSTCalculatorActivity.this);
        if (EditInitialAmount.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter initial amount.", Toast.LENGTH_SHORT).show();
        }  else if (EditGstRate.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter gst rate.", Toast.LENGTH_SHORT).show();
        } else {
            double DoinitialAmount = Double.parseDouble(EditInitialAmount.getText().toString());
            double DogstRate = Double.parseDouble(EditGstRate.getText().toString());

            DecimalFormat format = new DecimalFormat("#####0.00");
            double DogstAmount = (DoinitialAmount * DogstRate) / 100;
            double Docgst = DogstAmount / 2;
            double Dosgst = DogstAmount / 2;
            double DototalPayment = DoinitialAmount + DogstAmount;

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String AmountStr = format.format(DoinitialAmount);
            builder.append(AmountStr);
            TvGstAmountZero.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String GSTStr = format.format(DogstAmount);
            builder.append(GSTStr);
            TvGstAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String CGSTStr = format.format(Docgst);
            builder.append(CGSTStr);
            TvGstAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String SGSTStr = format.format(Dosgst);
            builder.append(SGSTStr);
            TvGstAmountThird.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DototalPayment);
            builder.append(totalPaymentStr);
            TvGstAmountFourth.setText(builder.toString());
        }
    }
}