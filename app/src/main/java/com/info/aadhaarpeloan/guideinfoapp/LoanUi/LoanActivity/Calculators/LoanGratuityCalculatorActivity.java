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

public class LoanGratuityCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditMonthlySalary, EditYearService;
    private TextView TvGratuityAmountFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratuity_calculator_loan);
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
        EditMonthlySalary = (EditText) findViewById(R.id.EditMonthlySalary);
        EditYearService = (EditText) findViewById(R.id.EditYearService);
        TvGratuityAmountFirst = (TextView) findViewById(R.id.TvGratuityAmountFirst);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanGratuityCalculator)+" Calculator");
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
        EditMonthlySalary.setText("");
        EditYearService.setText("");
        TvGratuityAmountFirst.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanGratuityCalculatorActivity.this);

        if (EditMonthlySalary.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter Monthly salary.", Toast.LENGTH_SHORT).show();
        } else if (EditYearService.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter Year Of Service.", Toast.LENGTH_SHORT).show();
        } else {
            double DomonthlySalary = Double.parseDouble(EditMonthlySalary.getText().toString());
            int InyearsOfService = Integer.parseInt(EditYearService.getText().toString());
            if (InyearsOfService >= 100) {
                Toast.makeText(context, "Please enter valid years.", Toast.LENGTH_SHORT).show();
                return;
            }
            double Dogratuity = (DomonthlySalary * InyearsOfService * 15) / 26;
            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String monthStr = format.format(Dogratuity);
            builder.append(monthStr);
            TvGratuityAmountFirst.setText(builder.toString());
        }
    }
}