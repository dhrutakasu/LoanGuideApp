package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanDialogs.ExitDialog;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnStartMain;
    private ImageView IvPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvPrivacy = (ImageView) findViewById(R.id.IvPrivacy);
        BtnStartMain = (Button) findViewById(R.id.BtnStartMain);
    }

    private void GuideListerns() {
        IvPrivacy.setOnClickListener(this);
        BtnStartMain.setOnClickListener(this);
    }

    private void GuideActions() {
        LoanAdsClass.ShowActivityBannerAds(context,((ProgressBar) findViewById(R.id.progressBar)),(RelativeLayout) findViewById(R.id.RlBannerAd));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvPrivacy:
                startActivity(new Intent(context, PrivacyActivity.class));
                break;
            case R.id.BtnStartMain:
                startActivity(new Intent(context, OptionActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        ExitDialog exitDialog = new ExitDialog(MainActivity.this, context, () -> finishAffinity());
        exitDialog.show();
        WindowManager.LayoutParams lp = exitDialog.getWindow().getAttributes();
        Window window = exitDialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);

    }
}