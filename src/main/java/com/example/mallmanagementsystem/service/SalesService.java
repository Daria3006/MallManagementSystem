package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Customer;
import com.example.mallmanagementsystem.model.Purchase;
import com.example.mallmanagementsystem.model.Shop;
import com.example.mallmanagementsystem.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final BaseRepository<Shop> shopRepository;
    private final BaseRepository<Purchase> purchaseRepository;
    private final BaseRepository<Customer> customerRepository;

    public SalesService(BaseRepository<Shop> shopRepository, BaseRepository<Purchase> purchaseRepository, BaseRepository<Customer> customerRepository) {
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
        if(isShopUsed(id)){
            throw new RuntimeException("Shop with ID " + id + " is already used.");
        }
        Shop shop = shopRepository.findById(id);
        if (shop == null) {
            throw new RuntimeException("Cannot delete: Shop with ID " + id + " not found.");
        }
        shopRepository.delete(id);
    }

    public String getShopNewId(){
        return shopRepository.getNewId();
    }

    public Purchase savePurchase(Purchase purchase){
        Purchase saved = purchaseRepository.save(purchase);

        Customer customer = customerRepository.findById(purchase.getCustomerId());
        if (customer != null) {
            customer.getPurchases().add(saved);
            customerRepository.save(customer);
        }

        Shop shop = shopRepository.findById(purchase.getShopId());
        if (shop != null) {
            shop.getPurchases().add(saved);
            shopRepository.save(shop);
        }

        return saved;
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

        Customer customer = customerRepository.findById(purchase.getCustomerId());
        if (customer != null && customer.getPurchases() != null) {
            customer.getPurchases().removeIf(p -> p.getId().equals(id));
            customerRepository.save(customer);
        }

        Shop shop = shopRepository.findById(purchase.getShopId());
        if (shop != null && shop.getPurchases() != null) {
            shop.getPurchases().removeIf(p -> p.getId().equals(id));
            shopRepository.save(shop);
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
        if(this.isCustomerUsed(id)){
            throw new RuntimeException("Cannot delete: Customer with ID " + id + " is used.");
        }
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new RuntimeException("Cannot delete: Customer with ID " + id + " not found.");
        }
        customerRepository.delete(id);
    }

    public String getCustomerNewId(){
        return customerRepository.getNewId();
    }

    public String getPurchaseNewId(){
        return  purchaseRepository.getNewId();
    }

    public List<String> getPurchaseAllIds(){
        return purchaseRepository.getAllIds();
    }

    public List<String> getShopAllIds(){
        return shopRepository.getAllIds();
    }

    public List<String> getCustomerAllIds(){
        return customerRepository.getAllIds();
    }

    public boolean isCustomerUsed(String id){
        for(Purchase purchase : purchaseRepository.findAll()){
            if(purchase.getCustomerId()!=null && purchase.getCustomerId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public boolean isShopUsed(String id){
        for(Purchase purchase : purchaseRepository.findAll()){
            if(purchase.getShopId()!=null && purchase.getShopId().equals(id)){
                return true;
            }
        }
        return false;
    }


}
