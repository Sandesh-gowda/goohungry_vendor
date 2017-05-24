package com.pinlab.vendor.model.over;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 5/2/17.
 */

public class OrderList implements Serializable{

    private ArrayList<Orderlist> orderlist = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ArrayList<Orderlist> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList  <Orderlist> orderlist) {
        this.orderlist = orderlist;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
