package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
}
