package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceStaff;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMaintenanceStaffRepository extends InMemoryBaseRepository<MaintenanceStaff>{

    @Override
    protected String extractId(MaintenanceStaff entity) {
        return entity.getId();
    }
}
