package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.service.StructureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/structure")
public class StructureController {
    private final StructureService structureService;

    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }
}
