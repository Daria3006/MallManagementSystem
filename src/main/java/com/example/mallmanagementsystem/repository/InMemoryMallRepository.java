package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Mall;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMallRepository extends InMemoryBaseRepository<Mall> implements MallRepository {

    @Override
    protected String extractId(Mall mall) {
        return mall.getId();
    }
}
