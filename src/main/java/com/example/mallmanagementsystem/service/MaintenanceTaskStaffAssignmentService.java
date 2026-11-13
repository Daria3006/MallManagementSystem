package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.repository.InMemoryMaintenanceTaskRepository;
import com.example.mallmanagementsystem.repository.InMemoryStaffAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceTaskStaffAssignmentService {
    InMemoryMaintenanceTaskRepository maintenanceTaskRepository;
    InMemoryStaffAssignmentRepository staffAssignmentRepository;

    public MaintenanceTaskStaffAssignmentService(InMemoryMaintenanceTaskRepository maintenanceTaskRepository, InMemoryStaffAssignmentRepository staffAssignmentRepository) {
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.staffAssignmentRepository = staffAssignmentRepository;
    }

    public List<String> getStaffAssignmentAllIds(){
        return staffAssignmentRepository.getAllIds();
    }

    public boolean isStaffAssignmentUsed(String id) {
        for (MaintenanceTask maintenanceTask : maintenanceTaskRepository.findAll()) {
            if (maintenanceTask.getAssignmentId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
