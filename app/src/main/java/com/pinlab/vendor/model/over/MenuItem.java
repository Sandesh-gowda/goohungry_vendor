package com.pinlab.vendor.model.over;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linuxy on 5/2/17.
 */

public class MenuItem   implements Serializable {


    private String menu_name;
    private String menu_cost;
    private String quantity;
    private String totalcost;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_cost() {
        return menu_cost;
    }

    public void setMenu_cost(String menu_cost) {
        this.menu_cost = menu_cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
