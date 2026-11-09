package com.example.mallmanagementsystem.controller;


import com.example.mallmanagementsystem.model.MaintenanceStaff;
import com.example.mallmanagementsystem.model.MaintenanceStaffType;
import com.example.mallmanagementsystem.model.SecurityStaff;
import com.example.mallmanagementsystem.service.StaffService;
import com.sun.tools.javac.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/securityStaff")
    public String getAllSecurityStaff(Model model) {
        List<SecurityStaff> securityStaff = this.staffService.findAllSecurityStaff();
        model.addAttribute("securityStaff", securityStaff);
        return "securityStaff/index";
    }

    @GetMapping("/securityStaff/new")
    public String newSecurityStaff(Model model){
        model.addAttribute("securityStaff", new SecurityStaff("", "", ""));
        return "securityStaff/form";
    }

    @PostMapping("/securityStaff")
    public String createSecurityStaff(@ModelAttribute SecurityStaff securityStaff) {
        staffService.saveSecurityStaff(securityStaff);
        return "redirect:/staff/securityStaff";
    }

    @PostMapping("/securityStaff/{id}/delete")
    public String deleteSecurityStaff(@PathVariable String id){
        staffService.deleteSecurityStaff(id);
        return "redirect:/staff/securityStaff";
    }

    @GetMapping("/maintenanceStaff")
    public String getAllMaintenanceStaff(Model model) {
        List<MaintenanceStaff> maintenanceStaff = this.staffService.findAllMaintenanceStaff();
        model.addAttribute("maintenanceStaff", maintenanceStaff);
        return "maintenanceStaff/index";
    }

    @GetMapping("/maintenanceStaff/new")
    public String newMaintenanceStaff(Model model){
        model.addAttribute("maintenanceStaff", new MaintenanceStaff("", "", new ArrayList<>(), MaintenanceStaffType.CLEANING));
        return "maintenanceStaff/form";
    }

    @PostMapping("/maintenanceStaff")
    public String createMaintenanceStaff(@ModelAttribute MaintenanceStaff maintenanceStaff) {
        staffService.saveMaintenanceStaff(maintenanceStaff);
        return "redirect:/staff/maintenanceStaff";
    }

    @PostMapping("/maintenanceStaff/{id}/delete")
    public String deleteMaintenanceStaff(@PathVariable String id){
        staffService.deleteMaintenanceStaff(id);
        return "redirect:/staff/maintenanceStaff";
    }
}
