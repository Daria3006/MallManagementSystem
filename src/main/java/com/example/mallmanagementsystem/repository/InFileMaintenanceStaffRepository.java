package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceStaff;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class InFileMaintenanceStaffRepository extends InFileBaseRepository<MaintenanceStaff>{
    public InFileMaintenanceStaffRepository(@Value("${repository.maintenanceStaff.file}")String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(MaintenanceStaff maintenanceStaff) {
        return maintenanceStaff.getId();
    }

    @Override
    protected TypeReference<List<MaintenanceStaff>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
