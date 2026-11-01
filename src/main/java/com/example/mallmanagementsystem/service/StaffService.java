package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.MaintenanceStaffRepository;
import com.example.mallmanagementsystem.repository.SecurityStaffRepository;
import com.example.mallmanagementsystem.repository.StaffAssignmentRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final SecurityStaffRepository securityStaffRepository;
    private final MaintenanceStaffRepository maintenanceStaffRepository;
    private final StaffAssignmentRepository staffAssignmentRepository;

    public StaffService(SecurityStaffRepository securityStaffRepository, MaintenanceStaffRepository maintenanceStaffRepository, StaffAssignmentRepository staffAssignmentRepository) {
        this.securityStaffRepository = securityStaffRepository;
        this.maintenanceStaffRepository = maintenanceStaffRepository;
        this.staffAssignmentRepository = staffAssignmentRepository;
    }
}
