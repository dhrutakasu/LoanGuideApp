package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanConst;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class RequiredHomeLoanActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Button BtnStartMain;
    private ImageView IvBack;
    private TextView TvTitle, TvSalaried, TvSelfEmployed;
    private ConstraintLayout ConsSalaried;
    private ConstraintLayout ConsSelfEmployed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_home_loan);
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
        ConsSalaried = (ConstraintLayout) findViewById(R.id.ConsSalaried);
        ConsSelfEmployed = (ConstraintLayout) findViewById(R.id.ConsSelfEmployed);
    }

    private void GuideListerns() {
        IvBack.setOnClickListener(this);
        TvSalaried.setOnClickListener(this);
        TvSelfEmployed.setOnClickListener(this);
    }

    private void GuideActions() {
        IvBack.setVisibility(View.VISIBLE);
        TvTitle.setText(LoanConst.getRequiredDocument(context).get(0).toString());

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