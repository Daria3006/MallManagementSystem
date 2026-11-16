package com.example.mallmanagementsystem.controller;

import com.example.mallmanagementsystem.model.Customer;
import com.example.mallmanagementsystem.model.PaymentMethod;
import com.example.mallmanagementsystem.model.Purchase;
import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.service.FloorShopService;
import com.example.mallmanagementsystem.service.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {
    private final SalesService salesService;
    private final FloorShopService floorShopService;

    public SalesController(SalesService salesService, FloorShopService floorShopService) {
        this.salesService = salesService;
        this.floorShopService = floorShopService;
    }

    @GetMapping("/shops")
    public String getAllShops(Model model) {
        List<Shop> shops=this.salesService.findAllShops();
        model.addAttribute("shops",shops);
        return "Shop/index";
    }

    @GetMapping("/shops/new")
    public String newShop(Model model) {
        String newId=salesService.getShopNewId();
        List<String> shopIds=salesService.getShopAllIds();
        List<String> floorIds=floorShopService.getAllFloorIds();
        shopIds.add(0,newId);
        model.addAttribute("shop",new Shop("",new ArrayList<>(),0,"","",""));
        model.addAttribute("shopIds",shopIds);
        model.addAttribute("floorIds",floorIds);
        return "Shop/form";
    }

    @PostMapping("/shops")
    public String createShop(@ModelAttribute Shop shop) {
        floorShopService.saveShop(shop);
        return "redirect:/sales/shops";
    }

    @PostMapping("/shops/{id}/delete")
    public String deleteShop(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try{
        floorShopService.deleteShop(id);
        }catch(RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/sales/shops";
        }
        return "redirect:/sales/shops";
    }

    @GetMapping("/purchases")
    public String getAllPurchases(Model model){
        model.addAttribute("purchases",this.salesService.findAllPurchases());
        return "Purchase/index";
    }

    @GetMapping("/purchases/new")
    public String newPurchase(Model model){
        String newId=salesService.getPurchaseNewId();
        List<String> purchaseIds=this.salesService.getPurchaseAllIds();
        List<String> customerIds=this.salesService.getCustomerAllIds();
        List<String> shopIds=this.salesService.getShopAllIds();
        purchaseIds.add(0,newId);
        model.addAttribute("purchase",new Purchase("","","",0, PaymentMethod.CASH));
        model.addAttribute("purchaseIds",purchaseIds);
        model.addAttribute("customerIds",customerIds);
        model.addAttribute("shopIds",shopIds);
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
        String newId=salesService.getCustomerNewId();
        List<String> customerIds=this.salesService.getCustomerAllIds();
        customerIds.add(0,newId);
        model.addAttribute("customer",new Customer("",new ArrayList<>(),"","",""));
        model.addAttribute("customerIds",customerIds);
        return "Customer/form";
    }

    @PostMapping("/customers")
    public String createCustomer(@ModelAttribute Customer customer) {
        salesService.saveCustomer(customer);
        return "redirect:/sales/customers";
    }

    @PostMapping("/customers/{id}/delete")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try{
        salesService.deleteCustomer(id);
        }catch(RuntimeException e){
            redirectAttributes.addFlashAttribute("errorMessage","Cannot delete!");
            return "redirect:/sales/customers";
        }
        return "redirect:/sales/customers";
    }
}
