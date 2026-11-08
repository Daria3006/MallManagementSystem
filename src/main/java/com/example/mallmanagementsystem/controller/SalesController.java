package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.service.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/shops")
    public String getAllShops(Model model) {
        List<Shop> shops=this.salesService.findAllShops();
        model.addAttribute("shops",shops);
        return "Shop/index";
    }

    @GetMapping("/shops/new")
    public String newShop(Model model) {
        model.addAttribute("shop",new Shop("",new ArrayList<>(),0,"",""));
        return "Shop/form";
    }

    @PostMapping("/shops")
    public String createShop(@ModelAttribute Shop shop) {
        salesService.saveShop(shop);
        return "redirect:/sales/shops";
    }

    @PostMapping("/shops/{id}/delete")
    public String deleteShop(@PathVariable String id) {
        salesService.deleteShop(id);
        return "redirect:/sales/shops";
    }

}
