package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Customer;
import com.example.mallmanagementsystem.model.PaymentMethod;
import com.example.mallmanagementsystem.model.Purchase;
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

    @GetMapping("/purchases")
    public String getAllPurchases(Model model){
        model.addAttribute("purchases",this.salesService.findAllPurchases());
        return "Purchase/index";
    }

    @GetMapping("/purchases/new")
    public String newPurchase(Model model){
        model.addAttribute("purchase",new Purchase("","","",0, PaymentMethod.CASH));
        return "Purchase/form";
    }

    @PostMapping("/purchases")
    public String createPurchase(@ModelAttribute Purchase purchase) {
        salesService.savePurchase(purchase);
        return "redirect:/sales/purchases";
    }

    @PostMapping("/purchases/{id}/delete")
    public String deletePurchase(@PathVariable String id) {
        salesService.deletePurchase(id);
        return "redirect:/sales/purchases";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model){
        model.addAttribute("customers",this.salesService.findAllCustomers());
        return "Customer/index";
    }

    @GetMapping("/customers/new")
    public String newCustomer(Model model){
        model.addAttribute("customer",new Customer("",new ArrayList<>(),"","",""));
        return "Customer/form";
    }

    @PostMapping("/customers")
    public String createCustomer(@ModelAttribute Customer customer) {
        salesService.saveCustomer(customer);
        return "redirect:/sales/customers";
    }

    @PostMapping("/customers/{id}/delete")
    public String deleteCustomer(@PathVariable String id) {
        salesService.deleteCustomer(id);
        return "redirect:/sales/customers";
    }
}
