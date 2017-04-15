package com.goohungrry.ecode.model.resturantMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linuxy on 4/11/17.
 */

public class ResturantMenu {
    private String uuid;
    private String name;
    private List<String> cusin = null;
    private String type;
    private String image;
    private List<Catogory> catogory = null;
    private String location;
    private String city;
    private String locality;
    private String deliveryCharges;
    private List<String> servings = null;
    private String costoftwo;
    private String address;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCusin() {
        return cusin;
    }

    public void setCusin(List<String> cusin) {
        this.cusin = cusin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Catogory> getCatogory() {
        return catogory;
    }

    public void setCatogory(List<Catogory> catogory) {
        this.catogory = catogory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public List<String> getServings() {
        return servings;
    }

    public void setServings(List<String> servings) {
        this.servings = servings;
    }

    public String getCostoftwo() {
        return costoftwo;
    }

    public void setCostoftwo(String costoftwo) {
        this.costoftwo = costoftwo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
