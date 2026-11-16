package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Purchase;
import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.repository.InFileShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorShopService {
    private final SalesService salesService;
    private final StructureService structureService;

    public FloorShopService(SalesService salesService, StructureService structureService, InFileShopRepository inFileShopRepository) {
        this.salesService = salesService;
        this.structureService = structureService;
    }

    public void saveShop(Shop shop) {
        Shop savedShop = salesService.saveShop(shop);
        structureService.addShopToFloor(savedShop);
    }

    public void deleteShop(String id) {
        Shop shop =salesService.findShopById(id);
        if(salesService.isShopUsed(id)){
            throw new RuntimeException("Cannot delete: Customer with ID " + id + " is used.");
        }
        structureService.deleteShopFromFloor(id,shop.getId());
        salesService.deleteShop(id);
    }

    public List<String> getAllFloorIds() {
        return structureService.getFloorAllIds();
    }

    public void savePurchase(Purchase purchase){
        salesService.savePurchase(purchase);
        Shop updatedShop = salesService.findShopById(purchase.getShopId());
        structureService.addShopToFloor(updatedShop);
    }

    public void deletePurchase(String id) {
        Purchase purchase = salesService.findPurchaseById(id);
        String shopId = purchase.getShopId();
        salesService.deletePurchase(id);
        Shop updatedShop = salesService.findShopById(shopId);
        structureService.addShopToFloor(updatedShop);
    }
}
