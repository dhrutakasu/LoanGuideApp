package com.info.aadhaarpeloan.guideinfoapp.LoanModels;

import java.util.ArrayList;

public class CalculatorModel {
    String CalName;
   int CalIcon;

    public CalculatorModel(String calName, int calIcon) {
        CalName = calName;
        CalIcon = calIcon;
    }

    public CalculatorModel() {

    }

    public String getCalName() {
        return CalName;
    }

    public void setCalName(String calName) {
        CalName = calName;
    }

    public int getCalIcon() {
        return CalIcon;
    }

    public void setCalIcon(int calIcon) {
        CalIcon = calIcon;
    }

    @Override
    public String toString() {
        return "CalculatorModel{" +
                "CalName='" + CalName + '\'' +
                ", CalIcon=" + CalIcon +
                '}';
    }
}
