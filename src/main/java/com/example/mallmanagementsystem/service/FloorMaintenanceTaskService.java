package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorMaintenanceTaskService {
    private final StructureService structureService;
    private final MaintenanceService maintenanceService;

    public FloorMaintenanceTaskService(StructureService structureService, MaintenanceService maintenanceService) {
        this.structureService = structureService;
        this.maintenanceService = maintenanceService;
    }

    public void saveMaintenanceTask(MaintenanceTask maintenanceTask) {
        MaintenanceTask savedTask = maintenanceService.saveMaintenanceTask(maintenanceTask);
        structureService.addMaintenanceTaskToFloor(savedTask);
    }

    public void deleteMaintenanceTask(String taskId) {
        MaintenanceTask maintenanceTask = maintenanceService.findMaintenanceTaskById(taskId);
        structureService.deleteMaintenanceTaskFromFloor(taskId, maintenanceTask.getFloorId());
        maintenanceService.deleteMaintenanceTask(taskId);
    }

    public List<String> getAllFloorIds() {
        return structureService.getFloorAllIds();
    }
}
