package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RequiredTransferHomeLoanActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnShare;
    private ImageView IvBack;
    private TextView TvTitle, TvSalaried, TvSelfEmployed, TvSalariedLoan, TvSelfEmployedLoan;
    private ConstraintLayout ConsSalaried;
    private ConstraintLayout ConsSelfEmployed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_transfer_home_loan);
        GuideViews();
        GuideListerns();
        GuideActions();
    }

    private void GuideViews() {
        context = this;
        IvBack = (ImageView) findViewById(R.id.IvBack);
        TvTitle = (TextView) findViewById(R.id.TvTitle);
        TvSelfEmployed = (TextView) findViewById(R.id.TvSelfEmployed);
        TvSalaried = (TextView) findViewById(R.id.TvSalaried);
        TvSalariedLoan = (TextView) findViewById(R.id.TvSalariedLoan);
        TvSelfEmployedLoan = (TextView) findViewById(R.id.TvSelfEmployedLoan);
        ConsSalaried = (ConstraintLayout) findViewById(R.id.ConsSalaried);
        ConsSelfEmployed = (ConstraintLayout) findViewById(R.id.ConsSelfEmployed);
        BtnShare = (Button) findViewById(R.id.BtnShare);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        TvSalaried.setOnClickListener(this);
        TvSelfEmployed.setOnClickListener(this);
        BtnShare.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getRequiredDocument(context).get(3).toString());

        ConsSalaried.setVisibility(View.GONE);
        ConsSelfEmployed.setVisibility(View.VISIBLE);
        TvSelfEmployed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
        TvSalaried.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        ConsSelfEmployed.startAnimation(animSlideDown);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.IvBack:
                onBackPressed();
                break;
            case R.id.TvSelfEmployed:
                GotoSelfEmployed();
                break;
            case R.id.TvSalaried:
                GotoSalaried();
                break;
            case R.id.BtnShare:
                GotoShare();
                break;
        }
    }

    private void GotoShare() {
        if (ConsSalaried.getVisibility()==View.VISIBLE) {
            String s = TvTitle.getText().toString().trim() + "\nSalaried\n" + TvSalariedLoan.getText().toString() ;
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(intent);
        }else {
            String s = TvTitle.getText().toString().trim() + "\nSelf Employed\n" + TvSelfEmployedLoan.getText().toString();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(intent);
        }
    }

    private void GotoSelfEmployed() {
        if (ConsSelfEmployed.getVisibility() == View.VISIBLE) {
            Animation animDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
            animDown.setDuration(1200);
            ConsSelfEmployed.startAnimation(animDown);
            animDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    TvSelfEmployed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
                    TvSalaried.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
                    ConsSelfEmployed.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        } else {
            Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
            animSlideDown.setDuration(500);
            ConsSalaried.startAnimation(animSlideDown);
            animSlideDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ConsSelfEmployed.setVisibility(View.VISIBLE);
                    Animation AnimSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    AnimSlideDown.setDuration(1200);
                    TvSelfEmployed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
                    TvSalaried.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
                    ConsSelfEmployed.startAnimation(AnimSlideDown);
                    ConsSalaried.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    private void GotoSalaried() {
        if (ConsSalaried.getVisibility() == View.VISIBLE) {

            Animation animDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
            animDown.setDuration(1200);
            ConsSalaried.startAnimation(animDown);
            animDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ConsSalaried.setVisibility(View.GONE);
                    TvSalaried.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
                    TvSelfEmployed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        } else {
            Animation animDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
            animDown.setDuration(1500);
            ConsSelfEmployed.startAnimation(animDown);
            animDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ConsSalaried.setVisibility(View.VISIBLE);
                    Animation AnimSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    AnimSlideDown.setDuration(1200);
                    ConsSalaried.startAnimation(AnimSlideDown);
                    TvSalaried.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
                    TvSelfEmployed.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down_icon, 0);
                    ConsSelfEmployed.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }
}