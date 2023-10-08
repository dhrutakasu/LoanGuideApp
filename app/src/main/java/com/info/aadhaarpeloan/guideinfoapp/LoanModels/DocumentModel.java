package com.info.aadhaarpeloan.guideinfoapp.LoanModels;

import java.util.ArrayList;

public class DocumentModel {
    String Description;
    ArrayList<String> DescList;

    public DocumentModel(String description, ArrayList<String> descList) {
        Description = description;
        DescList = descList;
    }

    public DocumentModel() {

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

    @Override
    public String toString() {
        return "DocumentModel{" +
                "Description='" + Description + '\'' +
                ", DescList=" + DescList +
                '}';
    }
}
