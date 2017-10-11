package com.pinlab.vendor.model.over;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 5/2/17.
 */

public class Orderlist implements Serializable {

    private String order_code;
    private String apikey;
    private String user;
    private String address;
    private String mobile;
    private String payment;
    private String finalcost;
    private String ordertime;
    private String achoice;
    private List<MenuItem> menu_items = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getFinalcost() {
        return finalcost;
    }

    public void setFinalcost(String finalcost) {
        this.finalcost = finalcost;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getAchoice() {
        return achoice;
    }

    public void setAchoice(String achoice) {
        this.achoice = achoice;
    }

    public List<MenuItem> getMenu_items() {
        return menu_items;
    }

    public void setMenu_items(List<MenuItem> menu_items) {
        this.menu_items = menu_items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
