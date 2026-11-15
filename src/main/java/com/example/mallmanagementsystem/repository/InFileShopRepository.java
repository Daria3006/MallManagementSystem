package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Shop;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Primary
public class InFileShopRepository extends InFileBaseRepository<Shop> {
    public InFileShopRepository(@Value("${repository.shops.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId( Shop shop ) {
        return shop.getId();
    }

    @Override
    protected TypeReference<List<Shop>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
