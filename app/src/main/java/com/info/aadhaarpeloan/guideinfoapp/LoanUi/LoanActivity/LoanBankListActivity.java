package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.AadhaarAdapter;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.BankAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoanBankListActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private ImageView IvBack;
    private TextView TvTitle;
    private RecyclerView RvDocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_bank_list);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        RvDocList = (RecyclerView) findViewById(R.id.RvDocList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getLoanAadhaar().get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)));
        RvDocList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        RvDocList.setAdapter(new BankAdapter(context, pos -> {
            startActivity(new Intent(context, BankListDetailsActivity.class)
                    .putExtra(LoanConst.AadhaarPos, pos)
                    .putExtra(LoanConst.AadhaarDetail, "Document List"));
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