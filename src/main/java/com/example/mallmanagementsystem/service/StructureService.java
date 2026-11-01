package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.repository.FloorRepository;
import com.example.mallmanagementsystem.repository.MallRepository;
import org.springframework.stereotype.Service;

@Service
public class StructureService {
    private final MallRepository mallRepository;
    private final FloorRepository floorRepository;

    public StructureService(MallRepository mallRepository, FloorRepository floorRepository) {
        this.mallRepository = mallRepository;
        this.floorRepository = floorRepository;
    }
}
