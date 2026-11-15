package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.Floor;
import com.example.mallmanagementsystem.model.Mall;
import com.example.mallmanagementsystem.repository.BaseRepository;
import com.example.mallmanagementsystem.repository.InMemoryFloorRepository;
import com.example.mallmanagementsystem.repository.InMemoryMallRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StructureService {
    private final BaseRepository<Mall> mallRepository;
    private final BaseRepository<Floor> floorRepository;

    public StructureService(BaseRepository<Mall> mallRepository, BaseRepository<Floor> floorRepository) {
        this.mallRepository = mallRepository;
        this.floorRepository = floorRepository;
    }

    public Mall saveMall(Mall mall) {
        Mall existingMall=mallRepository.findById(mall.getId());
        if(existingMall!=null){
            mall.setFloors(existingMall.getFloors());
        }else if(mall.getFloors()==null){
            mall.setFloors(new ArrayList<>());
        }
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
        if(this.isMallUsed(id)){
            throw new RuntimeException("Cannot delete: Mall with ID " + id + " is used.");
        }
        Mall mall=mallRepository.findById(id);
        if(mall==null){
            throw new RuntimeException("Cannot delete: Mall with ID " + id + " not found.");
        }
        mallRepository.delete(id);
    }

    public boolean isMallUsed(String id) {
        Mall mall=mallRepository.findById(id);
        if (mall != null && mall.getFloors() != null) {
            return !mall.getFloors().isEmpty();
        }
        return false;
    }

    public Floor saveFloor(Floor floor){
        Floor savedFloor = floorRepository.save(floor);
        List<Mall> allMalls = mallRepository.findAll();
        if(!allMalls.isEmpty()){
            Mall theMall = allMalls.get(0);
            theMall.getFloors().add(savedFloor);
            mallRepository.save(theMall);
        }
        return savedFloor;
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
        List<Mall> allMalls = mallRepository.findAll();
        if(!allMalls.isEmpty()){
            Mall theMall = allMalls.get(0);
            if(theMall.getFloors()!=null){
                theMall.getFloors().removeIf(f -> f.getId().equals(id));
                mallRepository.save(theMall);
            }
        }
        floorRepository.delete(id);
    }

    public String getFloorNewId(){
        return floorRepository.getNewId();
    }

    public List<String> getFloorAllIds(){
        return floorRepository.getAllIds();
    }

}
