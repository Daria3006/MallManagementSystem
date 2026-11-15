package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.model.StaffAssignment;
import com.example.mallmanagementsystem.repository.BaseRepository;
import com.example.mallmanagementsystem.repository.InMemoryMaintenanceTaskRepository;
import com.example.mallmanagementsystem.repository.InMemoryStaffAssignmentRepository;
import org.springframework.stereotype.Service;
import tools.jackson.core.ObjectReadContext;

import java.util.List;

@Service
public class MaintenanceTaskStaffAssignmentService {
    BaseRepository<MaintenanceTask> maintenanceTaskRepository;
    BaseRepository<StaffAssignment> staffAssignmentRepository;

    public MaintenanceTaskStaffAssignmentService(BaseRepository<MaintenanceTask> maintenanceTaskRepository, BaseRepository<StaffAssignment> staffAssignmentRepository) {
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
