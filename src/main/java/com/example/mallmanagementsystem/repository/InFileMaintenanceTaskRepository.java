package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InFileMaintenanceTaskRepository extends InFileBaseRepository<MaintenanceTask> {

    public InFileMaintenanceTaskRepository(@Value("${repository.maintenanceTask.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(MaintenanceTask maintenanceTask) {
        return maintenanceTask.getId();
    }

    @Override
    protected TypeReference<List<MaintenanceTask>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
