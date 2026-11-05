package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.MaintenanceTask;
import com.example.mallmanagementsystem.service.MaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("GET/MaintenanceTask")
    public List<MaintenanceTask> getMaintenanceTask(){
        return this.maintenanceService.findAllMaintenanceTask();
    }

    @GetMapping("GET/MaintenanceTask/new")
    public void newMaintenanceTask(){}

    @GetMapping("POST/MaintenanceTask")
    public void postMaintenanceTask(){}

    @GetMapping("POST/MaintenanceTask/{id}/delete")
    public void deleteMaintenanceTask(@PathVariable String id){}
}
