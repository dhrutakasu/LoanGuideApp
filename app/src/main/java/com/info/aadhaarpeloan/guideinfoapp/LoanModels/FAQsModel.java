package com.info.aadhaarpeloan.guideinfoapp.LoanModels;

public class FAQsModel {
    String FAQsQue, FAQsAns;

    public FAQsModel(String FAQsQue, String FAQsAns) {
        this.FAQsQue = FAQsQue;
        this.FAQsAns = FAQsAns;
    }

    public String getFAQsQue() {
        return FAQsQue;
    }

    public void setFAQsQue(String FAQsQue) {
        this.FAQsQue = FAQsQue;
    }

    public String getFAQsAns() {
        return FAQsAns;
    }

    public void setFAQsAns(String FAQsAns) {
        this.FAQsAns = FAQsAns;
    }

    @Override
    public String toString() {
        return "FAQsModel{" +
                "FAQsQue='" + FAQsQue + '\'' +
                ", FAQsAns='" + FAQsAns + '\'' +
                '}';
    }
}
