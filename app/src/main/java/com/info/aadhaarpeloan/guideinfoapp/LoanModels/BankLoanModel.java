package com.info.aadhaarpeloan.guideinfoapp.LoanModels;

import java.util.ArrayList;

public class BankLoanModel {
    String Title,Description;
    ArrayList<String> DescList,SubDecList;

    public BankLoanModel(String title, String description, ArrayList<String> descList, ArrayList<String> subDecList) {
        Title = title;
        Description = description;
        DescList = descList;
        SubDecList = subDecList;
    }


    public BankLoanModel() {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<String> getDescList() {
        return DescList;
    }

    public void setDescList(ArrayList<String> descList) {
        DescList = descList;
    }

    public ArrayList<String> getSubDecList() {
        return SubDecList;
    }

    public void setSubDecList(ArrayList<String> subDecList) {
        SubDecList = subDecList;
    }

    @Override
    public String toString() {
        return "BankLoanModel{" +
                "Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", DescList=" + DescList +
                ", SubDecList=" + SubDecList +
                '}';
    }
}
