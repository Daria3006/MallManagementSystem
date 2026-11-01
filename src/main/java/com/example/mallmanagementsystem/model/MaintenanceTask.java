package com.example.mallmanagementsystem.model;

public class MaintenanceTask {
    private String id;
    private String description;
    private MaintenanceTaskStatus status;
    private String assignmentId;

    public MaintenanceTask(String id, String description, MaintenanceTaskStatus status, String assignmentId) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.assignmentId = assignmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MaintenanceTaskStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceTaskStatus status) {
        this.status = status;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public String toString() {
        return "MaintenanceTask{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", assignmentId='" + assignmentId + '\'' +
                '}';
    }
}
