package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.ElectricalAssetRepository;
import com.example.mallmanagementsystem.repository.MaintenanceTaskRepository;

public class MaintenanceService {
    private MaintenanceTaskRepository maintenanceTaskRepository;
    private ElectricalAssetRepository electricalAssetRepository;

    public MaintenanceService(MaintenanceTaskRepository maintenanceTaskRepository, ElectricalAssetRepository electricalAssetRepository) {
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.electricalAssetRepository = electricalAssetRepository;
    }
}
