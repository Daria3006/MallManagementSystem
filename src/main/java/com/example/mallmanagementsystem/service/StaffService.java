package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.*;
import com.example.mallmanagementsystem.repository.InMemoryMaintenanceStaffRepository;
import com.example.mallmanagementsystem.repository.InMemorySecurityStaffRepository;
import com.example.mallmanagementsystem.repository.InMemoryStaffAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final InMemorySecurityStaffRepository securityStaffRepository;
    private final InMemoryMaintenanceStaffRepository maintenanceStaffRepository;
    private final InMemoryStaffAssignmentRepository staffAssignmentRepository;

    public StaffService(InMemorySecurityStaffRepository securityStaffRepository, InMemoryMaintenanceStaffRepository maintenanceStaffRepository, InMemoryStaffAssignmentRepository staffAssignmentRepository) {
        this.securityStaffRepository = securityStaffRepository;
        this.maintenanceStaffRepository = maintenanceStaffRepository;
        this.staffAssignmentRepository = staffAssignmentRepository;
    }

    public SecurityStaff saveSecurityStaff(SecurityStaff securityStaff) {
        return securityStaffRepository.save(securityStaff);
    }

    public List<SecurityStaff> findAllSecurityStaff() {
        return securityStaffRepository.findAll();
    }

    public SecurityStaff findSecurityStaffById(String id) {
        SecurityStaff securityStaff = securityStaffRepository.findById(id);
        if (securityStaff == null) {
            throw new RuntimeException("SecurityStaff with ID" + id + "not found");
        }
        return securityStaff;
    }

    public void deleteSecurityStaff(String id) {
        SecurityStaff securityStaff = securityStaffRepository.findById(id);
        if (securityStaff == null) {
            throw new RuntimeException("Cannot delete: SecurityStaff with ID" + id + "not found");
        }
        securityStaffRepository.delete(id);
    }

    public MaintenanceStaff saveMaintenanceStaff(MaintenanceStaff maintenanceStaff) {
        return maintenanceStaffRepository.save(maintenanceStaff);
    }

    public List<MaintenanceStaff> findAllMaintenanceStaff() {
        return maintenanceStaffRepository.findAll();
    }

    public MaintenanceStaff findMaintenanceStaffById(String id) {
        MaintenanceStaff maintenanceStaff = maintenanceStaffRepository.findById(id);
        if (maintenanceStaff == null) {
            throw new RuntimeException("MaintenanceStaff with ID" + id + "not found");
        }
        return maintenanceStaff;
    }

    public void deleteMaintenanceStaff(String id) {
        MaintenanceStaff maintenanceStaff = maintenanceStaffRepository.findById(id);
        if (maintenanceStaff == null) {
            throw new RuntimeException("Cannot delete: MaintenanceStaff with ID" + id + "not found");
        }
        maintenanceStaffRepository.delete(id);
    }


    public StaffAssignment saveStaffAssignment(StaffAssignment staffAssignment) {
        return staffAssignmentRepository.save(staffAssignment);
    }

    public List<StaffAssignment> findAllStaffAssignment() {
        return staffAssignmentRepository.findAll();
    }

    public StaffAssignment findStaffAssignmentById(String id) {
        StaffAssignment staffAssignment = staffAssignmentRepository.findById(id);
        if (staffAssignment == null) {
            throw new RuntimeException("StaffAssignment with ID" + id + "not found");
        }
        return staffAssignment;
    }

    public void deleteStaffAssignment(String id) {
        StaffAssignment staffAssignment = staffAssignmentRepository.findById(id);
        if (staffAssignment == null) {
            throw new RuntimeException("Cannot delete: StaffAssignment with ID" + id + "not found");
        }
        staffAssignmentRepository.delete(id);
    }
}
