package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.ElectricalAsset;
import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.repository.InMemoryElectricalAssetRepository;
import com.example.mallmanagementsystem.repository.InMemoryMaintenanceTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {
    private final InMemoryMaintenanceTaskRepository maintenanceTaskRepository;
    private final InMemoryElectricalAssetRepository electricalAssetRepository;

    public MaintenanceService(InMemoryMaintenanceTaskRepository maintenanceTaskRepository, InMemoryElectricalAssetRepository electricalAssetRepository) {
        this.maintenanceTaskRepository = maintenanceTaskRepository;
        this.electricalAssetRepository = electricalAssetRepository;
    }


    public MaintenanceTask saveMaintenanceTask(MaintenanceTask maintenanceTask) {
        return maintenanceTaskRepository.save(maintenanceTask);
    }

    public List<MaintenanceTask> findAllMaintenanceTask() {
        return maintenanceTaskRepository.findAll();
    }

    public MaintenanceTask findMaintenanceTaskById(String id) {
        MaintenanceTask maintenanceTask = maintenanceTaskRepository.findById(id);
        if (maintenanceTask == null) {
            throw new RuntimeException("MaintenanceTask with ID" + id + "not found");
        }
        return maintenanceTask;
    }

    public void deleteMaintenanceTask(String id) {
        MaintenanceTask maintenanceTask = maintenanceTaskRepository.findById(id);
        if (maintenanceTask == null) {
            throw new RuntimeException("Cannot delete: MaintenanceTask with ID" + id + "not found");
        }
        maintenanceTaskRepository.delete(id);
    }


    public ElectricalAsset saveElectricalAsset(ElectricalAsset electricalAsset) {
        return electricalAssetRepository.save(electricalAsset);
    }

    public List<ElectricalAsset> findAllElectricalAsset() {
        return electricalAssetRepository.findAll();
    }

    public ElectricalAsset findElectricalAssetById(String id) {
        ElectricalAsset electricalAsset = electricalAssetRepository.findById(id);
        if (electricalAsset == null) {
            throw new RuntimeException("ElectricalAsset with ID" + id + "not found");
        }
        return electricalAsset;
    }

    public void deleteElectricalAsset(String id) {
        ElectricalAsset electricalAsset = electricalAssetRepository.findById(id);
        if (electricalAsset == null) {
            throw new RuntimeException("Cannot delete: ElectricalAsset with ID" + id + "not found");
        }
        electricalAssetRepository.delete(id);
    }
}
