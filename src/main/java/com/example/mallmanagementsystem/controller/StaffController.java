package com.example.mallmanagementsystem.controller;


import com.example.mallmanagementsystem.model.SecurityStaff;
import com.example.mallmanagementsystem.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
