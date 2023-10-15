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

public class LoanInflationCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditAmount, EditInitialYear, EditFinalYears;
    private TextView TvAnsResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflation_calculator_loan);
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
        EditAmount = (EditText) findViewById(R.id.EditAmount);
        EditInitialYear = (EditText) findViewById(R.id.EditInitialYear);
        EditFinalYears = (EditText) findViewById(R.id.EditFinalYears);
        TvAnsResult = (TextView) findViewById(R.id.TvAnsResult);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanInflationCalculator)+" Calculator");
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
        EditAmount.setText("");
        EditInitialYear.setText("");
        EditFinalYears.setText("");
        TvAnsResult.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanInflationCalculatorActivity.this);

        if (EditAmount.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter amount.", Toast.LENGTH_SHORT).show();
        } else if (EditInitialYear.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter initial year.", Toast.LENGTH_SHORT).show();
        } else if (EditFinalYears.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter final year.", Toast.LENGTH_SHORT).show();
        } else {
            double DoinitialAmount = Double.parseDouble(EditAmount.getText().toString());
            int IninitialYear = Integer.parseInt(EditInitialYear.getText().toString());
            int InfinalYear = Integer.parseInt(EditFinalYears.getText().toString());

            if (InfinalYear <= IninitialYear) {
                System.out.println("Final year must be greater than the initial year.");
                return;
            }
            if (IninitialYear < 1997 || IninitialYear > 2016 || InfinalYear < 1998 || InfinalYear > 2017) {
                return;
            }
            double[] inflationRates = {
                    0.045, 0.038, 0.055, 0.048, 0.042, 0.036, 0.034, 0.039, 0.047, 0.052,
                    0.048, 0.043, 0.037, 0.035, 0.042, 0.049, 0.056, 0.051, 0.044, 0.041
            };

            double DoadjustedAmount = calculateInflationAdjustedAmount(DoinitialAmount, IninitialYear, InfinalYear, inflationRates);
            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DoadjustedAmount);
            builder.append(monthStr);
            TvAnsResult.setText(builder.toString());
        }
    }
    public static double calculateInflationAdjustedAmount(double DoinitialAmount, int IninitialYear, int InfinalYear, double[] DoinflationRates) {
        double DoadjustedAmount = DoinitialAmount;
        for (int year = IninitialYear; year <= InfinalYear; year++) {
            if (year - IninitialYear < DoinflationRates.length) {
                DoadjustedAmount *= (1 + DoinflationRates[year - IninitialYear]);
            }
        }
        return DoadjustedAmount;
    }
}