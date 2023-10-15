package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.LoanEMIAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanEMICalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView ImgBack;
    private TextView TvTitle;
    private TextView TvLoanAmountBtn, TvMonthlyEMIBtn, TvTotalInterestBtn, TvTotalPaymentBtn;
    private ViewPager ViewPagerEMI;
    private LoanEMIAdapter loanEmiAdapter;
    public static int InPosLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicalculator_loan);
        LoanLoanCalInitViews();
        LoanLoanCalInitListeners();
        LoanLoanCalInitActions();
    }

    private void LoanLoanCalInitViews() {
        context = this;
        ImgBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvLoanAmountBtn = (TextView) findViewById(R.id.TvLoanAmountBtn);
        TvMonthlyEMIBtn = (TextView) findViewById(R.id.TvMonthlyEMIBtn);
        TvTotalInterestBtn = (TextView) findViewById(R.id.TvTotalInterestBtn);
        TvTotalPaymentBtn = (TextView) findViewById(R.id.TvTotalPaymentBtn);
        ViewPagerEMI = (ViewPager) findViewById(R.id.ViewPagerEMI);
    }

    private void LoanLoanCalInitListeners() {
        ImgBack.setOnClickListener(this);
        TvLoanAmountBtn.setOnClickListener(this);
        TvMonthlyEMIBtn.setOnClickListener(this);
        TvTotalInterestBtn.setOnClickListener(this);
        TvTotalPaymentBtn.setOnClickListener(this);
        ViewPagerEMI.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    GotoLoanButtonsCheck(TvLoanAmountBtn, position);
                } else if (position == 1) {
                    GotoLoanButtonsCheck(TvMonthlyEMIBtn, position);
                } else if (position == 2) {
                    GotoLoanButtonsCheck(TvTotalInterestBtn, position);
                } else if (position == 3) {
                    GotoLoanButtonsCheck(TvTotalPaymentBtn, position);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void GotoLoanButtonsCheck(TextView textView, int i) {
        TvLoanAmountBtn.setBackgroundResource(R.drawable.ic_tab_view_unselected);
        TvMonthlyEMIBtn.setBackgroundResource(R.drawable.ic_tab_view_unselected);
        TvTotalInterestBtn.setBackgroundResource(R.drawable.ic_tab_view_unselected);
        TvTotalPaymentBtn.setBackgroundResource(R.drawable.ic_tab_view_unselected);
        textView.setBackgroundResource(R.drawable.ic_tab_view);
        loanEmiAdapter.getItem(i);
    }

    private void LoanLoanCalInitActions() {
        ImgBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanEMICalculator) + " Calculator");
        loanEmiAdapter = new LoanEMIAdapter(getSupportFragmentManager(), 4);
        ViewPagerEMI.setAdapter(loanEmiAdapter);
        GotoLoanButtonsCheck(TvLoanAmountBtn, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.IvBack:
                finish();
                break;
            case R.id.TvLoanAmountBtn:
                ViewPagerEMI.setCurrentItem(0);
                GotoLoanButtonsCheck(TvLoanAmountBtn, ViewPagerEMI.getCurrentItem());
                break;
            case R.id.TvMonthlyEMIBtn:
                ViewPagerEMI.setCurrentItem(1);
                GotoLoanButtonsCheck(TvMonthlyEMIBtn, ViewPagerEMI.getCurrentItem());
                break;
            case R.id.TvTotalInterestBtn:
                ViewPagerEMI.setCurrentItem(2);
                GotoLoanButtonsCheck(TvTotalInterestBtn, ViewPagerEMI.getCurrentItem());
                break;
            case R.id.TvTotalPaymentBtn:
                ViewPagerEMI.setCurrentItem(3);
                GotoLoanButtonsCheck(TvTotalPaymentBtn, ViewPagerEMI.getCurrentItem());
                break;
        }
    }

}