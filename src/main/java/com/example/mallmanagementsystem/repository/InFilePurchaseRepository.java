package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Purchase;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Primary
public class InFilePurchaseRepository extends InFileBaseRepository<Purchase> {
    public InFilePurchaseRepository(@Value("${repository.purchases.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId( Purchase purchase ) {
        return purchase.getId();
    }

    @Override
    protected TypeReference<List<Purchase>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
