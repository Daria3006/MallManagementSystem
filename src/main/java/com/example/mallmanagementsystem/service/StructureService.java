package com.example.mallmanagementsystem.service;

import com.example.mallmanagementsystem.model.*;
import com.example.mallmanagementsystem.repository.BaseRepository;
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
        Floor existingFloor=floorRepository.findById(floor.getId());
        if(existingFloor!=null){
            floor.setShops(existingFloor.getShops());
            floor.setTasks(existingFloor.getTasks());
            floor.setElectricals(existingFloor.getElectricals());
        }else {
            if(floor.getShops()==null){
                floor.setShops(new ArrayList<>());
                if(floor.getTasks() == null) floor.setTasks(new ArrayList<>());
                if(floor.getElectricals() == null) floor.setElectricals(new ArrayList<>());
            }
        }

        Floor savedFloor = floorRepository.save(floor);
        this.addFloorToMall(savedFloor);
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
        if(this.isFloorUsed(id)){
            throw new RuntimeException("Cannot delete: Floor with ID " + id + " is used.");
        }
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

    private void addFloorToMall(Floor floor){
        List<Mall> allMalls = mallRepository.findAll();
        if(!allMalls.isEmpty()){
            Mall theMall = allMalls.get(0);
            if (theMall.getFloors() == null) {
                theMall.setFloors(new ArrayList<>());
            }
            theMall.getFloors().removeIf(f -> f.getId().equals(floor.getId()));
            theMall.getFloors().add(floor);
            mallRepository.save(theMall);
        }
    }

    public void addShopToFloor(Shop shop){
        if(shop.getFloorId()==null||shop.getFloorId().isEmpty()){
            return;
        }
        Floor floor=floorRepository.findById(shop.getFloorId());
        if(floor!=null){
            if(floor.getShops()==null){
                floor.setShops(new ArrayList<>());
            }
            floor.getShops().removeIf(s -> s.getId().equals(shop.getId()));
            floor.getShops().add(shop);
            floorRepository.save(floor);
            this.addFloorToMall(floor);
        }
    }

    public void deleteShopFromFloor(String shopId,String floorId){
        if(floorId==null||floorId.isEmpty()){return;}
        Floor floor=floorRepository.findById(floorId);
        if(floor!=null && floor.getShops()!=null){
            floor.getShops().removeIf(s -> s.getId().equals(shopId));
            floorRepository.save(floor);
            this.addFloorToMall(floor);
        }

    }

    public void addMaintenanceTaskToFloor(MaintenanceTask task) {
        if (task.getFloorId() == null || task.getFloorId().isEmpty()) return;
        Floor floor = floorRepository.findById(task.getFloorId());
        if (floor != null) {
            if (floor.getTasks() == null) floor.setTasks(new ArrayList<>());
            floor.getTasks().removeIf(t -> t.getId().equals(task.getId()));
            floor.getTasks().add(task);
            floorRepository.save(floor);
            this.addFloorToMall(floor);
        }
    }

    public void deleteMaintenanceTaskFromFloor(String taskId, String floorId) {
        if (floorId == null || floorId.isEmpty()) return;
        Floor floor = floorRepository.findById(floorId);
        if (floor != null && floor.getTasks() != null) {
            floor.getTasks().removeIf(t -> t.getId().equals(taskId));
            floorRepository.save(floor);
            this.addFloorToMall(floor);
        }
    }

    public boolean isFloorUsed(String id){
            Floor floor=floorRepository.findById(id);
            if(floor!=null){
                boolean hasShops=floor.getShops()!=null && !floor.getShops().isEmpty();
                boolean hasTasks = floor.getTasks() != null && !floor.getTasks().isEmpty();
                boolean hasElectricals = floor.getElectricals() != null && !floor.getElectricals().isEmpty();
            return hasShops || hasTasks || hasElectricals ;}
        return false;}

}
