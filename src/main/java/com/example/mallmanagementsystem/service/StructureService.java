package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Floor;
import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.repository.FloorRepository;
import com.example.mallmanagementsystem.repository.MallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StructureService {
    private final MallRepository mallRepository;
    private final FloorRepository floorRepository;

    public StructureService(MallRepository mallRepository, FloorRepository floorRepository) {
        this.mallRepository = mallRepository;
        this.floorRepository = floorRepository;
    }

    public Mall saveMall(Mall mall) {
        return mallRepository.save(mall);
    }

    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    public Mall getMallById(String id) {
        Mall mall = mallRepository.findById(id);
        if (mall == null) {
            throw new RuntimeException("Mall with ID " + id + " not found.");
        }
        return mall;
    }

    public void deleteMall(String id) {
        Mall mall=mallRepository.findById(id);
        if(mall==null){
            throw new RuntimeException("Cannot delete: Mall with ID " + id + " not found.");
        }
        mallRepository.delete(id);
    }

    public Floor saveFloor(Floor floor){
        return floorRepository.save(floor);
    }

    public List<Floor> getAllFloors(){
        return floorRepository.findAll();
    }

    public Floor getFloorById(String id){
        Floor floor = floorRepository.findById(id);
        if (floor == null) {
            throw new RuntimeException("Floor with ID " + id + " not found.");
        }
        return floor;
    }

    public void deleteFloor(String id){
        Floor floor = floorRepository.findById(id);
        if (floor == null) {
            throw new RuntimeException("Cannot delete: Floor with ID " + id + " not found.");
        }
        floorRepository.delete(id);
    }


}
