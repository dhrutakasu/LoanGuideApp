package com.info.aadhaarpeloan.guideinfoapp.LoanDialogs;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.info.aadhaarpeloan.guideinfoapp.LoanConstants.LoanAdsClass;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.LoanSpalshActivity;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.MainActivity;
import com.info.aadhaarpeloan.guideinfoapp.R;

public class ExitDialog extends Dialog {
    private final MainActivity activity;
    public ExitListener exitListener;

    public interface ExitListener {

        void onExit();
    }

    public ExitDialog(MainActivity activity, Context context, ExitListener exitListener) {
        super(context);
        this.activity = activity;
        this.exitListener = exitListener;
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_exit);
        LoanAdsClass.ShowActivityNativeBannerAds(activity, ((ProgressBar) findViewById(R.id.progressBarNative)), (RelativeLayout) findViewById(R.id.RlNativeExit));

        Button BtnExit = (Button) findViewById(R.id.BtnExit);
        TextView TvDialogNotExit = (TextView) findViewById(R.id.TvDialogNotExit);
        BtnExit.setOnClickListener(view -> {
            exitListener.onExit();
        });
        TvDialogNotExit.setOnClickListener(view -> {
            dismiss();
        });
    }
}
