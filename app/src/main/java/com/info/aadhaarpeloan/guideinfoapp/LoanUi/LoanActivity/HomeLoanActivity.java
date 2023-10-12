package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.FAQsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HomeLoanActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvLoanTypeDetail;
    private Button BtnGetLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan);


        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvLoanTypeDetail = (TextView) findViewById(R.id.TvLoanTypeDetail);
        BtnGetLoan = (Button) findViewById(R.id.BtnGetLoan);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        BtnGetLoan.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
        IvBack.setVisibility(View.VISIBLE);
        ArrayList<FAQsModel> faQsModels = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("LoanTypeDetails.json");
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
            JSONArray array = new JSONArray(new String(bytes, StandardCharsets.UTF_8));
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                faQsModels.add(new FAQsModel(object.getString("title"), object.getString("description")));
            }
            TvTitle.setText(faQsModels.get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getFAQsQue());
            TvLoanTypeDetail.setText(faQsModels.get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getFAQsAns());
            TvLoanTypeDetail.setMovementMethod(new ScrollingMovementMethod());

        } catch (IOException | JSONException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.BtnGetLoan:
                LoanAdsClass.ShowActivityInterstitialAd(context, new LoanAdsClass.LoanCallback() {
                    @Override
                    public void AppCallback() {
                        startActivity(new Intent(context, LoanCalculateActivity.class));
                    }
                });
                break;
        }
    }
}