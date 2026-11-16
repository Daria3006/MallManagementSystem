package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.*;
import com.example.mallmanagementsystem.repository.BaseRepository;
import com.example.mallmanagementsystem.repository.InFileMaintenanceStaffRepository;
import com.example.mallmanagementsystem.repository.InFileSecurityStaffRepository;
import com.example.mallmanagementsystem.repository.InFileStaffAssignmentRepository;
import org.springframework.stereotype.Service;
import tools.jackson.core.ObjectReadContext;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {
    private final BaseRepository<SecurityStaff> securityStaffRepository;
    private final BaseRepository<MaintenanceStaff> maintenanceStaffRepository;
    private final BaseRepository<StaffAssignment> staffAssignmentRepository;

    public StaffService(BaseRepository<SecurityStaff> securityStaffRepository, BaseRepository<MaintenanceStaff> maintenanceStaffRepository, BaseRepository<StaffAssignment> staffAssignmentRepository) {
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

    public String getNewSecurityStaffId() {
        return securityStaffRepository.getNewId();
    }

    public List<String> getAllSecurityStaffIds() {
        return securityStaffRepository.getAllIds();
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
        if (isMaintenanceStaffUsed(id)){
            throw new RuntimeException("Cannot delete: MaintenanceStaff with ID " + id + " is used.");
        }
        maintenanceStaffRepository.delete(id);
    }

    public String getNewId(){
        return maintenanceStaffRepository.getNewId();
    }

    public List<String> getAllMaintenanceStaffIds() {
        return maintenanceStaffRepository.getAllIds();
    }

    public boolean isMaintenanceStaffUsed(String id) {
        for (StaffAssignment staffAssignment : staffAssignmentRepository.findAll()) {
            if (staffAssignment.getStaffId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public StaffAssignment saveStaffAssignment(StaffAssignment staffAssignment) {
        for (MaintenanceStaff staff : maintenanceStaffRepository.findAll()) {
            if (staff.getAssignments() != null &&
                    staff.getAssignments().removeIf(a -> a.getId().equals(staffAssignment.getId()))) {
                maintenanceStaffRepository.delete(staff.getId());
                maintenanceStaffRepository.save(staff);
            }
        }
        if (staffAssignmentRepository.findById(staffAssignment.getId()) != null) {
            staffAssignmentRepository.delete(staffAssignment.getId());
        }
        this.addStaffAssignmentToMaintenanceStaff(staffAssignment);
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

    public void deleteStaffAssignment(String id){
        staffAssignmentRepository.delete(id);
    }

    public String getStaffAssignmentNewId(){
        return staffAssignmentRepository.getNewId();
    }

    public List<String> getStaffAssignmentAllIds(){
        return staffAssignmentRepository.getAllIds();
    }

    public void addStaffAssignmentToMaintenanceStaff(StaffAssignment staffAssignment) {
        MaintenanceStaff maintenanceStaff = this.findMaintenanceStaffById(staffAssignment.getStaffId());
        if (maintenanceStaff != null) {
            if (maintenanceStaff.getAssignments() == null) {
                maintenanceStaff.setAssignments(new ArrayList<>());
            }
            maintenanceStaff.getAssignments().removeIf(p -> p.getId().equals(staffAssignment.getId()));
            maintenanceStaff.addAssignment(staffAssignment);

            maintenanceStaffRepository.delete(maintenanceStaff.getId());
            maintenanceStaffRepository.save(maintenanceStaff);
        }
    }

}
