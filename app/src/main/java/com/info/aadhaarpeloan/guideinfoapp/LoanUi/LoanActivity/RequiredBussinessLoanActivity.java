package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RequiredBussinessLoanActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvBusiness;
    private Button BtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_bussiness_loan);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvBusiness = (TextView) findViewById(R.id.TvBusinessLoan);
        BtnShare = (Button) findViewById(R.id.BtnShare);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnShare.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getRequiredDocument(context).get(1).toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnShare:
                GotoShare();
                break;
        }
    }

    private void GotoShare() {
        String s = TvTitle.getText().toString().trim() + "\nSalaried\n" + TvBusiness.getText().toString() + "\n";
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(intent);
    }
}