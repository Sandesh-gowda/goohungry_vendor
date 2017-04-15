package com.goohungrry.ecode.model.resturantList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 4/11/17.
 */

public class Banner {

    private String bgurl;
    private String sort;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBgurl() {
        return bgurl;
    }

    public void setBgurl(String bgurl) {
        this.bgurl = bgurl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
