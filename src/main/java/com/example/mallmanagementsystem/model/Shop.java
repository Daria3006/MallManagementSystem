package com.example.mallmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String id;
    private String name;
    private String ownerName;
    private double areaSqm;
    private List<Purchase> purchases = new ArrayList<>();
    private String floorId;

    public Shop() {
    }

    public Shop(String id, List<Purchase> purchases, double areaSqm, String ownerName, String name, String floorId) {
        this.id = id;
        if (purchases != null) {
            this.purchases = purchases;
        }
        this.areaSqm = areaSqm;
        this.ownerName = ownerName;
        this.name = name;
        this.floorId = floorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        if (purchases != null) {
            this.purchases = purchases;
        }
    }

    public double getAreaSqm() {
        return areaSqm;
    }

    public void setAreaSqm(double areaSqm) {
        this.areaSqm = areaSqm;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", areaSqm=" + areaSqm +
                ", purchases=" + purchases +
                '}';
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
}

