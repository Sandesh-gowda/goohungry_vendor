package com.goohungrry.ecode.network;

public interface ResponseHandler {
    public void onSuccess(String responce,Object data, int urlId,int position);

    public void onFailure(Exception e, int urlId);
}
