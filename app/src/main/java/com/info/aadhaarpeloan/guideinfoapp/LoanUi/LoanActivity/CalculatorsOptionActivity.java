package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.CalculatorModel;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanBrokerageCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanEMICalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanEPFCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanFDCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanGSTCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanGratuityCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanInflationCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanAmountCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanPPFCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanRdCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanSIPCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanSwapCalculatorActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.CalculatorsAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

public class CalculatorsOptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private RecyclerView RvCalculatorsList;
    private ImageView IvBack;
    private TextView TvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_option);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        RvCalculatorsList = (RecyclerView) findViewById(R.id.RvCalculatorsList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context, ((ProgressBar) findViewById(R.id.progressBar)), (RelativeLayout) findViewById(R.id.RlBannerAd));

        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanFAQs));
        RvCalculatorsList.setLayoutManager(new GridLayoutManager(context, 2));
        ArrayList<CalculatorModel> calculatorModels = new ArrayList<>();
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanBrokerageCalculator), R.drawable.ic_brokreage_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanEMICalculator), R.drawable.ic_emi_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanLoanAmountCalculator), R.drawable.ic_loan_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanFDCalculator), R.drawable.ic_fd_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanSIPCalculator), R.drawable.ic_sip_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanGSTCalculator), R.drawable.ic_gst_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanEPFCalculator), R.drawable.ic_epf_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanPPFCalculator), R.drawable.ic_ppf_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanRdCalculator), R.drawable.ic_rd_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanSwapCalculator), R.drawable.ic_swp_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanInflationCalculator), R.drawable.ic_inflution_calculator));
        calculatorModels.add(new CalculatorModel(getString(R.string.LoanGratuityCalculator), R.drawable.ic_gratuity_calculator));
        CalculatorsAdapter calculatorsAdapter = new CalculatorsAdapter(context, calculatorModels, pos -> {
            GotoCalculatorOpen(pos, calculatorModels);
        });
        RvCalculatorsList.setAdapter(calculatorsAdapter);
    }

    private void GotoCalculatorOpen(int pos, ArrayList<CalculatorModel> calculatorModels) {
        switch (pos) {
            case 0:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanBrokerageCalculatorActivity.class));
                    }
                });
                break;
            case 1:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanEMICalculatorActivity.class));
                    }
                });
                break;
            case 2:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanAmountCalculatorActivity.class));
                    }
                });
                break;
            case 3:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanFDCalculatorActivity.class));
                    }
                });
                break;
            case 4:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanSIPCalculatorActivity.class));
                    }
                });
                break;
            case 5:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanGSTCalculatorActivity.class));
                    }
                });
                break;
            case 6:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanEPFCalculatorActivity.class));
                    }
                });
                break;
            case 7:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanPPFCalculatorActivity.class));
                    }
                });
                break;
            case 8:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanRdCalculatorActivity.class));
                    }
                });
                break;
            case 9:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanSwapCalculatorActivity.class));
                    }
                });
                break;
            case 10:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanInflationCalculatorActivity.class));
                    }
                });
                break;
            case 11:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanGratuityCalculatorActivity.class));
                    }
                });
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
        }
    }
}