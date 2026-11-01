package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.MaintenanceTask;

public class InMemoryMaintenanceTaskRepository extends InMemoryBaseRepository<MaintenanceTask> implements MaintenanceTaskRepository{

    @Override
    protected String extractId(MaintenanceTask entity) {
        return entity.getId();
    }
}
