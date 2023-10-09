package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;
import com.info.aadhaarpeloan.guideinfoapp.SettingDialog;

public class LoanSpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_loan);
        if (LoanConst.checkDeveloperOptions(LoanSpalshActivity.this)) {
            SettingDialog exitDialog = new SettingDialog(LoanSpalshActivity.this, LoanSpalshActivity.this, () -> {
                startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
                finish();
            });
            exitDialog.show();
            WindowManager.LayoutParams lp = exitDialog.getWindow().getAttributes();
            Window window = exitDialog.getWindow();
            lp.copyFrom(window.getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.gravity = Gravity.BOTTOM;
            window.setAttributes(lp);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LoanSpalshActivity.this, StartActivity.class));
                    finish();
                }
            }, 2000L);
        }
    }
}