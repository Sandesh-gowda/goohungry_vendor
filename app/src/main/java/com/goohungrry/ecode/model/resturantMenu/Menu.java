package com.goohungrry.ecode.model.resturantMenu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 4/11/17.
 */

public class Menu {
    private String pid;
    private String rApikey;
    private String pCuisineId;
    private String pCatid;
    private String type;
    private String menuName;
    private String menuUrlId;
    private String menuDesc;
    private String menuPrice;
    private String availability;
    private String discount;
    private String menuSort;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRApikey() {
        return rApikey;
    }

    public void setRApikey(String rApikey) {
        this.rApikey = rApikey;
    }

    public String getPCuisineId() {
        return pCuisineId;
    }

    public void setPCuisineId(String pCuisineId) {
        this.pCuisineId = pCuisineId;
    }

    public String getPCatid() {
        return pCatid;
    }

    public void setPCatid(String pCatid) {
        this.pCatid = pCatid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrlId() {
        return menuUrlId;
    }

    public void setMenuUrlId(String menuUrlId) {
        this.menuUrlId = menuUrlId;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(String menuSort) {
        this.menuSort = menuSort;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
