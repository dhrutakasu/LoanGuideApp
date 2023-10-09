package com.info.aadhaarpeloan.guideinfoapp.LoanModels;

public class BankDescModelItem {

    private String description;

    private String title;

    private String url;

    public BankDescModelItem(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "BankDescModelItem{" +
                        "description = '" + description + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}