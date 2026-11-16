package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.*;
import com.example.mallmanagementsystem.service.FloorMaintenanceTaskService;
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
    private final FloorMaintenanceTaskService floorMaintenanceTaskService;

    public MaintenanceController(MaintenanceService maintenanceService, MaintenanceTaskStaffAssignmentService maintenanceTaskStaffAssignmentService, FloorMaintenanceTaskService floorMaintenanceTaskService) {
        this.maintenanceService = maintenanceService;
        this.maintenanceTaskStaffAssignmentService = maintenanceTaskStaffAssignmentService;
        this.floorMaintenanceTaskService = floorMaintenanceTaskService;
    }

    @GetMapping("/maintenanceTasks")
    public String getAllMaintenanceTasks(Model model) {
        List<MaintenanceTask> maintenanceTasks = this.maintenanceService.findAllMaintenanceTask();
        model.addAttribute("maintenanceTasks", maintenanceTasks);
        return "maintenanceTask/index";
    }

    @GetMapping("/maintenanceTasks/new")
    public String newMaintenanceTask(Model model){
        String newId = maintenanceService.getMaintenanceTaskNewId();
        List<String> maintenanceTaskIds = this.maintenanceService.getMaintenanceTaskAllIds();
        List<String> staffAssignmentsIds = this.maintenanceTaskStaffAssignmentService.getStaffAssignmentAllIds();
        List<String> floorIds=floorMaintenanceTaskService.getAllFloorIds();
        maintenanceTaskIds.add(0, newId);
        model.addAttribute("maintenanceTask", new MaintenanceTask("", "", "", MaintenanceTaskStatus.ACTIVE, ""));
        model.addAttribute("maintenanceTaskIds", maintenanceTaskIds);
        model.addAttribute("staffAssignmentsIds", staffAssignmentsIds);
        model.addAttribute("floorIds", floorIds);
        return "maintenanceTask/form";
    }

    @PostMapping("/maintenanceTasks")
    public String createMaintenanceTask(@ModelAttribute MaintenanceTask maintenanceTask){
        floorMaintenanceTaskService.saveMaintenanceTask(maintenanceTask);
        return "redirect:/maintenance/maintenanceTasks";
    }

    @PostMapping("/maintenanceTasks/{id}/delete")
    public String deleteMaintenanceTask(@PathVariable String id, RedirectAttributes redirectAttributes){
        try{
        floorMaintenanceTaskService.deleteMaintenanceTask(id);
        }catch(RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/maintenance/maintenanceTasks";
        }
        return "redirect:/maintenance/maintenanceTasks";
    }

    @GetMapping("/electricalAssets")
    public String getAllElectricalAssets(Model model) {
        List<ElectricalAsset> electricalAssets = this.maintenanceService.findAllElectricalAsset();
        model.addAttribute("electricalAssets", electricalAssets);
        return "electricalAsset/index";
    }

    @GetMapping("/electricalAssets/new")
    public String newElectricalAsset(Model model){
        model.addAttribute("electricalAsset", new ElectricalAsset("", "", ElectricalAssetType.LIFT, ElectricalAssetStatus.WORKING));
        return "electricalAsset/form";
    }

    @PostMapping("/electricalAssets")
    public String createElectricalAsset(@ModelAttribute ElectricalAsset electricalAsset){
        maintenanceService.saveElectricalAsset(electricalAsset);
        return "redirect:/maintenance/electricalAssets";
    }

    @PostMapping("/electricalAssets/{id}/delete")
    public String deleteElectricalAsset(@PathVariable String id){
        maintenanceService.deleteElectricalAsset(id);
        return "redirect:/maintenance/electricalAssets";
    }
}
