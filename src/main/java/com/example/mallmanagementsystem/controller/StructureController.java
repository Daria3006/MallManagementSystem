package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Floor;
import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.service.StructureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

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
        List<Mall> malls = structureService.getAllMalls();
        if (malls.isEmpty()) {
            model.addAttribute("mall", new Mall("M1", "", "", new ArrayList<>(), "", 0));
        } else {
            model.addAttribute("mall", malls.get(0));
        }
        return "Mall/form";
    }

    @PostMapping("/malls")
    public String createMall(@ModelAttribute Mall mall) {
        structureService.saveMall(mall);
        return "redirect:/structure/malls";
    }

    @PostMapping("/malls/{id}/delete")
    public String deleteMall(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            structureService.deleteMall(id);
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/structure/malls";
        }
        return "redirect:/structure/malls";
    }

    @GetMapping("/floors")
    public String getAllFloors(Model model) {
        model.addAttribute("floors", structureService.getAllFloors());
        return "Floor/index";
    }

    @GetMapping("/floors/new")
    public String newFloor(Model model) {
        String newId= structureService.getFloorNewId();
        List<String> floorIds=structureService.getFloorAllIds();
        floorIds.add(0,newId);
        model.addAttribute("floor", new Floor("", 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        model.addAttribute("floorIds",floorIds);
        return "Floor/form";
    }

    @PostMapping("/floors")
    public String createFloor(@ModelAttribute Floor floor) {
        structureService.saveFloor(floor);
        return "redirect:/structure/floors";
    }

    @PostMapping("/floors/{id}/delete")
    public String deleteFloor(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            structureService.deleteFloor(id);
        }catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/structure/floors";
        }
        return "redirect:/structure/floors";
    }
}