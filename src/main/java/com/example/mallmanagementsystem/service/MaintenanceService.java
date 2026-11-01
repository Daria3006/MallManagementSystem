package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.ElectricalAssetRepository;
import com.example.mallmanagementsystem.repository.MaintenanceTaskRepository;

public class MaintenanceService {
    private final MaintenanceTaskRepository maintenanceTaskRepository;
    private final ElectricalAssetRepository electricalAssetRepository;

    public MaintenanceService(MaintenanceTaskRepository maintenanceTaskRepository, ElectricalAssetRepository electricalAssetRepository) {
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.electricalAssetRepository = electricalAssetRepository;
    }
}
