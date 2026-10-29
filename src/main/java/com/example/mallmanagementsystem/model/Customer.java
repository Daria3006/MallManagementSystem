package com.example.mallmanagementsystem.model;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private String currency;
    private List<Purchase> purchases;

    public Customer(String id, List<Purchase> purchases, String currency, String name) {
        this.id = id;
        this.purchases = purchases;
        this.currency = currency;
        this.name = name;
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
        this.purchases = purchases;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", purchases=" + purchases +
                '}';
    }
}
