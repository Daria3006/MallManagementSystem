package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.service.StructureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/structure")
public class StructureController {

    private final StructureService structureService;

    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }

    @GetMapping("/malls")
    public String getAllMalls(Model model) {
        model.addAttribute("malls", structureService.getAllMalls());
        return "Mall/index";
    }
    @GetMapping("/malls/new")
    public String newMall(Model model) {
        model.addAttribute("mall", new Mall("", "", "", new ArrayList<>(), "", 0));
        return "Mall/form";
    }

    @PostMapping("/malls")
    public String createMall(@ModelAttribute Mall mall) {
        structureService.saveMall(mall);
        return "redirect:/structure/malls";
    }

    @PostMapping("/malls/{id}/delete")
    public String deleteMall(@PathVariable String id) {
        structureService.deleteMall(id);
        return "redirect:/structure/malls";
    }
}