package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InFileCustomerRepository extends InFileBaseRepository<Customer> {
    public InFileCustomerRepository(@Value("${repository.customers.file}") String filePath) {
            super(filePath);
        }

    @Override
    protected String extractId( Customer customer ) {
        return customer.getId();
    }

    @Override
    protected TypeReference<List<Customer>> getEntityTypeReference() {
        return new TypeReference<List<Customer>>() {};
    }
}
