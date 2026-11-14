package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class InFileMaintenanceTaskRepository extends InFileBaseRepository<MaintenanceTask> {

    public InFileMaintenanceTaskRepository(@Value("${repository.maintenanceTask.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId(MaintenanceTask maintenanceTask) {
        return maintenanceTask.getId();
    }
}
