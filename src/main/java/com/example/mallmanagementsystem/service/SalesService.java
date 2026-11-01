package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.CustomerRepository;
import com.example.mallmanagementsystem.repository.PurchaseRepository;
import com.example.mallmanagementsystem.repository.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
    private final ShopRepository shopRepository;
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;

    public SalesService(ShopRepository shopRepository, PurchaseRepository purchaseRepository, CustomerRepository customerRepository) {
        this.shopRepository = shopRepository;
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
    }
}
