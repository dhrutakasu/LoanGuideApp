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

public class LoanEPFCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditCurrentEPF, EditBasicSalary, EditEmployerEPF,EditContribution,EditIncreaseSalary,EditAgeRetire,EditAge,EditCurrentInterest;
    private TextView TvEPFAmountFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epf_calculator_loan);
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
        EditCurrentEPF = (EditText) findViewById(R.id.EditCurrentEPF);
        EditBasicSalary = (EditText) findViewById(R.id.EditBasicSalary);
        EditEmployerEPF = (EditText) findViewById(R.id.EditEmployerEPF);
        EditContribution = (EditText) findViewById(R.id.EditContribution);
        EditIncreaseSalary = (EditText) findViewById(R.id.EditIncreaseSalary);
        EditAgeRetire = (EditText) findViewById(R.id.EditAgeRetire);
        EditAge = (EditText) findViewById(R.id.EditAge);
        EditCurrentInterest = (EditText) findViewById(R.id.EditCurrentInterest);
        TvEPFAmountFirst = (TextView) findViewById(R.id.TvEPFAmountFirst);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanEPFCalculator)+" Calculator");
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
        EditCurrentEPF.setText("");
        EditBasicSalary.setText("");
        EditEmployerEPF.setText("");
        EditAge.setText("");
        EditContribution.setText("");
        EditAgeRetire.setText("");
        EditCurrentInterest.setText("");
        EditIncreaseSalary.setText("");
        TvEPFAmountFirst.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanEPFCalculatorActivity.this);

        if (EditCurrentEPF.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter current pf.", Toast.LENGTH_SHORT).show();
        } else if (EditBasicSalary.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter basic pf.", Toast.LENGTH_SHORT).show();
        } else if (EditEmployerEPF.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter employee contribution.", Toast.LENGTH_SHORT).show();
        } else if (EditCurrentInterest.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter years.", Toast.LENGTH_SHORT).show();
        } else if (EditAgeRetire.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter retire age.", Toast.LENGTH_SHORT).show();
        } else if (EditAge.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter your age.", Toast.LENGTH_SHORT).show();
        } else if (EditContribution.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter your contribution.", Toast.LENGTH_SHORT).show();
        } else if (EditIncreaseSalary.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter increase salary.", Toast.LENGTH_SHORT).show();
        } else {
            double DocurrentEPFBalance = Double.parseDouble(EditCurrentEPF.getText().toString()); // Rs
            double DobasicSalaryMonthly = Double.parseDouble(EditBasicSalary.getText().toString()); // Rs
            double DoemployerContributionEPF = Double.parseDouble(EditEmployerEPF.getText().toString()); // %
            double DoyourContributionEPF = Double.parseDouble(EditContribution.getText().toString()); // %
            double DoannualIncreaseInSalary = Double.parseDouble(EditIncreaseSalary.getText().toString()); // %
            int InageWhenYouIntendToRetire = Integer.parseInt(EditAgeRetire.getText().toString()); // years
            int InyourAge = Integer.parseInt(EditAge.getText().toString()); // years
            double DocurrentEPFInterestRate = Double.parseDouble(EditCurrentInterest.getText().toString()); // %
            double DototalPFBalances=calculateTotalPFContribution(DocurrentEPFBalance,DobasicSalaryMonthly,DoemployerContributionEPF,DoyourContributionEPF,DoannualIncreaseInSalary,InageWhenYouIntendToRetire,InyourAge,DocurrentEPFInterestRate);

            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder sb = new StringBuilder();
            sb.append("₹ ");
            String monthStr = format.format(DototalPFBalances);
            sb.append(monthStr);
            TvEPFAmountFirst.setText(sb.toString());
        }
    }
    public static double calculateTotalPFContribution(double DocurrentEPFBalance, double DobasicSalaryMonthly, double DoemployerContributionPercentage, double DoemployeeContributionPercentage, double DoannualIncreaseInSalary, int InretireAge, int IncurrentAge, double DocurrentEPFInterestRate) {
        double DototalPFContribution = 0;
        int InyearsUntilRetirement = InretireAge - IncurrentAge;
        for (int i = 0; i < InyearsUntilRetirement; i++) {
            double annualContribution = (DobasicSalaryMonthly * DoemployeeContributionPercentage / 100) + (DobasicSalaryMonthly * DoemployerContributionPercentage / 100);
            DocurrentEPFBalance += annualContribution;
            double interestEarned = DocurrentEPFBalance * (DocurrentEPFInterestRate / 100);
            DocurrentEPFBalance += interestEarned;
            DobasicSalaryMonthly += (DobasicSalaryMonthly * DoannualIncreaseInSalary / 100);
        }
        DototalPFContribution = DocurrentEPFBalance;
        return DototalPFContribution;
    }
}