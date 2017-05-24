package com.pinlab.vendor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 5/2/17.
 */

public class User {


    private String uuid;
    private String uuidName;
    private String area;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public User(String othid) {
        this.uuid = othid;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
