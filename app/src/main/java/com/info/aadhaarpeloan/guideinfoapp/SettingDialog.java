package com.info.aadhaarpeloan.guideinfoapp;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.LoanSpalshActivity;

public class SettingDialog extends Dialog {
    private final LoanSpalshActivity activity;
    public ExitListener exitListener;

    public interface ExitListener {

        void onExit();
    }

    public SettingDialog(LoanSpalshActivity activity, Context context, ExitListener exitListener) {
        super(context);
        this.activity = activity;
        this.exitListener = exitListener;
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_setting);
        Button BtnTurnOff = (Button) findViewById(R.id.BtnTurnOff);
        BtnTurnOff.setOnClickListener(view -> {
            exitListener.onExit();
        });
    }
}
