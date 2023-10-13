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

public class LoanBrokerageCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle, TvReset, TvCalculate;
    private EditText EditBuyAmount, EditSellAmount, EditQuanity;
    private Spinner SpinnerTrade;
    private TextView TvBrokerageAmountFirst, TvBrokerageAmountSecond, TvBrokerageAmountThird, TvBrokerageAmountFourth, TvBrokerageAmountFifth, TvBrokerageAmountSixth;
    private TextView TvBrokerageAmountSeventh, TvBrokerageAmountEighth, TvBrokerageAmountNinth, TvBrokerageAmountTenth, TvBrokerageAmountEleventh, TvBrokerageAmountTwelveth;
    private TextView TvBrokerageAmountThirteen, TvBrokerageAmountFourteen, TvBrokerageAmountFifteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brokerage_calculator_loan);
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
        EditBuyAmount = (EditText) findViewById(R.id.EditBuyAmount);
        EditSellAmount = (EditText) findViewById(R.id.EditSellAmount);
        EditQuanity = (EditText) findViewById(R.id.EditQuanity);
        SpinnerTrade = (Spinner) findViewById(R.id.SpinnerTrade);
        TvBrokerageAmountFirst = (TextView) findViewById(R.id.TvBrokerageAmountFirst);
        TvBrokerageAmountSecond = (TextView) findViewById(R.id.TvBrokerageAmountSecond);
        TvBrokerageAmountThird = (TextView) findViewById(R.id.TvBrokerageAmountThird);
        TvBrokerageAmountFourth = (TextView) findViewById(R.id.TvBrokerageAmountFourth);
        TvBrokerageAmountFifth = (TextView) findViewById(R.id.TvBrokerageAmountFifth);
        TvBrokerageAmountSixth = (TextView) findViewById(R.id.TvBrokerageAmountSixth);
        TvBrokerageAmountSeventh = (TextView) findViewById(R.id.TvBrokerageAmountSeventh);
        TvBrokerageAmountEighth = (TextView) findViewById(R.id.TvBrokerageAmountEighth);
        TvBrokerageAmountNinth = (TextView) findViewById(R.id.TvBrokerageAmountNinth);
        TvBrokerageAmountTenth = (TextView) findViewById(R.id.TvBrokerageAmountTenth);
        TvBrokerageAmountEleventh = (TextView) findViewById(R.id.TvBrokerageAmountEleventh);
        TvBrokerageAmountTwelveth = (TextView) findViewById(R.id.TvBrokerageAmountTwelveth);
        TvBrokerageAmountThirteen = (TextView) findViewById(R.id.TvBrokerageAmountThirteen);
        TvBrokerageAmountFourteen = (TextView) findViewById(R.id.TvBrokerageAmountFourteen);
        TvBrokerageAmountFifteen = (TextView) findViewById(R.id.TvBrokerageAmountFifteen);
    }

    private void LoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvReset.setOnClickListener(this);
        TvCalculate.setOnClickListener(this);
    }

    private void LoanCalInitActions() {
        String[] trade = {"Delivery Equity", "Intraday Equity", "Futures", "Options"};
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanBrokerageCalculator)+" Calculator");
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, trade);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerTrade.setAdapter(arrayAdapter);
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
        EditBuyAmount.setText("");
        EditSellAmount.setText("");
        EditQuanity.setText("");
        SpinnerTrade.setSelection(0);
        TvBrokerageAmountFirst.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountSecond.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountThird.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountFourth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountFifth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountSixth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountSeventh.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountEighth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountNinth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountTenth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountEleventh.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountTwelveth.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountThirteen.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountFourteen.setText(getResources().getString(R.string._00_0000));
        TvBrokerageAmountFifteen.setText(getResources().getString(R.string._00_0000));
    }

    private void GotoLoanCalculate() {
        LoanConst.hideKeyboard(LoanBrokerageCalculatorActivity.this);

        if (EditBuyAmount.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter buy amount.", Toast.LENGTH_SHORT).show();
        } else if (EditSellAmount.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter sell amount.", Toast.LENGTH_SHORT).show();
        } else if (EditQuanity.getText().toString().isEmpty()) {
            Toast.makeText(context, "Please enter quantity.", Toast.LENGTH_SHORT).show();
        } else {

            double DobuyAmount = Double.parseDouble(EditBuyAmount.getText().toString());
            double DosellAmount = Double.parseDouble(EditSellAmount.getText().toString());
            int Inquantity = Integer.parseInt(EditQuanity.getText().toString());
            int IntradeType = SpinnerTrade.getSelectedItemPosition();

            double DototalBuyOrderValue = DobuyAmount * Inquantity;
            double DototalSellOrderValue = DosellAmount * Inquantity;
            double DobuyBrokerage,DosellBrokerage;
            if (IntradeType==0){
                DobuyBrokerage=(DototalBuyOrderValue * 0.001);
                DosellBrokerage=(DototalSellOrderValue * 0.001);
            } else if (IntradeType==1) {
                DobuyBrokerage=(DototalBuyOrderValue * 0.00025);
                DosellBrokerage=(DototalSellOrderValue * 0.00025);
            } else if (IntradeType == 2) {
                DobuyBrokerage=(DototalBuyOrderValue * 0.005);
                DosellBrokerage=(DototalSellOrderValue * 0.005);
            }else {
                DobuyBrokerage=(DototalBuyOrderValue * 0.01);
                DosellBrokerage=(DototalSellOrderValue * 0.01);
            }
            double DosttBuy = DototalBuyOrderValue * 0.001;
            double DosttSell = DototalSellOrderValue * 0.001;
            double DoexchangeBuyTxnCharge = DototalBuyOrderValue * 0.0000325;
            double DoexchangeSellTxnCharge = DototalSellOrderValue * 0.0000325;
            double DogstBuy = (DobuyBrokerage + DoexchangeBuyTxnCharge) * 0.18;
            double DogstSell = (DosellBrokerage + DoexchangeSellTxnCharge) * 0.18;
            double DosebiBuyCharges = DototalBuyOrderValue * 0.000000015;
            double DosebiSellCharges = DototalSellOrderValue * 0.000000015;
            double DostampDuty = DototalBuyOrderValue * 0.00015;
            double DototalTaxAndCharges = DobuyBrokerage + DosellBrokerage + DosttBuy + DosttSell +
                    DoexchangeBuyTxnCharge + DoexchangeSellTxnCharge + DogstBuy + DogstSell +
                    DosebiBuyCharges + DosebiSellCharges + DostampDuty;
            double netProfitOrLoss = DototalSellOrderValue - DototalBuyOrderValue - DototalTaxAndCharges;


            DecimalFormat format = new DecimalFormat("#####0.00");

            StringBuilder builder = new StringBuilder();
            builder.append("₹ ");
            String totalBuyOrderValueStr = format.format(DototalBuyOrderValue);
            builder.append(totalBuyOrderValueStr);
            TvBrokerageAmountFirst.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String totalSellOrderValueStr = format.format(DototalSellOrderValue);
            builder.append(totalSellOrderValueStr);
            TvBrokerageAmountSecond.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String buyBrokerageStr = format.format(DobuyBrokerage);
            builder.append(buyBrokerageStr);
            TvBrokerageAmountThird.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String sellBrokerageStr = format.format(DosellBrokerage);
            builder.append(sellBrokerageStr);
            TvBrokerageAmountFourth.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String sttBuyStr = format.format(DosttBuy);
            builder.append(sttBuyStr);
            TvBrokerageAmountFifth.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String sttSellStr = format.format(DosttSell);
            builder.append(sttSellStr);
            TvBrokerageAmountSixth.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String exchangeBuyTxnChargeStr = format.format(DoexchangeBuyTxnCharge);
            builder.append(exchangeBuyTxnChargeStr);
            TvBrokerageAmountSeventh.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String exchangeSellTxnChargeStr = format.format(DoexchangeSellTxnCharge);
            builder.append(exchangeSellTxnChargeStr);
            TvBrokerageAmountEighth.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String gstBuyStr = format.format(DogstBuy);
            builder.append(gstBuyStr);
            TvBrokerageAmountNinth.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String gstSellStr = format.format(DogstSell);
            builder.append(gstSellStr);
            TvBrokerageAmountTenth.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String sebiBuyChargesStr = format.format(DosebiBuyCharges);
            builder.append(sebiBuyChargesStr);
            TvBrokerageAmountEleventh.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String sebiSellChargesStr = format.format(DosebiSellCharges);
            builder.append(sebiSellChargesStr);
            TvBrokerageAmountTwelveth.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String stampDutyStr = format.format(DostampDuty);
            builder.append(stampDutyStr);
            TvBrokerageAmountThirteen.setText(builder.toString()); builder = new StringBuilder();
            builder.append("₹ ");
            String totalTaxAndChargesStr = format.format(DototalTaxAndCharges);
            builder.append(totalTaxAndChargesStr);
            TvBrokerageAmountFourteen.setText(builder.toString());
            builder = new StringBuilder();
            builder.append("₹ ");
            String netProfitOrLossStr = format.format(netProfitOrLoss);
            builder.append(netProfitOrLossStr);
            TvBrokerageAmountFifteen.setText(builder.toString());
        }
    }
}