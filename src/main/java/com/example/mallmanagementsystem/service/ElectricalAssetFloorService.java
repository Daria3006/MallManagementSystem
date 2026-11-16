package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.ElectricalAsset;
import com.example.mallmanagementsystem.model.Floor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricalAssetFloorService {
    private final StructureService structureService;
    private final MaintenanceService maintenanceService;

    public ElectricalAssetFloorService(StructureService structureService, MaintenanceService maintenanceService) {
        this.structureService = structureService;
        this.maintenanceService = maintenanceService;
    }

    public void saveElectricalAsset(ElectricalAsset electricalAsset) {
        ElectricalAsset savedElectricalAsset = maintenanceService.saveElectricalAsset(electricalAsset);
        structureService.adddElectricalAssetToFloor(savedElectricalAsset);
    }

    public void deleteElectricalAsset(String id) {
        ElectricalAsset electricalAsset = maintenanceService.findElectricalAssetById(id);
        if(isElectricalAssetUsed(id)){
            throw new RuntimeException("Cannot delete: ElectricalAsset with ID " + id + " is used.");
        }
        structureService.deleteShopFromFloor(id, electricalAsset.getId());
        maintenanceService.deleteElectricalAsset(id);
    }

    public String getElectricalAssetNewId(){
        return maintenanceService.getElectricalAssetNewId();
    }

    public List<String> getAllElectricalAssetIds() {
        return maintenanceService.getElectricalAssetAllIds();
    }

    public List<String> getAllFloorIds() {
        return structureService.getFloorAllIds();
    }

    public boolean isElectricalAssetUsed(String id){
        for(Floor floor : structureService.getAllFloors()){
            if (floor.getElectricals().contains(id)){
                return true;
            }
        }
        return false;
    }
}
