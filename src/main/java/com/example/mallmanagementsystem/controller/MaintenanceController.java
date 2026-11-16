package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.*;
import com.example.mallmanagementsystem.service.ElectricalAssetFloorService;
import com.example.mallmanagementsystem.service.MaintenanceService;

import com.example.mallmanagementsystem.service.MaintenanceTaskStaffAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;
    private final MaintenanceTaskStaffAssignmentService maintenanceTaskStaffAssignmentService;
    private final ElectricalAssetFloorService electricalAssetFloorService;

    public MaintenanceController(MaintenanceService maintenanceService, MaintenanceTaskStaffAssignmentService maintenanceTaskStaffAssignmentService, ElectricalAssetFloorService electricalAssetFloorService) {
        this.maintenanceService = maintenanceService;
        this.maintenanceTaskStaffAssignmentService = maintenanceTaskStaffAssignmentService;
        this.electricalAssetFloorService = electricalAssetFloorService;
    }

    @GetMapping("/maintenanceTasks")
    public String getAllMaintenanceTasks(Model model) {
        List<MaintenanceTask> maintenanceTasks = this.maintenanceService.findAllMaintenanceTask();
        model.addAttribute("maintenanceTasks", maintenanceTasks);
        return "MaintenanceTask/index";
    }

    @GetMapping("/maintenanceTasks/new")
    public String newMaintenanceTask(Model model){
        String newId = maintenanceService.getMaintenanceTaskNewId();
        List<String> maintenanceTaskIds = this.maintenanceService.getMaintenanceTaskAllIds();
        List<String> staffAssignmentsIds = this.maintenanceTaskStaffAssignmentService.getStaffAssignmentAllIds();
        List<String> floorIds = this.electricalAssetFloorService.getAllFloorIds();
        maintenanceTaskIds.add(0, newId);
        model.addAttribute("maintenanceTask", new MaintenanceTask("", "", "", MaintenanceTaskStatus.ACTIVE, ""));
        model.addAttribute("maintenanceTaskIds", maintenanceTaskIds);
        model.addAttribute("staffAssignmentsIds", staffAssignmentsIds);
        model.addAttribute("floorIds", floorIds);
        return "MaintenanceTask/form";
    }

    @PostMapping("/maintenanceTasks")
    public String createMaintenanceTask(@ModelAttribute MaintenanceTask maintenanceTask){
        maintenanceService.saveMaintenanceTask(maintenanceTask);
        return "redirect:/maintenance/maintenanceTasks";
    }

    @PostMapping("/maintenanceTasks/{id}/delete")
    public String deleteMaintenanceTask(@PathVariable String id){
        maintenanceService.deleteMaintenanceTask(id);
        return "redirect:/maintenance/maintenanceTasks";
    }

    @GetMapping("/electricalAssets")
    public String getAllElectricalAssets(Model model) {
        List<ElectricalAsset> electricalAssets = this.maintenanceService.findAllElectricalAsset();
        model.addAttribute("electricalAssets", electricalAssets);
        return "ElectricalAsset/index";
    }

    @GetMapping("/electricalAssets/new")
    public String newElectricalAsset(Model model){
        String newId = maintenanceService.getElectricalAssetNewId();
        List<String> electricalAssetsIds = this.maintenanceService.getElectricalAssetAllIds();
        List<String> floorIds = this.electricalAssetFloorService.getAllFloorIds();
        electricalAssetsIds.add(0, newId);
        model.addAttribute("electricalAsset", new ElectricalAsset("", "", ElectricalAssetType.AC, ElectricalAssetStatus.WORKING));
        model.addAttribute("electricalAssetsIds", electricalAssetsIds);
        model.addAttribute("floorIds", floorIds);
        return "ElectricalAsset/form";
    }

    @PostMapping("/electricalAssets")
    public String createElectricalAsset(@ModelAttribute ElectricalAsset electricalAsset){
        maintenanceService.saveElectricalAsset(electricalAsset);
        return "redirect:/maintenance/electricalAssets";
    }

    @PostMapping("/electricalAssets/{id}/delete")
    public String deleteElectricalAsset(@PathVariable String id, RedirectAttributes redirectAttributes){
        try{
            maintenanceService.deleteElectricalAsset(id);
        } catch(RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/maintenance/electricalAssets";
    }
}
