package com.info.aadhaarpeloan.guideinfoapp.LoanUi.Frag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanEMICalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.text.DecimalFormat;

public class EMIFragment extends Fragment implements View.OnClickListener {
    private int EMI_POS = LoanEMICalculatorActivity.InPosLevel;
    private View EMIView;
    private Context context;
    private TextView TvMonthlyEMI, TvLoanAnsFirst, TvLoanAnsSecond, TvLoanAnsThird, TvLoanAmountFirst, TvLoanAmountSecond, TvLoanAmountThird, TvReset, TvCalculate;
    private EditText EditMonthlyEMI, EditLoanYear, EditLoanMonth, EditLoanRate;
    private int INtYears, IntMonths;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EMIView = inflater.inflate(R.layout.fragment_emi, container, false);
        LoanCalInitViews();
        LoanCalInitListeners();
        LoanCalInitActions();
        return EMIView;
    }

    private void LoanCalInitViews() {
        context = getContext();
        TvMonthlyEMI = (TextView) EMIView.findViewById(R.id.TvMonthlyEMI);
        TvLoanAnsFirst = (TextView) EMIView.findViewById(R.id.TvLoanAnsFirst);
        TvLoanAnsSecond = (TextView) EMIView.findViewById(R.id.TvLoanAnsSecond);
        TvLoanAnsThird = (TextView) EMIView.findViewById(R.id.TvLoanAnsThird);
        TvLoanAmountFirst = (TextView) EMIView.findViewById(R.id.TvLoanAmountFirst);
        TvLoanAmountSecond = (TextView) EMIView.findViewById(R.id.TvLoanAmountSecond);
        TvLoanAmountThird = (TextView) EMIView.findViewById(R.id.TvLoanAmountThird);
        TvReset = (TextView) EMIView.findViewById(R.id.TvReset);
        TvCalculate = (TextView) EMIView.findViewById(R.id.TvCalculate);
        EditMonthlyEMI = (EditText) EMIView.findViewById(R.id.EditMonthlyEMI);
        EditLoanYear = (EditText) EMIView.findViewById(R.id.EditLoanYear);
        EditLoanMonth = (EditText) EMIView.findViewById(R.id.EditLoanMonth);
        EditLoanRate = (EditText) EMIView.findViewById(R.id.EditLoanRate);
    }

    private void LoanCalInitListeners() {
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        GotoLoanReset();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TvReset:
                GotoLoanReset();
                break;
            case R.id.TvCalculate:
                GotoLoanCalculate();
                break;
        }
    }

    private void GotoLoanReset() {
        System.out.println("-- - - -  EMI_POSReset " + EMI_POS);
        if (EMI_POS == 0) {
            TvMonthlyEMI.setText(context.getString(R.string.monthly_emi_title));
            TvLoanAnsFirst.setText(context.getString(R.string.loan_amount_title));
            TvLoanAnsSecond.setText(context.getString(R.string.total_interest_title));
            TvLoanAnsThird.setText(context.getString(R.string.total_payment_title));
            TvLoanAmountFirst.setText(context.getString(R.string._00_0000));
            TvLoanAmountSecond.setText(context.getString(R.string._00_0000));
            TvLoanAmountThird.setText(context.getString(R.string._00_0000));
            EditMonthlyEMI.setHint(context.getString(R.string.emi));
            EditLoanYear.setHint(context.getString(R.string.years));
            EditLoanMonth.setHint(context.getString(R.string.months));
            EditLoanRate.setHint(context.getString(R.string.rate_per));
        } else if (EMI_POS == 1 || EMI_POS == 2 || EMI_POS == 3) {
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
        EditMonthlyEMI.setText("");
        EditLoanYear.setText("");
        EditLoanMonth.setText("");
        EditLoanRate.setText("");
    }

    private void GotoLoanCalculate() {
        System.out.println("-- - - -  EMI_POS " + EMI_POS);
        LoanConst.hideKeyboard(getActivity());
        DecimalFormat format = new DecimalFormat("#####0.00");
        if (EMI_POS == 0) {
            if (EditMonthlyEMI.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter monthly EMI.", Toast.LENGTH_SHORT).show();
            } else if (EditLoanYear.getText().toString().isEmpty() && EditLoanMonth.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter period.", Toast.LENGTH_SHORT).show();
            } else if (EditLoanRate.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter rate.", Toast.LENGTH_SHORT).show();
            } else {
                if (EditLoanYear.getText().toString().isEmpty()) {
                    INtYears = 0;
                } else {
                    INtYears = Integer.parseInt(EditLoanYear.getText().toString());
                }
                if (EditLoanMonth.getText().toString().isEmpty()) {
                    IntMonths = 0;
                } else {
                    IntMonths = Integer.parseInt(EditLoanMonth.getText().toString());
                }
                double DomonthlyEMI = Double.parseDouble(EditMonthlyEMI.getText().toString());
                double DoannualInterestRate = Double.parseDouble(EditLoanRate.getText().toString());

                int IntotalMonths = INtYears * 12 + IntMonths;

                double DomonthlyInterestRate = (DoannualInterestRate / 12) / 100;
                double DoloanAmount = calculateLoanAmount(DomonthlyEMI, DomonthlyInterestRate, IntotalMonths);
                double DototalInterest = (DomonthlyEMI * IntotalMonths) - DoloanAmount;
                double DototalPayment = DomonthlyEMI * IntotalMonths;
                StringBuilder builder = new StringBuilder();
                builder.append("₹ ");
                String monthStr = format.format(DoloanAmount);
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
        } else if (EMI_POS == 1 || EMI_POS == 2 || EMI_POS == 3) {
            if (EditMonthlyEMI.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter loan amount.", Toast.LENGTH_SHORT).show();
            } else if (EditLoanYear.getText().toString().isEmpty() && EditLoanMonth.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter period.", Toast.LENGTH_SHORT).show();
            } else if (EditLoanRate.getText().toString().isEmpty()) {
                Toast.makeText(context, "Please enter rate.", Toast.LENGTH_SHORT).show();
            } else {
                if (EditLoanYear.getText().toString().isEmpty()) {
                    INtYears = 0;
                } else {
                    INtYears = Integer.parseInt(EditLoanYear.getText().toString());
                }
                if (EditLoanMonth.getText().toString().isEmpty()) {
                    IntMonths = 0;
                } else {
                    IntMonths = Integer.parseInt(EditLoanMonth.getText().toString());
                }
                double DoloanAmount = Double.parseDouble(EditMonthlyEMI.getText().toString());
                double DointerestRate = Double.parseDouble(EditLoanRate.getText().toString());

                double DomonthlyInterestRate = DointerestRate / 12 / 100;
                int IntotalMonths = INtYears * 12 + IntMonths;
                double DomonthlyEMI = calculateMonthlyEMI(DoloanAmount, DomonthlyInterestRate, IntotalMonths);
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
    }

    public static double calculateLoanAmount(double DomonthlyEMI, double DomonthlyInterestRate, int IntotalMonths) {
        double DoloanAmount;
        DoloanAmount = (DomonthlyEMI * (Math.pow(1 + DomonthlyInterestRate, IntotalMonths) - 1)) / (DomonthlyInterestRate * Math.pow(1 + DomonthlyInterestRate, IntotalMonths));
        return DoloanAmount;
    }

    public static double calculateMonthlyEMI(double DoloanAmount, double DomonthlyInterestRate, int IntotalMonths) {
        double Doemi = (DoloanAmount * DomonthlyInterestRate * Math.pow(1 + DomonthlyInterestRate, IntotalMonths)) / (Math.pow(1 + DomonthlyInterestRate, IntotalMonths) - 1);
        return Doemi;
    }
}
