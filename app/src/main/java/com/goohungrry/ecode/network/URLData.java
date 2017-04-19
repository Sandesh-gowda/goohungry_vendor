package com.goohungrry.ecode.network;

/**
 * Created by Hemanth A on 10/5/2016.
 */

public enum URLData {
    URL_HOSTED_SERVICE_CALL("", false, true, "", -1),
    URL_HOTELS_LIST("https://goohungrry.com/stack/v1/list", false, true, "", 0);


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
