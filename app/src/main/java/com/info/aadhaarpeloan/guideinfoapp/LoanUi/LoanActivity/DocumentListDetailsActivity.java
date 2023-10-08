package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter.DocumentListAdapter;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DocumentListDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ImageView IvBack;
    private TextView TvTitle, TvDocTitle, TvDocDec;
    private RecyclerView RvDocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_list_details);

        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvDocDec = (TextView) findViewById(R.id.TvDocDec);
        TvDocTitle = (TextView) findViewById(R.id.TvDocTitle);
        RvDocList = (RecyclerView) findViewById(R.id.RvDocList);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getLoanDocumentList().get(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)));
        TvDocTitle.setText(getIntent().getStringExtra(LoanConst.AadhaarDetail));
        TvDocTitle.setPaintFlags(TvDocTitle.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        TvDocDec.setText(LoanConst.getLoanDocumentModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getDescription());
        RvDocList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        RvDocList.setAdapter(new DocumentListAdapter(context, LoanConst.getLoanDocumentModel(getIntent().getIntExtra(LoanConst.AadhaarPos, 0)).getDescList()));
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