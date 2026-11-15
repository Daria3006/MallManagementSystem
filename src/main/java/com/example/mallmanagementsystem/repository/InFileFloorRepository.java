package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Floor;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Primary
public class InFileFloorRepository extends InFileBaseRepository<Floor> {
    public InFileFloorRepository(@Value("${repository.floors.file}") String filePath) {
        super(filePath);
    }

    @Override
    protected String extractId( Floor floor ) {
        return floor.getId();
    }

    @Override
    protected TypeReference<List<Floor>> getEntityTypeReference() {
        return new TypeReference<>() {};
    }
}
