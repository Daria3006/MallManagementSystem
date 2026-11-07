package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.model.MaintenanceTaskStatus;
import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.service.MaintenanceService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/MaintenanceTask")
    public String getMaintenanceTask(Model model) {
        List<MaintenanceTask> maintenanceTasks = this.maintenanceService.findAllMaintenanceTask();
        model.addAttribute("maintenanceTasks", maintenanceTasks);
        return "MaintenanceTask/index";
    }

    @GetMapping("/MaintenanceTask/new")
    public String newMaintenanceTask(Model model){
        model.addAttribute("maintenanceTask", new MaintenanceTask("", "", MaintenanceTaskStatus.ACTIVE, ""));
        return "MaintenanceTask/form";
    }

    @PostMapping("/MaintenanceTask")
    public String createMaintenanceTask(@ModelAttribute MaintenanceTask maintenanceTask){
        maintenanceService.saveMaintenanceTask(maintenanceTask);
        return "redirect:/maintenance/MaintenanceTask";
    }

    @PostMapping("/MaintenanceTask/{id}/delete")
    public String deleteMaintenanceTask(@PathVariable String id){
        maintenanceService.deleteMaintenanceTask(id);
        return "redirect:/maintenance/MaintenanceTask";
    }
}
