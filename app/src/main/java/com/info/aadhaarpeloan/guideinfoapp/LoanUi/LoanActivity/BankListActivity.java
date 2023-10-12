package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.BankDescModelItem;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.FAQsModel;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.AadhaarAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BankListActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle;
    private RecyclerView RvBankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        RvBankList = (RecyclerView) findViewById(R.id.RvBankList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText("Bank List");
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < LoanConst.GotoBankLoanList(context).size(); i++) {
            stringArrayList.add(LoanConst.GotoBankLoanList(context).get(i).getTitle());
        }
        RvBankList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        RvBankList.setAdapter(new AadhaarAdapter(context, stringArrayList, pos -> {
            LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                @Override
                public void AppCallback() {
                    startActivity(new Intent(context, BankDetailActivity.class).putExtra(LoanConst.AadhaarDetail, stringArrayList.get(pos)));
                }
            });
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