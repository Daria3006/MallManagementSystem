package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Shop;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryShopRepository extends InMemoryBaseRepository<Shop> {

    @Override
    protected String extractId(Shop shop) {
        return shop.getId();
    }
}
