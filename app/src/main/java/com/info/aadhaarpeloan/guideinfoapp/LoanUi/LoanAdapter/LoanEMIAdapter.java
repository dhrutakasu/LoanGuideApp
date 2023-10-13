package com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.info.aadhaarpeloan.guideinfoapp.LoanUi.Frag.EMIFragment;
import com.info.aadhaarpeloan.guideinfoapp.LoanUi.LoanActivity.Calculators.LoanEMICalculatorActivity;

public class LoanEMIAdapter extends FragmentPagerAdapter {
    private final int Incount;

    public LoanEMIAdapter(FragmentManager fragmentManager, int count) {
        super(fragmentManager);
        this.Incount = count;
    }

    @Override
    public Fragment getItem(int position) {
        LoanEMICalculatorActivity.InPosLevel = position;
        return new EMIFragment();
    }

    @Override
    public int getItemPosition( Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return Incount;
    }
}
