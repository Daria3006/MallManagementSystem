package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPurchaseRepository extends InMemoryBaseRepository<Purchase> {

    @Override
    protected String extractId(Purchase purchase) {
        return purchase.getId();
    }
}
