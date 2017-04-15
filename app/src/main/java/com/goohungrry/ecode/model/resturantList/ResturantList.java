package com.goohungrry.ecode.model.resturantList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 4/11/17.
 */

public class ResturantList {
    private Integer statuscode;
    private String statusMessage;
    private List<Banner> banners = null;
    private List<RestList> rest_list = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<RestList> getRest_list() {
        return rest_list;
    }

    public void setRest_list(List<RestList> rest_list) {
        this.rest_list = rest_list;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
