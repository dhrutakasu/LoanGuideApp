package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.text.DecimalFormat;

public class LoanRdCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditMonthlyInvestement, EditRateOfInterest, EditYears;
    private Spinner SpinnerTimePeriod;
    private TextView TvRDAmountFirst, TvRDAmountSecond, TvRDAmountThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd_calculator_loan);
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
        EditMonthlyInvestement = (EditText) findViewById(R.id.EditMonthlyInvestement);
        EditRateOfInterest = (EditText) findViewById(R.id.EditRateOfInterest);
        EditYears = (EditText) findViewById(R.id.EditYears);
        SpinnerTimePeriod = (Spinner) findViewById(R.id.SpinnerTimePeriod);
        TvRDAmountFirst = (TextView) findViewById(R.id.TvRDAmountFirst);
        TvRDAmountSecond = (TextView) findViewById(R.id.TvRDAmountSecond);
        TvRDAmountThird = (TextView) findViewById(R.id.TvRDAmountThird);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        String[] timePeriod = {"Yearly", "Half Yearly", "Quarterly", "Monthly"};

        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanRdCalculator)+" Calculator");
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, timePeriod);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerTimePeriod.setAdapter(arrayAdapter);
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
        EditMonthlyInvestement.setText("");
        EditRateOfInterest.setText("");
        EditYears.setText("");
        SpinnerTimePeriod.setSelection(0);
        TvRDAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvRDAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvRDAmountThird.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanRdCalculatorActivity.this);

        if (EditMonthlyInvestement.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter monthly investment.", Toast.LENGTH_SHORT).show();
        } else if (EditRateOfInterest.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter rate of interest.", Toast.LENGTH_SHORT).show();
        } else if (EditYears.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter years.", Toast.LENGTH_SHORT).show();
        } else {
            double DomonthlyInvestment = Double.parseDouble(EditMonthlyInvestement.getText().toString());
            double DoannualInterestRate = Double.parseDouble(EditRateOfInterest.getText().toString()) / 100;
            int Inyears = Integer.parseInt(EditYears.getText().toString());
            int IntimePeriodType = SpinnerTimePeriod.getSelectedItemPosition();

            int IncompoundingFrequency;
            switch (IntimePeriodType) {
                case 0:
                    IncompoundingFrequency = 1;
                    break;
                case 1:
                    IncompoundingFrequency = 2;
                    break;
                case 2:
                    IncompoundingFrequency = 4;
                    break;
                case 3:
                    IncompoundingFrequency = 12;
                    break;
                default:
                    System.out.println("Invalid time period type.");
                    return;
            }

            int IntotalPeriods = Inyears * IncompoundingFrequency;
            double DototalInterest = 0;
            double DodepositedAmount = 0;
            for (int i = 0; i < IntotalPeriods; i++) {
                DodepositedAmount += DomonthlyInvestment;
                DototalInterest += (DodepositedAmount + DototalInterest) * (DoannualInterestRate / IncompoundingFrequency);
            }

            double DomaturityAmount = DodepositedAmount + DototalInterest;
            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(DototalInterest);
            builder.append(monthStr);
            TvRDAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalInterestStr = format.format(DodepositedAmount);
            builder.append(totalInterestStr);
            TvRDAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalPaymentStr = format.format(DomaturityAmount);
            builder.append(totalPaymentStr);
            TvRDAmountThird.setText(builder.toString());
        }
    }
}