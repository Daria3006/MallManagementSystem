package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Floor;
import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.repository.BaseRepository;
import com.example.mallmanagementsystem.repository.InFileShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorShopService {
    private final SalesService salesService;
    private final StructureService structureService;
    private final InFileShopRepository inFileShopRepository;

    public FloorShopService(SalesService salesService, StructureService structureService, InFileShopRepository inFileShopRepository) {
        this.salesService = salesService;
        this.structureService = structureService;
        this.inFileShopRepository = inFileShopRepository;
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
}
