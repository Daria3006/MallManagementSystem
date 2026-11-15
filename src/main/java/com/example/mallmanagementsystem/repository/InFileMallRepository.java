package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Mall;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Primary
public class InFileMallRepository extends InFileBaseRepository<Mall> {
    public InFileMallRepository(@Value("${repository.malls.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId( Mall mall ) {
        return mall.getId();
    }

    @Override
    protected TypeReference<List<Mall>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
