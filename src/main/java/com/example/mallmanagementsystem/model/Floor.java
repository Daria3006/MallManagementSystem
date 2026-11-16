package com.example.mallmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private String id;
    private int number;
    private List<Shop> shops = new ArrayList<>();
    private List<MaintenanceTask> tasks = new ArrayList<>();
    private List<ElectricalAsset> electricals = new ArrayList<>();
    private List<StaffAssignment> assignments;

    public Floor() {
    }

    public Floor(String id, int number, List<Shop> shops, List<MaintenanceTask> tasks, List<ElectricalAsset> electricals, List<StaffAssignment> assignments) {
        this.id = id;
        this.number = number;
        if (shops != null) {
            this.shops = shops;
        }
        if (tasks != null) {
            this.tasks = tasks;
        }
        if (electricals != null) {
            this.electricals = electricals;
        }
        this.assignments = assignments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        if (shops != null) {
            this.shops = shops;
        }
    }

    public List<MaintenanceTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<MaintenanceTask> tasks) {
        if (tasks != null) {
            this.tasks = tasks;
        }
    }

    public List<ElectricalAsset> getElectricals() {
        return electricals;
    }

    public void setElectricals(List<ElectricalAsset> electricals) {
        if (electricals != null) {
            this.electricals = electricals;
        }
    }

    public List<StaffAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<StaffAssignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", shops=" + shops +
                ", tasks=" + tasks +
                ", electricals=" + electricals +
                ", assignments=" + assignments +
                '}';
    }
}

