package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCustomerRepository extends InMemoryBaseRepository<Customer> implements CustomerRepository {

    @Override
    protected String extractId(Customer customer) {
        return customer.getId();
    }
}
