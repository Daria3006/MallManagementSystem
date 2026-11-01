package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceStaff;

public class InMemoryMaintenanceStaffRepository extends InMemoryBaseRepository<MaintenanceStaff> implements MaintenanceStaffRepository{

    @Override
    protected String extractId(MaintenanceStaff entity) {
        return entity.getId();
    }
}
