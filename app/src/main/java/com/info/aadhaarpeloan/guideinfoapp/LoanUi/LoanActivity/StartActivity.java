package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.info.aadhaarpeloan.guideinfoapp.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        BtnStart = (Button) findViewById(R.id.BtnStart);
    }

    private void GuideListerns() {
        BtnStart.setOnClickListener(this);
    }

    private void GuideActions() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnStart:
                startActivity(new Intent(context, NextActivity.class));
                break;
        }
    }
}