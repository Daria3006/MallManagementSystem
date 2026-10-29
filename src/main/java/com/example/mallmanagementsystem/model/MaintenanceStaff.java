package com.example.mallmanagementsystem.model;

import java.util.List;

public class MaintenanceStaff extends Staff{
    private List<StaffAssignment> assignments;
    private String type;

    public MaintenanceStaff(String id, String name, List<StaffAssignment> assignments, String type) {
        super(id, name);
        this.assignments = assignments;
        this.type = type;
    }

    public List<StaffAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<StaffAssignment> assignments) {
        this.assignments = assignments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MaintenanceStaff{" +
                "assignments=" + assignments +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
