package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.AadhaarAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class LoanOnAdhaarActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private RecyclerView RvLoanAadhaar;
    private ImageView IvBack;
    private TextView TvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_on_adhaar);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        RvLoanAadhaar = (RecyclerView) findViewById(R.id.RvLoanAadhaar);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(getResources().getString(R.string.LoanAadhaar));
        RvLoanAadhaar.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        RvLoanAadhaar.setAdapter(new AadhaarAdapter(context, LoanConst.getLoanAadhaar(), pos -> {
            switch (pos) {
                case 0: {
                    startActivity(new Intent(context, LoanAadhaarDetailsActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue1))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 1: {
                    startActivity(new Intent(context, LoanAadhaarDetailsActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue2))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 2: {
                    startActivity(new Intent(context, LoanAadhaarDetailsActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue3))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 3: {
                    startActivity(new Intent(context, LoanBankListActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue3))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 4: {
                    startActivity(new Intent(context, LoanDocumentListActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue4))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 5: {
                    startActivity(new Intent(context, LoanAadhaarDetailsActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue5))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
                case 6: {
                    startActivity(new Intent(context, LoanEliglibilityActivity.class)
                            .putExtra(LoanConst.AadhaarDetail, getResources().getString(R.string.AadhaarQue6))
                            .putExtra(LoanConst.AadhaarPos, pos));
                }
                break;
            }
        }));
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