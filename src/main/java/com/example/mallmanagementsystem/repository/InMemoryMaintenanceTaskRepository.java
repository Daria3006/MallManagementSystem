package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMaintenanceTaskRepository extends InMemoryBaseRepository<MaintenanceTask> implements MaintenanceTaskRepository{

    @Override
    protected String extractId(MaintenanceTask entity) {
        return entity.getId();
    }
}
