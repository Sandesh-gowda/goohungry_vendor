package com.pinlab.vendor.network;

/**
 * Created by Hemanth A on 10/5/2016.
 */

public enum URLData {
    URL_HOTELS_VENDOR("https://goohungrry.com/stack/v1/vendorResturant", false, true, "", -1),
    URL_HOTELS_LIST("https://goohungrry.com/stack/v1/adminorders", false, true, "", 1),
    URL_HOTELS_MENU_LIST("https://goohungrry.com/stack/v1/menu", false, true, "", 2),
    URL_HOTELS_MENU_DETAILS("https://goohungrry.com/stack/v1/menuDetails", false, true, "", 3),
    URL_HOTELS_MENU_LIST_DETAILS("https://goohungrry.com/stack/v1/menuVendor", false, true, "", 4);


    private String mUrl;
    private boolean showProgress;
    private boolean showNoNetworkAlert;
    private String progressText;
    private int urlId;

    URLData(String url, boolean showProgress, boolean showNoNetworkAlert, String progressText, int urlId) {
        this.mUrl = url;
        this.showProgress = showProgress;
        this.showNoNetworkAlert = showNoNetworkAlert;
        this.progressText = progressText;
        this.urlId = urlId;
    }


    public String getmUrl() {
        return mUrl;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public boolean isShowNoNetworkAlert() {
        return showNoNetworkAlert;
    }

    public String getProgressText() {
        return progressText;
    }

    public int getUrlId() {
        return urlId;
    }

    @Override
    public String toString() {
        return mUrl;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }
}
