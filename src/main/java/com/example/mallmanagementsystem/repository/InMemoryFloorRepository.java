package com.example.mallmanagementsystem.repository;

import com.example.mallmanagementsystem.model.Floor;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryFloorRepository extends InMemoryBaseRepository<Floor> implements FloorRepository{

    @Override
    protected String extractId(Floor floor) {
        return floor.getId();
    }
}
