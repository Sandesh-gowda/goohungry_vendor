package com.goohungrry.ecode.model.resturantMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 4/11/17.
 */

public class Catogory {

    private String catagoryName;
    private List<Menu> menu = null;
    private String ccid;
    private String sortid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getSortid() {
        return sortid;
    }

    public void setSortid(String sortid) {
        this.sortid = sortid;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
