package com.example.mallmanagementsystem.model;

import java.util.List;

public class Mall {
    private String id;
    private String name;
    private String city;
    private List<Floor> floors;

    private String street;
    private int number;

    public Mall(String id, String name, String city, List<Floor> floors, String street, int number) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.floors = floors;
        this.street = street;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Mall{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", floors=" + floors +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
