package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.MaintenanceStaffRepository;
import com.example.mallmanagementsystem.repository.SecurityStaffRepository;
import com.example.mallmanagementsystem.repository.StaffAssignmentRepository;

public class StaffService {
    private SecurityStaffRepository securityStaffRepository;
    private MaintenanceStaffRepository maintenanceStaffRepository;
    private StaffAssignmentRepository staffAssignmentRepository;

    public StaffService(SecurityStaffRepository securityStaffRepository, MaintenanceStaffRepository maintenanceStaffRepository, StaffAssignmentRepository staffAssignmentRepository) {
        this.securityStaffRepository = securityStaffRepository;
        this.maintenanceStaffRepository = maintenanceStaffRepository;
        this.staffAssignmentRepository = staffAssignmentRepository;
    }
}
