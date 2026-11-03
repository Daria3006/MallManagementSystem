package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Customer;
import com.example.mallmanagementsystem.model.Purchase;
import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final InMemoryShopRepository shopRepository;
    private final InMemoryPurchaseRepository purchaseRepository;
    private final InMemoryCustomerRepository customerRepository;

    public SalesService(InMemoryShopRepository shopRepository, InMemoryPurchaseRepository purchaseRepository, InMemoryCustomerRepository customerRepository) {
        this.shopRepository = shopRepository;
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
    }

    public Shop saveShop(Shop shop){
        return shopRepository.save(shop);
    }

    public List<Shop> findAllShops(){
        return shopRepository.findAll();
    }

    public Shop findShopById(String id){
        Shop shop = shopRepository.findById(id);
        if (shop == null) {
            throw new RuntimeException("Shop with ID " + id + " not found.");
        }
        return shop;
    }

    public void deleteShop(String id){
        Shop shop = shopRepository.findById(id);
        if (shop == null) {
            throw new RuntimeException("Cannot delete: Shop with ID " + id + " not found.");
        }
        shopRepository.delete(id);
    }

    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> findAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase findPurchaseById(String id){
        Purchase purchase = purchaseRepository.findById(id);
        if (purchase == null) {
            throw new RuntimeException("Purchase with ID " + id + " not found.");
        }
        return purchase;
    }

    public void deletePurchase(String id){
        Purchase purchase = purchaseRepository.findById(id);
        if (purchase == null) {
            throw new RuntimeException("Cannot delete: Purchase with ID " + id + " not found.");
        }
        purchaseRepository.delete(id);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(String id){
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new RuntimeException("Customer with ID " + id + " not found.");
        }
        return customer;
    }

    public void deleteCustomer(String id){
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new RuntimeException("Cannot delete: Customer with ID " + id + " not found.");
        }
        customerRepository.delete(id);
    }
}
