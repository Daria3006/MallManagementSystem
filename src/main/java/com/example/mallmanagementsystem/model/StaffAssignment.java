package com.example.mallmanagementsystem.model;

public class StaffAssignment {
    private String id;
    private String staffId;
    private StaffAssignmentShift shift;

    public StaffAssignment() {
    }

    public StaffAssignment(String id, String staffId, StaffAssignmentShift shift) {
        this.id = id;
        this.staffId = staffId;
        this.shift = shift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public StaffAssignmentShift getShift() {
        return shift;
    }

    public void setShift(StaffAssignmentShift shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "StaffAssignment{" +
                "id='" + id + '\'' +
                ", staffId='" + staffId + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }
}
