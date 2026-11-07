package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.service.StructureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/malls")
public class MallController {

    private final StructureService structureService;

    public MallController(StructureService structureService) {
        this.structureService = structureService;
    }

    // 1. GET all: Displays the complete list of objects
    @GetMapping
    public String getAllMalls(Model model) {
        model.addAttribute("malls", structureService.getAllMalls());
        return "Mall/index"; // Points to src/main/resources/templates/Mall/index.html
    }

    // 2. GET new: Shows the form to create a new object
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        // Creates an empty Mall object for the form to bind to
        // Because Mall does not have a default empty constructor, we provide default empty values
        model.addAttribute("mall", new Mall("", "", "", new ArrayList<>(), "", 0));
        return "Mall/form"; // Points to src/main/resources/templates/Mall/form.html
    }

    // 3. POST create: Processes the form and creates the object
    @PostMapping
    public String createMall(@ModelAttribute Mall mall) {
        structureService.saveMall(mall);
        return "redirect:/malls"; // Redirects back to the list after saving
    }

    // 4. POST delete: Deletes the chosen object using POST to avoid DELETE method complexity
    @PostMapping("/{id}/delete")
    public String deleteMall(@PathVariable String id) {
        structureService.deleteMall(id);
        return "redirect:/malls"; // Redirects back to the list after deletion
    }
}