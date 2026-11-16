package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.model.StaffAssignment;
import com.example.mallmanagementsystem.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceTaskStaffAssignmentService {
    private final MaintenanceService maintenanceService;
    private final StaffService staffService;

    public MaintenanceTaskStaffAssignmentService(MaintenanceService maintenanceService, StaffService staffService) {
        this.maintenanceService = maintenanceService;
        this.staffService = staffService;
    }
    
    public void deleteStaffAssignment(String id) {
        StaffAssignment staffAssignment =staffService.findStaffAssignmentById(id);
        if(isStaffAssignmentUsed(id)){
            throw new RuntimeException("Cannot delete: StaffAssignment with ID " + id + " is used.");
        }
        staffService.deleteStaffAssignment(staffAssignment.getId());
    }

    public List<String> getStaffAssignmentAllIds(){
        return staffService.getStaffAssignmentAllIds();
    }

    public boolean isStaffAssignmentUsed(String id) {
        for (MaintenanceTask maintenanceTask : maintenanceService.findAllMaintenanceTask()) {
            if (maintenanceTask.getAssignmentId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
